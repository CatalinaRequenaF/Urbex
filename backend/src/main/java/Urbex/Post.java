package Urbex;

public class Post {
	private final int id;
	private String title;
	private String description;
	private String lat;
	private String lon;
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public int getId() {
		return id;
	}

	public Post(String title, String description, String lat, String lon) {
		this.id = 0;
		this.setTitle(title);
		this.setDescription(description);
		this.setLat(lat);
		this.setLon(lon);
	}
	
	//Este constructor es para solicitarlo el id desde la base de datos
	public Post(int id) {
		this.id = id;
	}
	
	
	
	
}
