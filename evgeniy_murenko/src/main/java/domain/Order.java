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
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "orders") // table name
public class Order {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id")
	private Long id;

	@Column(name = "number")
	private String number;

	@Column(name = "contructor_id")
	private int contructorId;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "summa")
	private int summa;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) // тип связи
	@JoinTable(name = "orders", joinColumns = @JoinColumn(name = "contructor_id"),inverseJoinColumns = @JoinColumn(name = "id")) // описание связи
	private Set<Contructor> orders;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getContructorId() {
		return contructorId;
	}

	public void setContructorId(int contructorId) {
		this.contructorId = contructorId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSumma() {
		return summa;
	}

	public void setSumma(int summa) {
		this.summa = summa;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", number=" + number + ", contructorId=" + contructorId + ", userId=" + userId
				+ ", summa=" + summa + "]";
	}
	
}
