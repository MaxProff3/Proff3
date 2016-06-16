package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.OrderPosition;

public class OrderPositionDaoImpl implements OrderPositionDao{

	private SessionFactory sessionFactory;
	
	public OrderPositionDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Long create(OrderPosition op) {
		Long id = null;
		Session mySession = sessionFactory.openSession();
		try {
			mySession.beginTransaction();
			id = (Long) mySession.save(op);
			mySession.getTransaction().commit();
			System.out.println(">> Successfully created!");
		} catch (HibernateException e) {
			mySession.getTransaction().rollback();
			System.out.println(">> Creation failed!");
		} finally {
			if (mySession != null) mySession.close();
		}

		return id;
	}

	@Override
	public OrderPosition read(Long id) {
		OrderPosition op = null;
		Session mySession = sessionFactory.openSession();

		try {
			op = (OrderPosition) mySession.get(OrderPosition.class, id);
			Hibernate.initialize(op.getOrder());
		} catch (HibernateException e) {
		} finally {
			if (mySession != null) mySession.close();
		}

		return op;
	}

	@Override
	public void update(OrderPosition op) {
		Session mySession = sessionFactory.openSession();

		try {
			mySession.beginTransaction();
			mySession.update(op);
			mySession.getTransaction().commit();
			System.out.println(">> Successfully updated!");
		} catch (HibernateException e) {
			mySession.getTransaction().rollback();
			System.out.println(">> Updating failed!");
		} finally {
			if (mySession != null) mySession.close();
		}
	}

	@Override
	public void delete(OrderPosition op) {

		Session mySession = sessionFactory.openSession();

		try {
			mySession.beginTransaction();
			mySession.delete(op);
			mySession.getTransaction().commit();
			System.out.println(">> Object is successfully deleted!");
		} catch (HibernateException e) {
			System.out.println(">> Deletion failed!");
			mySession.getTransaction().rollback();
		} finally {
			if (mySession != null) mySession.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderPosition> findAll() {
		Session mySession = sessionFactory.openSession();
		try{
			Query query = mySession.createQuery("from OrderPosition");
			List<OrderPosition> list = query.list();
			for(int i=0;i<list.size();i++){
				Hibernate.initialize(list.get(i).getOrder());
			}
			return list;
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
