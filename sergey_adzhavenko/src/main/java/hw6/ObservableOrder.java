package hw6;

import domain.Order;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class ObservableOrder {
	
	private SimpleLongProperty id;
	private SimpleStringProperty number;
	private ObservableContructor contructor;
	private SimpleStringProperty contructorName;
	private SimpleIntegerProperty userID;
	private SimpleIntegerProperty summa;
	
	public ObservableOrder(Order order) {
		this.id = new SimpleLongProperty(order.getId());
		this.number = new SimpleStringProperty(order.getNumber());
		if(order.getContructor()==null){
			this.contructor = null;
			contructorName = new SimpleStringProperty();
		}
		else {
			this.contructor = new ObservableContructor(order.getContructor());
			contructorName = new SimpleStringProperty(contructor.getName());
		}
		
		this.userID = new SimpleIntegerProperty(order.getUserID());
		this.summa = new SimpleIntegerProperty(order.getSumma());
	}
	
	public Long getId() {
		return id.get();
	}

	public void setId(Long id) {
		this.id.set(id);
	}

	public String getNumber() {
		return number.get();
	}

	public void setNumber(String number) {
		this.number.set(number);
	}
	
	public ObservableContructor getContructor(){
		return contructor;
	}
	
	public void setContructor(ObservableContructor contructor){
		this.contructor = contructor;
	}
	
	public String getContructorName() {
		return contructorName.get();
	}

	public void setContructorName(String contructorName) {
		this.contructorName.set(contructorName);
	}
	
    public Integer getUserID() {
        return userID.get();
    }
    public void setUserID(Integer userID) {
        this.userID.set(userID);
    }
    
    public Integer getSumma() {
        return summa.get();
    }
    public void setSumma(Integer summa) {
        this.summa.set(summa);
    }

	@Override
	public String toString() {
		return "ObservableOrder [id=" + id + ", number=" + number + ", contructor=" + contructor + ", userID=" + userID
				+ ", summa=" + summa + "]";
	}
}
