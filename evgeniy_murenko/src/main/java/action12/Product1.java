package action12;

import domain.Product;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Product1{
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty code;
   
    public Product1(int id, String name, String code) {
          this.id = new SimpleIntegerProperty(id);
          this.name = new SimpleStringProperty(name);
          this.code = new SimpleStringProperty(code);
    }
    public Product1(Product product) {
        //this.id = new SimpleIntegerProperty((product.getId()));
        this.name = new SimpleStringProperty(product.getName());
        this.code = new SimpleStringProperty(""+product.getBarcode());
  }    
    public int getId() {
          return id.get();
    }
    public void setId(int id) {
          this.id.set(id);
    }
    public String getName() {
          return name.get();
    }
    public void setName(String name) {
          this.name.set(name);
    }
    public String getCode() {
          return code.get();
    }
    public void setCode(String code) {
          this.code.set(code);
    }     
}