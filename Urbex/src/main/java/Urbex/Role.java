package Urbex;

public class Role {
	private final int id;
	private String name;
	
	
	
	public Role(String name) {
		this.id = 0;
		this.setName(name);
	}
	
	//Este constructor es para solicitarlo el id desde la base de datos
	public Role(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
