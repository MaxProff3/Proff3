package action11;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import domain.Employee;
import util.HibernateUtil;

public class HibernateSimpleExampleProductsInsert {
	private static Logger log = Logger.getLogger(HibernateSimpleExampleProductsInsert.class);

	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);

		SessionFactory factory = HibernateUtil.getSessionFactory();
		log.info("Reference to SessionFactory " + factory);

		Session session = null;
		try {
			session = factory.openSession();
			log.info("session opened!");
			session.beginTransaction();

			Employee contructor = new Employee(12L, "SomethingWrite", 345);
			session.save(contructor);

			session.getTransaction().commit();

		} catch (HibernateException e) {
			log.error("Open session failed", e);
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.close();
			}
			if (factory != null) {
				factory.close();
			}
		}
		log.info("session = " + session);
	}

}
