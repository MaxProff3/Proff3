package services;

import java.util.List;

import dao.OrderDao;
import domain.Order;

public class OrderServImpl implements OrderServ{
	private static  OrderDao dao = null;
	
	
	public OrderServImpl(OrderDao dao) {
	   this.dao=dao;
	}
	
	@Override
	public void addNewOrder(Order order) {
		dao.create(order);
		
	}

	@Override
	public void updateOrder(Order order) {
		dao.update(order);
		
	}

	@Override
	public void deleteOrder(Order order) {
		dao.delete(order);
		
	}

	@Override
	public List<Order> getAllOrder() {
		return dao.findAll();
	}

	@Override
	public Order read(Long id) {
		return dao.read(id);
	}
 

	

}
