package services.test;

import java.util.List;

import dao.test.ContructorDao;
import dao.test.ContructorDaoImpl;
import domain.Contructor;

public class ContructorServImpl implements ContructorServ {
	private static ContructorDao conDao=null;
	
	public ContructorServImpl(ContructorDao conDao) {
		this.conDao=conDao;
	}

	@Override
	public void addNewContr(Contructor contr) {
		conDao.create(contr);
		
	}

	@Override
	public void updateContr(Contructor contr) {
		conDao.update(contr);
		
	}

	@Override
	public void deleteContr(Contructor contr) {
		conDao.delete(contr);
		
	}

	@Override
	public List<Contructor> getAllProducts() {
	
		return conDao.findAll();
	}

	@Override
	public Contructor read(Long id) {
		
		return conDao.read(id);
	}

	@Override
	public int getCount() {
		return conDao.getCount();
		
	} 

}