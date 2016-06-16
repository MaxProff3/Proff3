package hw6;

import domain.Product;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class ObservableProduct{

	private SimpleLongProperty id;
	private SimpleStringProperty name;
	private SimpleIntegerProperty code;
	
	public ObservableProduct(Product product) {
		this.id = new SimpleLongProperty(product.getId());
		this.name = new SimpleStringProperty(product.getName());
		this.code = new SimpleIntegerProperty(product.getBarcode());
	}
	
	public Long getId() {
		return id.get();
	}

	public void setId(Long id) {
		this.id.set(id);
	}
	
	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

    public Integer getCode() {
        return code.get();
    }
    public void setCode(Integer code) {
        this.code.set(code);
    }
  
	@Override
	public String toString() {
		return "ObservableProduct [id=" + id + ", name=" + name + ", code=" + code + "]";
	}
	
}