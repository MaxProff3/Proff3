package hw6;

import domain.Contructor;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class ObservableContructor {

	private SimpleLongProperty id;
	private SimpleStringProperty name;
	
	public ObservableContructor(Contructor contructor) {
		this.id = new SimpleLongProperty(contructor.getId());
		this.name = new SimpleStringProperty(contructor.getConstructorName());
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

	@Override
	public String toString() {
		return "ObservableContructor [id=" + id + ", name=" + name + "]";
	}
}
