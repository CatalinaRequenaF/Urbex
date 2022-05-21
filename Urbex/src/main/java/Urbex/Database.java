package Urbex;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class Database {
	private static Database instancia;
	private  Connection con;
	
	public static Database getInstancia() {
		if(instancia == null) {
			instancia = new Database();
		}
		
		return instancia;
	
	}
	//Conectar a la base de datos
	private Database() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://192.168.56.50/urbex";
			Connection con = DriverManager.getConnection(url, "root", "cicle");
			this.con = con;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private HashMap<String,Object> rsToHashMap(ResultSet rs) {
		HashMap<String,Object> list = new HashMap<String,Object>();
		try {
			ResultSetMetaData md = (ResultSetMetaData) rs.getMetaData();
	        int columnCount = md.getColumnCount();
			
	        while (rs.next()) {
	            for(int i = 1;i<=columnCount;i++){
	                list.put(md.getColumnName(i), rs.getObject(i));
	            }
	            //System.out.println(rowData);
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//Método para hacer selects
	public HashMap<String,Object> query(String query) {
		HashMap<String,Object> list = new HashMap<String,Object>();
		try {
			PreparedStatement stmt = this.con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
	        list = rsToHashMap(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	// Método para hacer un insert
	public int insert(String table, HashMap<String,Object> list) {
		Set<Map.Entry<String, Object>> entries = list.entrySet();
		String columns = "";
		String values = "";
		
		for (Map.Entry<String, Object> entry : entries) {
		    if (columns.equals("")) {
		    	columns += entry.getKey();
		    } else {
		    	columns += "," + entry.getKey();
		    }
		    
		    Object value = entry.getValue();
		    String valueStr = "";
		    String type = value.getClass().getName();
		    
		    if (type.equals("java.lang.Integer")) {
		    	valueStr = value.toString();
		    } else if (type.equals("java.lang.String")) {
		    	valueStr = "\"" + value + "\"";
		    }
		    
		    if (values.equals("")) {
		    	values += valueStr;
		    } else {
		    	values += "," + valueStr;
		    }
		}
		
		String query = "INSERT INTO " + table +"(" + columns + ") VALUES (" + values + ")";
		System.out.println(query);
		
		list = new HashMap<String,Object>();
		try {
			PreparedStatement stmt = this.con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			list = rsToHashMap(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ((BigInteger) list.get("GENERATED_KEY")).intValue();
		
	}
}


