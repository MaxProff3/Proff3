package dao;

import java.util.List;

import domain.OrderPosition;

public interface OrderPositionDao {

	Long create(OrderPosition op);
	OrderPosition read(Long id);
	void update(OrderPosition op);
	void delete(OrderPosition op);
	List<OrderPosition> findAll();
}
