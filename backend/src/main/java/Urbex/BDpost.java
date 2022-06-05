package Urbex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BDpost {
	public static String getSelector() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql:/http://192.168.56.50:3306/urbex";
		Connection con = DriverManager.getConnection(url, "root", "cicle");
		Statement st = con.createStatement();
		
		String query = "SELECT DISTINCT id FROM posts";
		ResultSet rs = st.executeQuery(query);
		
		String resultado = "<select id=\"selector\" onchange=\"buscarPost()\">"
							+ "<option value=\"*\">All</option>";
		
		while (rs.next()) {
			resultado = resultado 
						+ "<option value=\""+rs.getString("posts")+"\">"+rs.getString("posts")+"</option>";
		}
		
		resultado = resultado + "</select>";
		
		rs.close();
		st.close();
		con.close();
		
		return resultado;
	}
	
	public static void enviarPost(String title,  String description, String lat, String lon) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://192.168.56.50:3306/urbex";
		Connection con = DriverManager.getConnection(url, "root", "cicle");
		Statement st = con.createStatement();
		System.out.println("ok");
		String query = "INSERT INTO posts(title,description,lat,lon) VALUES ('"+title+"','"+description+"','"+lat+"','"+lon+"')";
		System.out.println(query);
		st.executeUpdate(query);
		
		st.close();
		con.close();
	}
	
	public static String selectPost(String post) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://192.168.56.50:3306/urbex";
		Connection con = DriverManager.getConnection(url, "root", "cicle");
		Statement st = con.createStatement();
		
		String query = "SELECT * FROM posts WHERE id='"+post+"'";
		ResultSet rs = st.executeQuery(query);
		
		String resultado = "<table border=\"1\">"
						+ "<tr>"
						+ "<th>id</th>"
						+ "<th>title</th>"
						+ "<th>description</th>"
						+ "<th>lat</th>"
						+ "<th>lon</th>"
						+ "</tr>";
		
		while (rs.next()) {
			resultado = resultado 
						+"<tr>"
						+ "<td>"+rs.getString("id")+"</td>"
						+ "<td>"+rs.getString("title")+"</td>"
						+ "<td>"+rs.getString("description")+"</td>"
						+ "<td>"+rs.getString("lat")+"</td>"
						+ "<td>"+rs.getString("lon")+"</td>"
						+"</tr>";
		}
		resultado=resultado+"</table>";
		return resultado;
	}
}
