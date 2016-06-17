package hw6;

import static org.junit.Assert.fail;

import java.util.Locale;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import dao.ContructorDAO;
import dao.ContructorDaoImpl;
import domain.Contructor;
import service.ContructorServiceImpl;
import util.HibernateUtil;

public class TestUpdateContructor {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private Session session = null;
	private static final String NAME = "test2Contructor";
	private static final String UPDATED_NAME = "updatedTest2Contructor";
	
	@Test
	public void test() {
		
		Locale.setDefault(Locale.ENGLISH);
		Query query = null;
		Contructor contructor = new Contructor(NAME);
		Contructor contructorFromDB;
		Contructor updatedContructorFromDB;
		ContructorDAO cDAO = null;
		ContructorServiceImpl cService = null;

		try{
			session = sessionFactory.openSession();
			cDAO = new ContructorDaoImpl(sessionFactory);
			cService = new ContructorServiceImpl(cDAO);
			cService.addNewContructor(contructor);
			query = session.createQuery("from Contructor where name like :name")
					.setParameter("name", NAME);
			if(query.list().size()==0)fail("List size = 0!");
			
			contructorFromDB = (Contructor)query.list().get(0);
			Long id = contructorFromDB.getId();
			
			contructorFromDB.setConstructorName(UPDATED_NAME);
			cService.updateContructor(contructorFromDB);
			
			updatedContructorFromDB = cService.read(id);
			if(!updatedContructorFromDB.getConstructorName().equals(UPDATED_NAME)){
				fail("Updating failed!");
			}
			
		}catch (HibernateException e) {
			fail("Error in catch!");
			e.printStackTrace();
		}finally {
			if (session != null) session.close();
			if (sessionFactory != null) sessionFactory.close();
			System.out.println("Session is closed!");
		}
	}

}
