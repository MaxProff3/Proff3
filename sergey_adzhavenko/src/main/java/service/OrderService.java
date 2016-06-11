package service;

import java.util.List;

import domain.Order;

public interface OrderService {
	void addNewOrder(Order order);
	void addNewOrders(Order[] orders);
	void updateOrder(Order order);
	void deleteOrder(Order order);
	Order read(Long id);
	List<Order> getAllOrders();
}
