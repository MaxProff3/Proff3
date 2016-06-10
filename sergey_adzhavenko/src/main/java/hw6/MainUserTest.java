package hw6;

import java.util.List;
import java.util.Locale;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.UserDao;
import dao.UserDaoImpl;
import domain.Employee;
import domain.User;
import service.UserServiceImpl;
import util.HibernateUtil;

public class MainUserTest {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.ENGLISH);
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	
		Session session = null;
		Query query = null;
		
		try{
			session = sessionFactory.openSession();
			Employee employee = new Employee();
			employee.setId(0l);
			User user = new User("John2", "root2", "root", employee);
			UserDao udao = new UserDaoImpl();
			UserServiceImpl usi = new UserServiceImpl(udao);
			
			/*add new User into DB
			usi.addNewUser(user);
			*/
			
			/*Get id by number for reading
			query=session.createSQLQuery("select id from users where name='"+user.getName()+"'");
			List<Integer> list = query.list();
			Long temp = new Long(list.get(0));
			System.out.println("id: "+temp);
			*/
			User tempUser = usi.read(5l);
			System.out.println("tempUser: "+tempUser);
			
			
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
