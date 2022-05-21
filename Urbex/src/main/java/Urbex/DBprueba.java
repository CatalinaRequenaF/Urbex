package Urbex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBprueba {
	public static String getSelector() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://192.168.56.50/urbex";
		Connection con = DriverManager.getConnection(url, "root", "");
		Statement st = con.createStatement();
		
		String query = "SELECT DISTINCT id FROM users";
		ResultSet rs = st.executeQuery(query);
		
		String resultat = "<select id=\"selector\" onchange=\"buscarUsuario()\">"
							+ "<option value=\"*\">All</option>";
		
		while (rs.next()) {
			resultat = resultat 
						+ "<option value=\""+rs.getString("users")+"\">"+rs.getString("users")+"</option>";
		}
		
		resultat = resultat + "</select>";
		
		rs.close();
		st.close();
		con.close();
		
		return resultat;
	}
	
	public static void enviarUsuario(String username,  String email, String contraseña) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "";
		Connection con = DriverManager.getConnection(url, "root", "cicle");
		Statement st = con.createStatement();
		
		String query = "INSERT INTO comments VALUES ('"+username+"','"+contraseña+"','"+email+"')";
		st.executeUpdate(query);
		
		st.close();
		con.close();
	}
	
	public static String selectUsuario(String usuario) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://192.168.56.50/urbex";
		Connection con = DriverManager.getConnection(url, "root", "cicle");
		Statement st = con.createStatement();
		
		String query = "SELECT * FROM users WHERE id='"+usuario+"'";
		ResultSet rs = st.executeQuery(query);
		
		String resultado = "<table border=\"1\">"
						+ "<tr>"
						+ "<th>username</th>"
						+ "<th>email</th>"
						+ "<th>contraseña_id</th>"
						+ "</tr>";
		
		while (rs.next()) {
			resultado = resultado 
						+"<tr>"
						+ "<td>"+rs.getString("id")+"</td>"
						+ "<td>"+rs.getString("text")+"</td>"
						+ "<td>"+rs.getString("user_id")+"</td>"
						+ "<td>"+rs.getString("post_id")+"</td>"
						+ "<td>"+rs.getString("approved")+"</td>"
						+"</tr>";
		}
		resultado=resultado+"</table>";
		return resultado;
	}
}
