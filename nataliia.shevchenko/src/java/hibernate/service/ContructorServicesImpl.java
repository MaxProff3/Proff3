package service;

import java.util.List;

import dao.ContructorDao;
import domain.Contructor;

public class ContructorServicesImpl implements ContructorServices {
	
	private ContructorDao contructorDao = null;
	
	public ContructorServicesImpl(ContructorDao contructorDao){
		this.contructorDao = contructorDao;
	}

	@Override
	public void addNewContructor(Contructor contructor) {
		contructorDao.create(contructor);		
	}

	@Override
	public void addNewContructors(Contructor[] contructors) {
		for(Contructor contructor : contructors){
			contructorDao.create(contructor);
		}
	}

	@Override
	public void updateContructor(Contructor contructor) {
		contructorDao.update(contructor);		
	}

	@Override
	public void deleteContructor(Contructor contructor) {
		contructorDao.delete(contructor);		
	}

	@Override
	public List<Contructor> getAllContructors() {
		return null;
	}
	
}
