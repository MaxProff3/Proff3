package services.test;

import java.util.List;

import domain.Contructor;

public interface ContructorServ {
	void addNewContr(Contructor contr);
	void updateContr(Contructor contr);
	void deleteContr(Contructor contr);
	List<Contructor> getAllProducts(); 
    Contructor read(Long i);
    int getCount();
}
