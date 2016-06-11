package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import domain.User;
import util.HibernateUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public Long create(User user) {

		Long id = null;
		Session mySession = HibernateUtil.getSessionFactory().openSession();

		try {
			mySession.beginTransaction();
			id = (Long) mySession.save(user);
			mySession.getTransaction().commit();
			System.out.println(">> Successfully created!");
		} catch (HibernateException e) {
			mySession.getTransaction().rollback();
			System.out.println(">> Creation failed!");
		} finally {
			if (mySession != null)
				mySession.close();
		}

		return id;
	}

	@Override
	public User read(Long id) {
		User user = null;
		Session mySession = HibernateUtil.getSessionFactory().openSession();

		try {
			user = (User) mySession.get(User.class, id);
		} catch (HibernateException e) {
		} finally {
			if (mySession != null)
				mySession.close();
		}

		return user;
	}

	@Override
	public void update(User user) {
		Session mySession = HibernateUtil.getSessionFactory().openSession();

		try {
			mySession.beginTransaction();
			mySession.update(user);
			mySession.getTransaction().commit();
			System.out.println(">> Successfully updated!");
		} catch (HibernateException e) {
			mySession.getTransaction().rollback();
			System.out.println(">> Updating failed!");
		} finally {
			if (mySession != null)
				mySession.close();
		}
	}

	@Override
	public void delete(User user) {
		Session mySession = HibernateUtil.getSessionFactory().openSession();

		try {
			mySession.beginTransaction();
			mySession.delete(user);
			mySession.getTransaction().commit();
			System.out.println(">> Object is successfully deleted!");
		} catch (HibernateException e) {
			System.out.println(">> Deletion failed!");
			mySession.getTransaction().rollback();
		} finally {
			if (mySession != null)
				mySession.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		Session mySession = HibernateUtil.getSessionFactory().openSession();
		try{
			Query query = mySession.createQuery("from User");
			return query.list();
		}finally{
			mySession.close();
		}
		
	}

}
