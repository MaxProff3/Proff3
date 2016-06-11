package action11;

import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.EmployeesDaoImpl;
import dao.ProductDaoImpl;
import domain.Employees;
import domain.Product;
import util.HibernateUtil;


public class MainProductExemple {
	private static Logger log = Logger.getLogger(MainProductExemple.class);

	public static void main(String[] args) {
		
		ProductDaoImpl emplDAO = new ProductDaoImpl();
		Product empl = new Product("",10);
        emplDAO.create(empl);
	/*	Locale.setDefault(Locale.ENGLISH);

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		Product product = new Product();
		try{
			session.beginTransaction();
			session.save(product);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}
		*/
	}
	
}
