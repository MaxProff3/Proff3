package domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
 
@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String name;

	public User() {
	}

	public User(String name) {
		
		this.name = name;
	}

	public User(String name, String login, Set<Role> roles) {
		
		this.name = name;
		this.login = login;
	//	this.employee = employee;
		this.roles = roles;
	}

	@Column(name="login")
	private String login;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="employee_id")
	private Employees employee;
	//@Column(name="employee_id")
	
	@ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="roles_users",  joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<Role> roles;
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", login=" + login + ", employee="/*+ employee +*/+ ", roles="
				+ roles + "]";
	}

}
