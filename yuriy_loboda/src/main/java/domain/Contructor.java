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
	@GeneratedValue(generator = "increment2")
	@GenericGenerator(name = "increment2", strategy = "increment")
	private Long id;
	
	@Column(name="name")
	private String name;

	@Override
	public String toString() {
		return  name ;
	}

	public Contructor() {
		
	}

	public Contructor(String name) {
		this.name = name;
	}

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
	
	
}
