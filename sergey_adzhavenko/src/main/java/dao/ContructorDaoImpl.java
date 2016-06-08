package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import domain.Contructor;
import util.HibernateUtil;

public class ContructorDaoImpl implements ContructorDAO{

	@Override
	public Long create(Contructor contructor) {

		Long id = null;
		Session mySession = HibernateUtil.getSessionFactory().openSession();

		try {
			mySession.beginTransaction();
			id = (Long) mySession.save(contructor);
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
	public Contructor read(Long id) {

		Contructor contructor = null;
		Session mySession = HibernateUtil.getSessionFactory().openSession();

		try {
			contructor = (Contructor) mySession.get(Contructor.class, id);
		} catch (HibernateException e) {
		} finally {
			if (mySession != null)
				mySession.close();
		}

		return contructor;
	}

	@Override
	public void update(Contructor contructor) {

		Session mySession = HibernateUtil.getSessionFactory().openSession();

		try {
			mySession.beginTransaction();
			mySession.update(contructor);
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
	public void delete(Contructor contructor) {

		Session mySession = HibernateUtil.getSessionFactory().openSession();

		try {
			mySession.beginTransaction();
			mySession.delete(contructor);
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
	public List<Contructor> findAll() {
		Session mySession = HibernateUtil.getSessionFactory().openSession();
		try{
			Query query = mySession.createQuery("from Contructor");
			return query.list();
		}finally{
			mySession.close();
		}
		
	}

}

