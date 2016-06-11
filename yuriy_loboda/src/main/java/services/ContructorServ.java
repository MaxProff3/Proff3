package services;

import java.util.List;

import domain.Contructor;

public interface ContructorServ {
	void addNewContr(Contructor contr);
	void updateContr(Contructor contr);
	void deleteContr(Contructor contr);
	List<Contructor> getAllContructors(); 
    Contructor read(Long id);
}
