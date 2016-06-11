package service;

import java.util.List;

import domain.Contructor;

public interface ContructorService {
	
	void addNewProduct(Contructor contructor);

	void updateProduct(Contructor contructor);

	void deleteProduct(Contructor contructor);

	List<Contructor> getAllProducts();
}
