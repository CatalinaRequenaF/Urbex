package Urbex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BDpost {
	public static String getSelector() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://192.168.56.50/urbex";
		Connection con = DriverManager.getConnection(url, "root", "");
		Statement st = con.createStatement();
		
		String query = "SELECT DISTINCT id FROM post";
		ResultSet rs = st.executeQuery(query);
		
		String resultat = "<select id=\"selector\" onchange=\"buscarUsuario()\">"
							+ "<option value=\"*\">All</option>";
		
		while (rs.next()) {
			resultat = resultat 
						+ "<option value=\""+rs.getString("post")+"\">"+rs.getString("post")+"</option>";
		}
		
		resultat = resultat + "</select>";
		
		rs.close();
		st.close();
		con.close();
		
		return resultat;
	}
	
	public static void enviarPost(String title,  String description) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "";
		Connection con = DriverManager.getConnection(url, "root", "cicle");
		Statement st = con.createStatement();
		
		String query = "INSERT INTO users VALUES ('"+title+"','"+description+"')";
		st.executeUpdate(query);
		
		st.close();
		con.close();
	}
	
	public static String selectPost(String post) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://192.168.56.50/urbex";
		Connection con = DriverManager.getConnection(url, "root", "cicle");
		Statement st = con.createStatement();
		
		String query = "SELECT * FROM post WHERE id='"+post+"'";
		ResultSet rs = st.executeQuery(query);
		
		String resultado = "<table border=\"1\">"
						+ "<tr>"
						+ "<th>id</th>"
						+ "<th>title</th>"
						+ "<th>description</th>"
						+ "<th>localization_id</th>"
						+ "</tr>";
		
		while (rs.next()) {
			resultado = resultado 
						+"<tr>"
						+ "<td>"+rs.getString("id")+"</td>"
						+ "<td>"+rs.getString("title")+"</td>"
						+ "<td>"+rs.getString("description")+"</td>"
						+ "<td>"+rs.getString("localization_id")+"</td>"
						+"</tr>";
		}
		resultado=resultado+"</table>";
		return resultado;
	}
}
