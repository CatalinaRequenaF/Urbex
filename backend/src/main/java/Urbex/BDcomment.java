package Urbex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BDcomment {
	public static String getSelector() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://192.168.56.50/urbex";
		Connection con = DriverManager.getConnection(url, "root", "");
		Statement st = con.createStatement();
		
		String query = "SELECT DISTINCT id FROM comments";
		ResultSet rs = st.executeQuery(query);
		
		String resultat = "<select id=\"selector\" onchange=\"buscarUsuario()\">"
							+ "<option value=\"*\">All</option>";
		
		while (rs.next()) {
			resultat = resultat 
						+ "<option value=\""+rs.getString("comments")+"\">"+rs.getString("comments")+"</option>";
		}
		
		resultat = resultat + "</select>";
		
		rs.close();
		st.close();
		con.close();
		
		return resultat;
	}
	
	public static void enviarComment(String text,  String approved) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "";
		Connection con = DriverManager.getConnection(url, "root", "cicle");
		Statement st = con.createStatement();
		
		String query = "INSERT INTO users VALUES ('"+text+"','"+approved+"')";
		st.executeUpdate(query);
		
		st.close();
		con.close();
	}
	
	public static String selectComment(String comment) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://192.168.56.50/urbex";
		Connection con = DriverManager.getConnection(url, "root", "cicle");
		Statement st = con.createStatement();
		
		String query = "SELECT * FROM users WHERE id='"+comment+"'";
		ResultSet rs = st.executeQuery(query);
		
		String resultado = "<table border=\"1\">"
						+ "<tr>"
						+ "<th>id</th>"
						+ "<th>text</th>"
						+ "<th>post_id</th>"
						+ "<th>user_id</th>"
						+ "<th>approved</th>"
						+ "</tr>";
		
		while (rs.next()) {
			resultado = resultado 
						+"<tr>"
						+ "<td>"+rs.getString("id")+"</td>"
						+ "<td>"+rs.getString("text")+"</td>"
						+ "<td>"+rs.getString("post_id")+"</td>"
						+ "<td>"+rs.getString("user_id")+"</td>"
						+ "<td>"+rs.getString("approved")+"</td>"
						+"</tr>";
		}
		resultado=resultado+"</table>";
		return resultado;
	}
}
