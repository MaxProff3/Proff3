package hw6;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Locale;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import dao.ContructorDAO;
import dao.ContructorDaoImpl;
import domain.Contructor;
import service.ContructorServiceImpl;
import util.HibernateUtil;

public class TestAddContructor {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private Session session = null;
	private static final String NAME = "test1Contructor";
	
	@Test
	public void test() {
		
		Locale.setDefault(Locale.ENGLISH);
		Contructor contructor = new Contructor(NAME);
		ContructorDAO cDAO = null;
		ContructorServiceImpl cService = null;
		
		try{
			session = sessionFactory.openSession();
			cDAO = new ContructorDaoImpl(sessionFactory);
			cService = new ContructorServiceImpl(cDAO);
			cService.addNewContructor(contructor);
			
			List<Contructor> list = cService.getAllContructors();
			if(list.size()==0)fail("List size = 0!");
			boolean bool = false;
			for(int i = 0; i < list.size();i++){
				if(list.get(i).getConstructorName().equals(contructor.getConstructorName())){
					bool = true;
					System.out.println(">>Objects are equal!");
					break;
				}
			}
			if(!bool)fail("Objects do not equal!");
			
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
