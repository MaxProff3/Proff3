package services;

import java.util.List;

import domain.Contructor;
import domain.Order_position;

public interface Order_positionServ {
	void addNewContr(Order_position pos);
	void updateContr(Order_position pos);
	void deleteContr(Order_position pos);
	List<Order_position> getAllOrder_position(); 
	Order_position read(Long id);
}
