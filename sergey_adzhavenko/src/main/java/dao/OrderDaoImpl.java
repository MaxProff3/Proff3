package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.Order;

public class OrderDaoImpl implements OrderDao{

	private SessionFactory sessionFactory;
	
	public OrderDaoImpl(SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}
	
	@Override
	public Long create(Order order) {
		Long id = null;
		Session mySession = sessionFactory.openSession();

		try {
			mySession.beginTransaction();
			id = (Long) mySession.save(order);
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
	public Order read(Long id) {
		
		Order order = null;
		Session mySession = sessionFactory.openSession();
	
		try{
			order = (Order) mySession.get(Order.class, id);
		}catch (HibernateException e){
		}finally{
			if (mySession != null)
				mySession.close();
		}
		return order;
	}

	@Override
	public void update(Order order) {
		
		Session mySession = sessionFactory.openSession();

		try {
			mySession.beginTransaction();
			mySession.update(order);
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
	public void delete(Order order) {
		
		Session mySession = sessionFactory.openSession();

		try {
			mySession.beginTransaction();
			mySession.delete(order);
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
	public List<Order> findAll() {
		Session mySession = sessionFactory.openSession();
		try{
			Query query = mySession.createQuery("from Order");
			return query.list();
		}finally{
			mySession.close();
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
