package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="order_positions")
public class Order_position {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name="id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="order_id")
	private Order order;

	public Order_position() {
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="product_id")
	private Product product;

	@Override
	public String toString() {
		return "Order_position [id=" + id + ", order=" + order + ", product=" + product + "]";
	}

	public Order_position(Order order_id,Product product) {
		this.product=product;
		this.order = order_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder_id() {
		return order;
	}

	public void setOrder_id(Order order_id) {
		this.order = order_id;
	}
	

}
