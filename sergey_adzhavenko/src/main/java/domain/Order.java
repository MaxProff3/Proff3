package domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(generator = "increment4")
	@GenericGenerator(name = "increment4", strategy = "increment")
	@Column(name="id")
	private Long id;
	
	@Column(name="number")
	private String number;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="contructor_id")
	private Contructor contructor;
	
	@Column(name="user_id")
	private Integer userID;
	
	@Column(name="summa")
	private Integer summa;
	
	@OneToMany(/*cascade = CascadeType.ALL,*/ fetch = FetchType.EAGER, mappedBy="order")
	List<OrderPosition> orderPositions;
	
	public Order(){
		
	}

	public Order(String number, Contructor contructor, Integer userID, Integer summa) {
		this.number = number;
		this.contructor = contructor;
		this.userID = userID;
		this.summa = summa;
	}

	
	public Order(Long id, String number, Contructor contructor, Integer userID, Integer summa) {
		this.id = id;
		this.number = number;
		this.contructor = contructor;
		this.userID = userID;
		this.summa = summa;
	}

	public Order(Long id, String number, Contructor contructor, Integer userID, Integer summa,
			List<OrderPosition> orderPositions) {
		this.id = id;
		this.number = number;
		this.contructor = contructor;
		this.userID = userID;
		this.summa = summa;
		this.orderPositions = orderPositions;
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

	public Contructor getContructor() {
		return contructor;
	}

	public void setContructor(Contructor contructor) {
		this.contructor = contructor;
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

	public List<OrderPosition> getOrderPositions() {
		return orderPositions;
	}

	public void setOrderPositions(List<OrderPosition> orderPositions) {
		this.orderPositions = orderPositions;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", number=" + number + ", contructor=" + contructor + ", userID=" + userID
				+ ", summa=" + summa + ", orderPositions=" + orderPositions + "]";
	}
	
}
