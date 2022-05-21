package Urbex;

public class Post {
	private final int id;
	private String title;
	private String description;
	private Localization localization;
	
	public Post(String title, String description, Localization localization) {
		this.id = 0;
		this.setTitle(title);
		this.setDescription(description);
		this.setLocalization(localization);
	}
	
	//Este constructor es para solicitarlo el id desde la base de datos
	public Post(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
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
	public Localization getLocalization() {
		return localization;
	}
	public void setLocalization(Localization localization) {
		this.localization= localization;
	}
	
	
}
