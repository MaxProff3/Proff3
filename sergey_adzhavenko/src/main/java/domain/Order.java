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
	@Column(name="id")
	private Long id;
	
	@Column(name="number")
	private String number;
	
	@Column(name="contructor_id")
	private Integer contructorID = null;
	
	@Column(name="user_id")
	private Integer userID;
	
	@Column(name="summa")
	private Integer summa;
	
	public Order(){
		
	}

	public Order(String number, Integer contructorID, Integer userID, Integer summa) {
		this.number = number;
		this.contructorID = contructorID;
		this.userID = userID;
		this.summa = summa;
	}

	public Order(String number, Integer userID, Integer summa) {
		this.number = number;
		this.userID = userID;
		this.summa = summa;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", number=" + number + ", contructorID=" + contructorID + ", userID=" + userID
				+ ", summa=" + summa + "]";
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

	public Integer getContructorID() {
		return contructorID;
	}

	public void setContructorID(Integer contructorID) {
		this.contructorID = contructorID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getSumma() {
		return summa;
	}

	public void setSumma(Integer summa) {
		this.summa = summa;
	}
	

}
