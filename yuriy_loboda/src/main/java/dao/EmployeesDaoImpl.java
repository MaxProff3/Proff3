package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import domain.Employees;
import util.HibernateUtil;

public class EmployeesDaoImpl implements EmployeesDao {

	@Override
	public Long create(Employees empl) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Long id=null;
		try{
			session.getTransaction().begin();
			id=(Long)session.save(empl);
			session.getTransaction().commit();
		}catch(Throwable th){
			session.getTransaction().rollback();;
			System.out.println("We dont create employeer");
		}finally{
			if(session!=null)
			session.close();
		}
		return id;
		

	}

	@Override
	public Employees read(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Employees empl=null;
		try{
			session.getTransaction().begin();
			empl=(Employees) session.get(Employees.class,id);
			session.getTransaction().commit();
		}catch(HibernateException e){
			System.out.println("cant read employee");
		}finally{
			session.close();
		}
		return empl;
	}

	@Override
	public void update(Employees empl) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.getTransaction().begin();
			session.update(empl);
			session.getTransaction().commit();
		}catch(HibernateException e){
			session.getTransaction().rollback();
			System.out.println("cant update");
		}finally{
			session.close();
		}
		
		
	}

	@Override
	public void delete(Employees empl) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.getTransaction().begin();
			session.delete(empl);
			session.getTransaction().commit();
		}catch(HibernateException e){
			session.getTransaction().rollback();
			System.out.println("cant delete this user");
		}finally{
			session.close();
		}
		
	}

	@Override
	public List<Employees> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = null;
		try{
		 query=session.createSQLQuery("select * from employees").addEntity(Employees.class);
		return query.list();
		}catch(HibernateException e){
			System.out.println("fail");
		}finally{
			session.close();
		}
		return  query.list();
	}

	@Override
	public List<Employees> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
/*
	@Override
	public List<Employees> findById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = null;
		try{
			query=session.createSQLQuery("select * from employees where employees.id :id);
			return query.list();
		}catch(HibernateException e){
			System.out.println("fail");
		}finally{
			session.close();
		}
		return query.list();
	}

	
	
	*/

}
