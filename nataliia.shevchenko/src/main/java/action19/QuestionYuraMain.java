package action19;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import domain.User;
import util.HibernateUtil;

public class QuestionYuraMain {
	public static void main(String[] args) {
		String str = "us";
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = null;
		List<User> list = null;
		try {
			query = session.createSQLQuery("select * from users where name like :a").addEntity(User.class);
			// String s = "что-то такое \"Что-то в кавычках\" еще что-то.";
			query.setParameter("a", "%" + str + "%");
			list = query.list();

			System.out.println("list=" + list);

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
