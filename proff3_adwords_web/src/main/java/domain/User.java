package domain;

public class User {
	private Long id;
	private String name;
	private String login;
	private String pass;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public User() {
		super();
	}
	public User(Long id, String name, String login, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.login = login;
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", login=" + login + ", pass=" + pass + "]";
	}
	
	
	
}
