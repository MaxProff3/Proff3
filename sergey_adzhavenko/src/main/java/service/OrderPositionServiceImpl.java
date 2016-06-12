package service;

import java.util.List;

import dao.OrderPositionDao;
import domain.OrderPosition;

public class OrderPositionServiceImpl implements OrderPositionService{

	private OrderPositionDao opDao = null;
	
	public OrderPositionServiceImpl(OrderPositionDao opDao) {
		this.opDao = opDao;
	}

	@Override
	public void addNewOrderPosition(OrderPosition op) {
		opDao.create(op);
	}

	@Override
	public void addNewOrderPositions(OrderPosition[] opArray) {
		for(OrderPosition op: opArray){
			opDao.create(op);
		}
	}

	@Override
	public void updateOrderPosition(OrderPosition op) {
		opDao.update(op);
	}

	@Override
	public void deleteOrderPosition(OrderPosition op) {
		opDao.delete(op);
	}

	@Override
	public OrderPosition read(Long id) {
		return opDao.read(id);
	}

	@Override
	public List<OrderPosition> getAllOrderPositions() {
		return opDao.findAll();
	}
}