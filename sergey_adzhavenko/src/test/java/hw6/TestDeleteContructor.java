package hw6;

import static org.junit.Assert.*;

import java.util.List;
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

public class TestDeleteContructor {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private Session session = null;
	private static final String NAME = "test3Contructor";
	
	@Test
	public void test() {
		Locale.setDefault(Locale.ENGLISH);
		Query query = null;
		Contructor contructor = new Contructor(NAME);
		Contructor contructorFromDB;
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
			
			System.out.println(">>Test3: contructorFromDB = "+contructorFromDB);
			cService.deleteContructor(contructorFromDB);
			
			List<Contructor> list = cService.getAllContructors();
			for(int i = 0; i < list.size();i++){
				if(list.get(i).getConstructorName().equals(NAME)){
					fail("Deletion failed!");
				}
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
