package Urbex;

public class Comment {
	private final int id;
	private Usuario user;
	private Post post;
	private boolean approved;
	private String text;
	
	public Comment(Usuario user, Post post, boolean approved, String text) {
		this.id = 0;
		this.setUsuario(user);
		this.setPost(post);
		this.setApproved(approved);
		this.setText(text);
	}
	
	//Este constructor es para solicitarlo el id desde la base de datos
	public Comment(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public Usuario getUsuario() {
		return user;
	}
	public void setUsuario(Usuario user) {
		this.user = user;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public boolean getApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		
		this.approved = approved;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
