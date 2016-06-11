

package service;

import java.util.List;
import dao.OrderDao;
import domain.Order;

public class OrderServiceImpl implements OrderService {
	private OrderDao orderDao = null;

	public OrderServiceImpl(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public void addNewOrder(Order order) {
		orderDao.create(order);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderDao.findAll();
	}

	@Override
	public void updateOrder(Order order) {
		orderDao.update(order);
		
	}

	@Override
	public void deleteOrder(Order order) {
		orderDao.delete(order);
		
	}

	@Override
	public void addNewOrders(Order[] orders) {
		for(Order order:orders){
			orderDao.create(order);
		}
		
	}

}

