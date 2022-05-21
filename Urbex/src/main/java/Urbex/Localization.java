package Urbex;

public class Localization {
	private final int id;
	private int lat;
	private int lon;
	
	
	public Localization(int lat, int lon) {
		this.id = 0;
		this.lat = lat;
		this.lon = lon;
			
	}
	
	//Este constructor es para solicitarlo el id desde la base de datos
	public Localization(int id) {
		this.id = id;
	}
	
	public int getLat() {
		return lat;
	}
	public void setLat(int lat) {
		this.lat = lat;
	}
	public int getLon() {
		return lon;
	}
	public void setLon(int lon) {
		this.lon = lon;
	}
	public int getId() {
		return id;
	}
	
	
}
