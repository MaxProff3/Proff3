package spring1examp;

public class Human {
	
	private String name;
	
	public Human(){}

	public Human(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Human [name=" + name + "]";
	}
	
	

}
