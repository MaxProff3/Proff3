package services;

import java.util.List;


import domain.Order;

public interface OrderServ {
	void addNewOrder( Order order);
	void updateOrder( Order order);
	void deleteOrder( Order order);
	List< Order> getAllOrder(); 
	Order read(Long id);

}
