package domain;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.Table;
	import org.hibernate.annotations.GenericGenerator;

	@Entity
	@Table(name="order_position")
	public class OrderPosition {
		@Id
		@GeneratedValue(generator = "increment2")
		@GenericGenerator(name = "increment2", strategy = "increment")
		private Long id;
		
		@Column(name="order_id")
		
		private Long order_id; 
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return "OrderPosition [id=" + id + ", order_id=" + order_id + "]";
		}

		public Long getOrder_id() {
			return order_id;
		}

		public void setOrder_id(Long order_id) {
			this.order_id = order_id;
		}

}
