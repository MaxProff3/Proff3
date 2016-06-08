package service;

import java.util.List;

import domain.Contructor;

public interface ContructorService {

	void addNewContructor(Contructor contructor);
	void addNewContructors(Contructor[] contructors);
	void updateContructor(Contructor contructor);
	void deleteContructor(Contructor contructor);
	Contructor read(Long id);
	List<Contructor> getAllContructors();
}
