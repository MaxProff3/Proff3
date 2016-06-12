package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import domain.OrderPosition;
import util.HibernateUtil;

public class OrderPositionDaoImpl implements OrderPositionDao{

	@Override
	public Long create(OrderPosition op) {
		Long id = null;
		Session mySession = HibernateUtil.getSessionFactory().openSession();
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
		Session mySession = HibernateUtil.getSessionFactory().openSession();

		try {
			op = (OrderPosition) mySession.get(OrderPosition.class, id);
		} catch (HibernateException e) {
		} finally {
			if (mySession != null) mySession.close();
		}

		return op;
	}

	@Override
	public void update(OrderPosition op) {
		Session mySession = HibernateUtil.getSessionFactory().openSession();

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

		Session mySession = HibernateUtil.getSessionFactory().openSession();

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
		Session mySession = HibernateUtil.getSessionFactory().openSession();
		try{
			Query query = mySession.createQuery("from OrderPosition");
			return query.list();
		}finally{
			mySession.close();
		}
	}

}
