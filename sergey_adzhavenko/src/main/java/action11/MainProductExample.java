package action11;

import java.util.Locale;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import domain.Employee;
import domain.Product;
import util.HibernateUtil;

public class MainProductExample {
	private static Logger log = Logger.getLogger(MainProductExample.class);

	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		Product product = new Product();
		Employee empl = new Employee();
		try {
			session.beginTransaction();
			session.save(empl);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}
}