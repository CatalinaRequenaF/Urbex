package Urbex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BDlocalization {
	public static String getSelector() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://192.168.56.50/urbex";
		Connection con = DriverManager.getConnection(url, "root", "");
		Statement st = con.createStatement();
		
		String query = "SELECT DISTINCT id FROM localization";
		ResultSet rs = st.executeQuery(query);
		
		String resultat = "<select id=\"selector\" onchange=\"buscarUsuario()\">"
							+ "<option value=\"*\">All</option>";
		
		while (rs.next()) {
			resultat = resultat 
						+ "<option value=\""+rs.getString("localization")+"\">"+rs.getString("localization")+"</option>";
		}
		
		resultat = resultat + "</select>";
		
		rs.close();
		st.close();
		con.close();
		
		return resultat;
	}
	
	public static void enviarlocalization(String lat,  String lon) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "";
		Connection con = DriverManager.getConnection(url, "root", "cicle");
		Statement st = con.createStatement();
		
		String query = "INSERT INTO users VALUES ('"+lat+"','"+lon+"',)";
		st.executeUpdate(query);
		
		st.close();
		con.close();
	}
	
	public static String selectLocalization(String localization) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://192.168.56.50/urbex";
		Connection con = DriverManager.getConnection(url, "root", "cicle");
		Statement st = con.createStatement();
		
		String query = "SELECT * FROM users WHERE id='"+localization+"'";
		ResultSet rs = st.executeQuery(query);
		
		String resultado = "<table border=\"1\">"
						+ "<tr>"
						+ "<th>lat</th>"
						+ "<th>lon</th>"
						+ "</tr>";
		
		while (rs.next()) {
			resultado = resultado 
						+"<tr>"
						+ "<td>"+rs.getString("lat")+"</td>"
						+ "<td>"+rs.getString("lon")+"</td>"
						+"</tr>";
		}
		resultado=resultado+"</table>";
		return resultado;
	}
}
