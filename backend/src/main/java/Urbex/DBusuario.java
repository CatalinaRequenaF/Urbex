package Urbex;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBusuario {
	public static String getSelector() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql:/http://192.168.56.50:3306/urbex";
		Connection con = DriverManager.getConnection(url, "root", "cicle");
		Statement st = con.createStatement();
		
		String query = "SELECT DISTINCT id FROM users";
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
	
	public static void enviarUsuario(String usuario,  String email, String contrasena ) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://192.168.56.50:3306/urbex";
		Connection con = DriverManager.getConnection(url, "root", "cicle");
		Statement st = con.createStatement();
		
		String query = "INSERT INTO users(username,email,contrasena) VALUES ('"+usuario+"','"+email+"','"+contrasena+"')";
		System.out.println(query);
		st.executeUpdate(query);
		
		st.close();
		con.close();
	}

	public static String selectUsuario(String usuario) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://192.168.56.50:3306/urbex";
		Connection con = DriverManager.getConnection(url, "root", "cicle");
		Statement st = con.createStatement();
		
		String query = "SELECT * FROM users WHERE id='"+usuario+"'";
		ResultSet rs = st.executeQuery(query);
		
		String resultado = "<table border=\"1\">"
						+ "<tr>"
						+ "<th>username</th>"
						+ "<th>email</th>"
						+ "<th>contrasena</th>"
						+ "</tr>";
		
		while (rs.next()) {
			resultado = resultado 
						+"<tr>"
						+ "<td>"+rs.getString("id")+"</td>"
						+ "<td>"+rs.getString("username")+"</td>"
						+ "<td>"+rs.getString("contrasena")+"</td>"
						
						+"</tr>";
		}
		resultado=resultado+"</table>";
		return resultado;
	}
	

	
}
