package service;

import java.util.List;
import dao.ContructorDao;
import domain.Contructor;

public class ContructorServiceImpl implements ContructorService {
	private ContructorDao contructorDao = null;

	public ContructorServiceImpl(ContructorDao contructorDao) {
		this.contructorDao = contructorDao;
	}

	@Override
	public void addNewContructor(Contructor contructor) {
		contructorDao.create(contructor);
	}

	@Override
	public List<Contructor> getAllContructors() {
		return contructorDao.findAll();
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
	public void addNewContructors(Contructor[] contructors) {
		for(Contructor contructor:contructors){
			contructorDao.create(contructor);
		}
		
	}

}
