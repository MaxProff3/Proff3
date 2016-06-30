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
	@Table(name="contructors")
	public class Contructor {//fghfghfgh
		@Id
		@GeneratedValue(generator = "increment")
		@GenericGenerator(name = "increment", strategy = "increment")
		@Column(name="id")
		private Long id;
		
		@Column(name="name")
		private String name;
		
		/*@OneToOne(fetch = FetchType.EAGER)
		@JoinColumn(name="contructor_id")
		*/
		
//		@ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
//		@JoinTable(name="roles_users",  joinColumns = @JoinColumn(name = "user_id"),
//			inverseJoinColumns = @JoinColumn(name = "role_id")
//		)
		
		@OneToMany
		private Set<Order> orders;
		
		public Contructor(String name) {
			this.name = name;
			
		}

		public Contructor() {
			// TODO Auto-generated constructor stub
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



		@Override
		public String toString() {
			return "Contructor [id=" + id + ", name=" + name + "]";
		}

	}


