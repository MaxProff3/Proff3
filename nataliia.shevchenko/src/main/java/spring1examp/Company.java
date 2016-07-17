package spring1examp;

public class Company {
	
	private String nameComp;
	private Car linkCar;
	private Human linkHuman;
	
	public Company(){}
	
	public Company(String nameComp) {
		super();
		this.nameComp = nameComp;
	}

	public Company(String nameComp, Car linkCar, Human linkHuman) {
		super();
		this.nameComp = nameComp;
		this.linkCar = linkCar;
		this.linkHuman = linkHuman;
	}

	public String getNameComp() {
		return nameComp;
	}

	public void setNameComp(String nameComp) {
		this.nameComp = nameComp;
	}

	public Car getLinkCar() {
		return linkCar;
	}

	public void setLinkCar(Car linkCar) {
		this.linkCar = linkCar;
	}

	public Human getLinkHuman() {
		return linkHuman;
	}

	public void setLinkHuman(Human linkHuman) {
		this.linkHuman = linkHuman;
	}

	@Override
	public String toString() {
		return "Company [nameComp=" + nameComp + ", linkCar=" + linkCar + ", linkHuman=" + linkHuman + "]";
	}
	
	

}
