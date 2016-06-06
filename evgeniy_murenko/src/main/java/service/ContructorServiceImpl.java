package service;

import java.util.List;

import dao.ContructorDao;
import domain.Contructor;
import domain.Product;

public class ContructorServiceImpl implements ContructorService {

	private ContructorDao contructorDao = null;

	public ContructorServiceImpl(ContructorDao contructorDao) {
		this.contructorDao = contructorDao;
	}

	@Override
	public void addNewProduct(Contructor contructor) {
		contructorDao.create(contructor);

	}

	@Override
	public void updateProduct(Contructor contructor) {
		contructorDao.update(contructor);
	}

	@Override
	public void deleteProduct(Contructor contructor) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Contructor> getAllProducts() {
		return contructorDao.findAll();
	}

}
