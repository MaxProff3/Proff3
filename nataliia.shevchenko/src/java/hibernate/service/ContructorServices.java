package service;

import java.util.List;

import domain.Contructor;

public interface ContructorServices {
	void addNewContructor (Contructor contructor);
	void addNewContructors (Contructor[] contructors);
	void updateContructor(Contructor contructor);
	void deleteContructor(Contructor contructor);
	List<Contructor> getAllContructors(); 


}
