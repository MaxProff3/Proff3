package domain;

import java.util.List;
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
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	
	
	@Column(name="id")
	private Long id;
	
	@Column(name="number")
	private String number;
	
	@Column(name="contructor_id")
	private Long contructor_id;
	
	@Column(name="user_id")
	private Long user_id;	
	
	@Column(name="summa")
	private Integer summa;	
	
	
	
	

	
	
	

		
	
	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="Contructors",  joinColumns = @JoinColumn(name = "contructor_id"),
		inverseJoinColumns = @JoinColumn(name = "id")
	)
	private Contructor contructor;
	
	
	@ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="users",  joinColumns = @JoinColumn(name = "id"),
		inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	private List<User> user;
	
	

	public Order(){
		
	}
	
//	public User getUser(){
//		
//		return user;
//		
//	}
//	
//	public void setUser(User user){
//		
//		this.user = user;
//	}
	
	public Order(Long id,String number,Long constructor_id,Long user_id,int summa){
		
		setId(id);
		setContructor_ID(constructor_id);
		setUser_ID(user_id);
		setNumber(number);
		setSumma(summa);
		
	}
	
	public void setSumma(int summa){
		
		this.summa = summa;
		
	}
	
	public int getSumma(){
		
		return this.summa;
		
	}
	
	public Order(Long id,String number){
		
		setId(id);
		setNumber(number);
			
	} 
	
	public void setContructor_ID(Long constructor_id){
		
		this.contructor_id = constructor_id; 
		
	}
	
	public Contructor getContructor(){
		
		return contructor;
		
	}
	
	public void setContructor(Contructor contructor){
		
		this.contructor =contructor; 
	}
	
	public Long getContructor_ID(){
		
		return this.contructor_id; 
		
	}
	
	public void setUser_ID(Long user_id2){
		
		this.user_id = user_id2; 
		
	}
	
	public Long setContructor_ID(){
		
		return this.user_id; 
		
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
	
	@Override
	public String toString() {
		return "Order: " + id +"  "+number+"  "+contructor_id+"  "+user_id+"  "+summa+"     contructor: "+contructor;
	}

}
