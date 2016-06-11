package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import domain.Contructor;
import domain.Order;
import util.HibernateUtil;

public class OrderDaoImpl implements OrderDao {

	@Override
	public Long create(Order order) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		Long id = null;
		try{
			session.getTransaction().begin();
			id=(Long) session.save(order);
			session.getTransaction().commit();
		}catch(HibernateException e){
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
	return id;
	}

	@Override
	public Order read(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Order order=null;
		try{
			session.getTransaction().begin();
			order=(Order) session.get(Order.class, id);
			session.getTransaction().commit();
		}catch(HibernateException e){
			System.out.println("I cant read this order");
		}finally{
			session.close();
		}
		return order;
	}

	@Override
	public void update(Order order) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.getTransaction().begin();
			session.update(order);
			session.getTransaction().commit();
		}catch(HibernateException e){
			session.getTransaction().rollback();
			System.out.println("no sucsess");
		}finally{
			session.close();
		}
		
	}

	@Override
	public void delete(Order order) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try{
			
			session.getTransaction().begin();
			session.delete(order);
			session.getTransaction().commit();
		}catch(HibernateException e){
			session.getTransaction().rollback();
			System.out.println("no sucsess");
		}finally{
			session.close();
		}
		
	}

	@Override
	public List<Order> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = null;
		try{
		 query=session.createSQLQuery("select * from orders").addEntity(Order.class);
		return query.list();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return  query.list();
	}

}
