package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import domain.Contructor;
import domain.Employees;
import util.HibernateUtil;

public class ContructorDaoImpl implements ContructorDao {

	@Override
	public Long create(Contructor contr) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		Long id = null;
		try{
			session.getTransaction().begin();
			id=(Long) session.save(contr);
			session.getTransaction().commit();
		}catch(HibernateException e){
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
	return id;
	}

	@Override
	public Contructor read(Long id) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		Contructor c= null;
		try{
			session.getTransaction().begin();
			c= (Contructor) session.get(Contructor.class, id);
			session.getTransaction().commit();
		}catch(HibernateException e){
			System.out.println("We cant read this contr");
		}finally{
			session.close();
		}
		return c;
	}

	@Override
	public void update(Contructor contr) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		try{
			session.getTransaction().begin();
			session.update(contr);
			session.getTransaction().commit();
		}catch(HibernateException e){
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
		
	}

	@Override
	public void delete(Contructor contr) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		try{
			session.getTransaction().begin();
			session.delete(contr);
			session.getTransaction().commit();
		}catch(HibernateException ex){
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
		
	}

	@Override
	public List<Contructor> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = null;
		try{
		 query=session.createSQLQuery("select * from contructors").addEntity(Contructor.class);
		return query.list();
		}catch(HibernateException e){
			System.out.println("fail");
		}finally{
			session.close();
		}
		return  query.list();
	}
	
	
	

}
