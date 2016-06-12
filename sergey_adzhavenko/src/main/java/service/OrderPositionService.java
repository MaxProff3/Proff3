package service;

import java.util.List;

import domain.OrderPosition;

public interface OrderPositionService {

	void addNewOrderPosition(OrderPosition op);
	void addNewOrderPositions(OrderPosition[] opArray);
	void updateOrderPosition(OrderPosition op);
	void deleteOrderPosition(OrderPosition op);
	OrderPosition read(Long id);
	List<OrderPosition> getAllOrderPositions();
}
