package domain;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.Table;

	import org.hibernate.annotations.GenericGenerator;

	@Entity
	@Table(name="employees")
	public class Employee {// POJO
		@Id
		@GeneratedValue(generator = "increment2")
		@GenericGenerator(name = "increment2", strategy = "increment")
		private Long id;
		
		@Column(name="name")
		private String name;
		
		@Column(name="code")
		private int barcode = 0;

		public Long getId() {
			return id;
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

		public int getBarcode() {
			return barcode;
		}

		public void setBarcode(int barcode) {
			this.barcode = barcode;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", barcode=" + barcode + "]";
		}

		public Employee() {
		}


		public Employee(String name, int barcode) {
			this.name = name;
			this.barcode = barcode;
		}

		public Employee(String name) {
			this(name,0);
		}
		
	}


