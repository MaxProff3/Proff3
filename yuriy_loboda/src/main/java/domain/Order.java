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
	



@Override
	public String toString() {
		return "Order [id=" + id + ", number=" + number + ", user=" + user + ", sum=" + sum + ", contructor="
				+ contructor + "]";
	}


@Id
@GeneratedValue(generator = "increment5")
@GenericGenerator(name = "increment5", strategy = "increment")
private Long id;

@Column(name="number")
private String number;

@OneToOne(fetch = FetchType.EAGER)	
@JoinColumn(name="user_id")
private User user;


@Column(name="summa")
private int sum;

@OneToOne(fetch = FetchType.EAGER)
@JoinColumn(name="contructor_id")
private Contructor contructor;

@OneToMany(mappedBy ="order",fetch=FetchType.EAGER)
private List<Order_position> order_position;



public List<Order_position> getOrder_position() {
	return order_position;
}

public void setOrder_position(List<Order_position> order_position) {
	this.order_position = order_position;
}

public Order(String number, Contructor contructor,User user , int sum,List<Order_position> order_position) {
	this.number = number;
	this.user = user;
	this.sum = sum;
	this.contructor = contructor;
	this.order_position=order_position;
}

public Order() {

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




public User getUser() {
	return user;
}


public void setUser(User user) {
	this.user = user;
}


public int getSum() {
	return sum;
}


public void setSum(int sum) {
	this.sum = sum;
}



}
