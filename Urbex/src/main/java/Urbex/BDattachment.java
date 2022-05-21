package Urbex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BDattachment {
	public static String getSelector() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://192.168.56.50/urbex";
		Connection con = DriverManager.getConnection(url, "root", "");
		Statement st = con.createStatement();
		
		String query = "SELECT DISTINCT id FROM attachment";
		ResultSet rs = st.executeQuery(query);
		
		String resultat = "<select id=\"selector\" onchange=\"buscarUsuario()\">"
							+ "<option value=\"*\">All</option>";
		
		while (rs.next()) {
			resultat = resultat 
						+ "<option value=\""+rs.getString("attachment")+"\">"+rs.getString("attachment")+"</option>";
		}
		
		resultat = resultat + "</select>";
		
		rs.close();
		st.close();
		con.close();
		
		return resultat;
	}
	
	public static void enviarAttachment(String location) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "";
		Connection con = DriverManager.getConnection(url, "root", "cicle");
		Statement st = con.createStatement();
		
		String query = "INSERT INTO attachmen VALUES ('"+location+"')";
		st.executeUpdate(query);
		
		st.close();
		con.close();
	}
	
	public static String selectAttachment(String attachment) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://192.168.56.50/urbex";
		Connection con = DriverManager.getConnection(url, "root", "cicle");
		Statement st = con.createStatement();
		
		String query = "SELECT * FROM attachement WHERE id='"+attachment+"'";
		ResultSet rs = st.executeQuery(query);
		
		String resultado = "<table border=\"1\">"
						+ "<tr>"
						+ "<th>Location</th>"
						+ "</tr>";
		
		while (rs.next()) {
			resultado = resultado 
						+"<tr>"
						+ "<td>"+rs.getString("id")+"</td>"
						+ "<td>"+rs.getString("location")+"</td>"
					
						+"</tr>";
		}
		resultado=resultado+"</table>";
		return resultado;
	}
}
