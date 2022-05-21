package Urbex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Usuario {
	private final int id;
	private String name;
	private String surname;
	private String email;
	private Role role;
	
	
	
	public Usuario(String name, String surname, String email, Role role) {
		this.setName(name);
		this.setSurname(surname);
		this.setEmail(email);
		this.setRole(role);
		this.id = 0;
	}
	
	//Este constructor es para solicitarlo el id desde la base de datos
	public Usuario(int id) {
		this.id = id;
	}
	
	/*public boolean guardarBd(){
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/daw";
		Connection con = DriverManager.getConnection(url, "root", "");
		Statement st = con.createStatement();
	}
	*/

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
