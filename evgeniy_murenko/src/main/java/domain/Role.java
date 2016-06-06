package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "roles") // table name
public class Role {
	@Id
	@GeneratedValue(generator = "incr2")// называем правило
	@GenericGenerator(name = "incr2", strategy = "increment") //задаем правило 
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "comment")
	private String comment;

	public Role() {
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Role " + name;
	}

}