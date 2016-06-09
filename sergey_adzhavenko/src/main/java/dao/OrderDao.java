package dao;

import java.util.List;

import domain.Order;

public interface OrderDao {

	Long create(Order order);
	Order read(Long id);
	void update(Order order);
	void delete(Order order);
	List<Order> findAll();
}
