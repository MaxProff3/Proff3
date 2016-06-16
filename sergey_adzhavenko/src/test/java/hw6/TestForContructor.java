package hw6;

import static org.junit.Assert.*;

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

public class TestForContructor {

	@Test
	public void test() {
		Locale.setDefault(Locale.ENGLISH);
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = null;
		
		try{
			session = sessionFactory.openSession();
			
			Contructor contructor = new Contructor("Рошен");
			ContructorDAO cdao = new ContructorDaoImpl(sessionFactory);
			ContructorServiceImpl csi = new ContructorServiceImpl(cdao);
			
			csi.addNewContructor(contructor);
		
		}catch (HibernateException e) {
			fail(">>Error in catch (HibernateException e)");
			e.printStackTrace();
		}finally {
			if (session != null) {
				session.close();
			}
			if (sessionFactory != null) {
				sessionFactory.close();
			}
			System.out.println("Session is closed!");
		}
		
		fail("Not yet implemented");
	}

}
