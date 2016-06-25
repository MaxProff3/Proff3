package domain;

public class Catalog {
	private Long id;
	private String name;
	
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
	public Catalog(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Catalog() {
		super();
	}
	@Override
	public String toString() {
		return "Catalog [id=" + id + ", name=" + name + "]";
	}
	
}
