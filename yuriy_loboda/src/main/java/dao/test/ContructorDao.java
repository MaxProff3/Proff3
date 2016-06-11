package dao.test;

import java.util.List;

import domain.Contructor;


public interface ContructorDao {
	
	 Long create (Contructor contr);
	 Contructor read(Long id);
	 void update(Contructor contr);
	 void delete(Contructor contr);
	 List<Contructor> findAll();
	 int getCount();

}
