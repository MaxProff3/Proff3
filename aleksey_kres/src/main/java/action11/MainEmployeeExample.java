package action11;
	import java.util.List;
	import java.util.Locale;
	import org.apache.log4j.Logger;
	import org.hibernate.HibernateException;
	import org.hibernate.Query;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;

	import domain.Employee;
	import util.HibernateUtil;


	public class MainEmployeeExample {
		private static Logger log = Logger.getLogger(MainProductExample.class);

		public static void main(String[] args) {
			Locale.setDefault(Locale.ENGLISH);

			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			
			Employee employees = new Employee("Fedor", 50);
			try{
				session.beginTransaction();
				session.save(employees);
				session.getTransaction().commit();
			} catch (HibernateException e) {
				log.error("Transaction failed");
				session.getTransaction().rollback();
			} finally {
				if (session != null)
					session.getSessionFactory().close();
			}
		}
	}


