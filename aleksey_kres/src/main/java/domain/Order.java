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
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")

	@Column(name = "id")
	private Long id;

	@Column(name = "number")
	private String number;

	@Column(name = "contructor_id")
	private Integer contructor_id;

	@Column(name = "user_id")
	private Integer user_id;

	@Column(name = "summa")
	private Integer summa;

	/*
	 * @OneToOne(fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name="contructor_id")
	 */

//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinTable(name = "orders", joinColumns = @JoinColumn(name = "contructor_id"),
//	inverseJoinColumns = @JoinColumn(name = "order_positions"))
//	
//	private List<Order_position> hz;

	public Order(Long id, String number, int contructor_id, int user_id, int summa) {
		super();
		this.id = id;
		this.number = number;
		this.contructor_id = contructor_id;
		this.user_id = user_id;
		this.summa = summa;
	}

	public Order() {
		// TODO Auto-generated constructor stub
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

	public Integer getContructor_id() {
		return contructor_id;
	}

	public void setContructor_id(Integer contructor_id) {
		this.contructor_id = contructor_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getSumma() {
		return summa;
	}

	public void setSumma(Integer summa) {
		this.summa = summa;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", number=" + number + ", contructor_id=" + contructor_id + ", user_id=" + user_id
				+ ", summa=" + summa + "]";
	}

}
