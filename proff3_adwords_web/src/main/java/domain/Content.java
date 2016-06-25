package domain;

import java.util.Date;

public class Content {
	private Long id;
	private String text;
	private Catalog catalog;
	private User user;
	private Date date;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Catalog getCatalog() {
		return catalog;
	}
	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Content [id=" + id + ", text=" + text + ", catalog=" + catalog + ", user=" + user + ", date=" + date
				+ "]";
	}
	public Content(Long id, String text, Catalog catalog, User user, Date date) {
		super();
		this.id = id;
		this.text = text;
		this.catalog = catalog;
		this.user = user;
		this.date = date;
	}
	public Content() {
		super();
	}
	public String getContent(){
		String content = "<div class=\"itemListContent\">";
		content += "<h4>"+getCatalog().getName()+"</h4>";
		content += "<p>"+getText()+"</p>";
		content += "</div>";
		return content;
	}
	
}
