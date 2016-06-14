package hw6;

import java.util.Locale;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.OrderPosition;
import util.HibernateUtil;

public class MainOrderPositionTest {

	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	
		Session session = null;
		Query query = null;
		
		try{
			session = sessionFactory.openSession();
			
			OrderPosition op = new OrderPosition();
			
		}catch (HibernateException e) {
			System.out.println("Error!!!");
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
	}
}
