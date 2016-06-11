package dao;

import java.util.List;


import domain.Order_position;

public interface Order_positionDao {
	 Long create ( Order_position pos);
	 Order_position read(Long id);
	 void update( Order_position pos);
	 void delete( Order_position pos);
	 List< Order_position> findAll();

}
