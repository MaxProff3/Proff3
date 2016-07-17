package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(generator = "increment2")
	@GenericGenerator(name = "increment2", strategy = "increment")
	private Long id;
	
	@Column(name="number")
	private String number;
	
	@Column(name="contructor_id")
	private Integer contructorId;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="summa")
	private Integer summa;
	
	public Order(){}

	public Order(Long id, String number, Integer contructorId, Integer userId, Integer summa) {
		super();
		this.id = id;
		this.number = number;
		this.contructorId = contructorId;
		this.userId = userId;
		this.summa = summa;
	}

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

	public Integer getContructorId() {
		return contructorId;
	}

	public void setContructorId(Integer contructorId) {
		this.contructorId = contructorId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getSumma() {
		return summa;
	}

	public void setSumma(Integer summa) {
		this.summa = summa;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", number=" + number + ", contructorId=" + contructorId + ", userId=" + userId
				+ ", summa=" + summa + "]";
	}
	

}
