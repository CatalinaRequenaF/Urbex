package Urbex;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBcomprobarUsuario {
	public static String getSelector() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql:/http://192.168.56.50:3306/urbex";
		Connection con = DriverManager.getConnection(url, "root", "cicle");
		Statement st = con.createStatement();
		
		String query = "SELECT DISTINCT username, contrasena FROM users";
		ResultSet rs = st.executeQuery(query);
		
		String resultado = "<select id=\"selector\" onchange=\"buscarUsuario()\">"
							+ "<option value=\"*\">All</option>";
		
		while (rs.next()) {
			resultado = resultado
						+ "<option value=\""+rs.getString("users")+"\">"+rs.getString("users")+"</option>";
		}
		
		resultado = resultado + "</select>";
		
		rs.close();
		st.close();
		con.close();
		
		return resultado;
	}
	
	

	public static String selectUsuario(String usuario) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://192.168.56.50:3306/urbex";
		Connection con = DriverManager.getConnection(url, "root", "cicle");
		Statement st = con.createStatement();
		
		String query = "SELECT username, contrasena FROM users WHERE id='"+usuario+"'";
		ResultSet rs = st.executeQuery(query);
		
		String resultado = "<table border=\"1\">"
						+ "<tr>"
						+ "<th>username</th>"
						+ "<th>contrasena</th>"
						+ "</tr>";
		
		while (rs.next()) {
			resultado = resultado 
						+"<tr>"
						+ "<td>"+rs.getString("username")+"</td>"
						+ "<td>"+rs.getString("contrasena")+"</td>"
						
						+"</tr>";
		}
		resultado=resultado+"</table>";
		return resultado;
	}
	
	public static boolean comprobarUsuario(String username, String contrasena) throws IOException {
		boolean estado = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://192.168.56.50:3306/urbex";
			Connection con = DriverManager.getConnection(url, "root", "cicle");
			PreparedStatement queryPreparada = con.prepareStatement("SELECT username, contrasena FROM users where username=? and contrasena=? ;");
			queryPreparada.setString(1, username);
			queryPreparada.setString(2, contrasena);
			ResultSet rs = queryPreparada.executeQuery();

			estado = rs.next();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
			return estado;
			
	}

	
	
}
