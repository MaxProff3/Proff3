package services;

import java.util.List;


import dao.Order_positionDao;
import domain.Order_position;

public class Order_positionServImpl implements Order_positionServ  {
	private static Order_positionDao dao =null;
	
	public Order_positionServImpl(Order_positionDao dao) {
		this.dao=dao;
	}
	@Override
	public void addNewContr(Order_position pos) {
		dao.create(pos);
		
	}

	@Override
	public void updateContr(Order_position pos) {
		dao.update(pos);
		
	}

	@Override
	public void deleteContr(Order_position pos) {
		dao.delete(pos);
		
	}

	@Override
	public List<Order_position> getAllOrder_position() {
		return dao.findAll();
	}

	@Override
	public Order_position read(Long id) {
		return dao.read(id);
	}

}
