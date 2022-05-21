package Urbex;

public class Attachment {
	private final int id;
	private String location;
	
	
	public Attachment(int id, String location) {
		this.id = 0;
		this.setLocation(location);
	}
	
	//Este constructor es para solicitarlo el id desde la base de datos
	public Attachment(int id) {
		this.id = id;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getId() {
		return id;
	}
	
	
}
