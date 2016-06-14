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
public class OrderPosition {

	@Id
	@GeneratedValue(generator = "increment5")
	@GenericGenerator(name = "increment5", strategy = "increment")
	@Column(name="id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="number")
	private Order order;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="product_id")
	private Product product;
	
	@Column(name="count")
	private Integer count;
	
	@Column(name="summa")
	private Integer summa;
	
	public OrderPosition(){
		
	}
	
	public OrderPosition(Order order, Product product, Integer count) {
		this.order = order;
		this.product = product;
		this.count = count;
	}


	public OrderPosition(Order order, Product product, Integer count, Integer summa) {
		this.order = order;
		this.product = product;
		this.count = count;
		this.summa = summa;
	}


	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getSumma() {
		return summa;
	}

	public void setSumma(Integer summa) {
		this.summa = summa;
	}

	@Override
	public String toString() {
		return "OrderPosition [id=" + id + ", order=" + order + ", product=" + product + ", count=" + count + ", summa="
				+ summa + "]";
	}
	
}
