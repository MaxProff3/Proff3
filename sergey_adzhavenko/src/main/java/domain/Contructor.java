package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="contructors")
public class Contructor {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String constructorName;
	

	public Contructor() {
	}

	public Contructor(String constructorName){
		this.constructorName = constructorName;
	}
	
	public Contructor(Long id, String constructorName){
		this.id=id;
		this.constructorName = constructorName;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConstructorName() {
		return constructorName;
	}

	public void setConstructorName(String constructorName) {
		this.constructorName = constructorName;
	}

	@Override
	public String toString() {
		return "Contructor [id=" + id + ", constructorName=" + constructorName + "]";
	}

}
