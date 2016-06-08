package dao;

import java.util.List;

import domain.Contructor;

public interface ContructorDAO {

	Long create(Contructor contructor);
	Contructor read(Long id);
	void update(Contructor contructor);
	void delete(Contructor contructor);
	List<Contructor> findAll();
}
