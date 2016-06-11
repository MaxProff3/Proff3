package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import domain.Contructor;
import domain.Order_position;
import util.HibernateUtil;

public class Order_positionDaoImpl implements Order_positionDao {

	@Override
	public Long create(Order_position pos) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		Long id = null;
		try{
			session.getTransaction().begin();
			id=(Long) session.save(pos);
			session.getTransaction().commit();
		}catch(HibernateException e){
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
	return id;
		
	}

	@Override
	public Order_position read(Long id) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		Order_position o= null;
		try{
			session.getTransaction().begin();
			o= (Order_position) session.get(Order_position.class, id);
			session.getTransaction().commit();
		}catch(HibernateException e){
			System.out.println("We cant read this contr");
		}finally{
			session.close();
		}
		return o;
	}

	@Override
	public void update(Order_position pos) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		try{
			session.getTransaction().begin();
			session.update(pos);
			session.getTransaction().commit();
		}catch(HibernateException e){
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
		
	}

	@Override
	public void delete(Order_position pos) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		try{
			session.getTransaction().begin();
			session.delete(pos);
			session.getTransaction().commit();
		}catch(HibernateException ex){
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
		

		
	}

	@Override
	public List<Order_position> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = null;
		try{
		 query=session.createSQLQuery("select * from order_positions").addEntity(Order_position.class);
		return query.list();
		}catch(HibernateException e){
			System.out.println("fail");
		}finally{
			session.close();
		}
		return  query.list();
	}
	

}
