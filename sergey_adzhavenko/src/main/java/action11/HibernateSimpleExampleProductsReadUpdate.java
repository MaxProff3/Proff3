package action11;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import domain.Product;

public class HibernateSimpleExampleProductsReadUpdate {
	private static Logger log = Logger.getLogger(HibernateSimpleExampleProductsReadUpdate.class);

	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
		sb.applySettings(cfg.getProperties());
		StandardServiceRegistry standardServiceRegistry = sb.build();
		SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
		log.info("Reference to SessionFactory " + factory);

		Session session = null;
		try {
			session = factory.openSession();
			log.info("session opened!");
			session.beginTransaction();

			Product product = (Product) session.get(Product.class, 1L);
			System.out.println("getCuntractor_by_id=1: " + product);
			product.setName("Р¤РћРџ Р—Р°Р·РЅР°Р№РєРёРЅ");
			System.out.println("change name: " + product);
			session.update(product);

			// session.delete(contructor);

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
		log.info(session);
	}
}
