package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import domain.Contructor;
import domain.User;
import util.HibernateUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public Long create(User user) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		Long id = null;
		try{
			session.getTransaction().begin();
			id=(Long) session.save(user);
			session.getTransaction().commit();
		}catch(HibernateException e){
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
	return id;
	}

	@Override
	public User read(Long id) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		User u= null;
		try{
			session.getTransaction().begin();
			u= (User) session.get(User.class, id);
			session.getTransaction().commit();
		}catch(HibernateException e){
			System.out.println("We cant read this contr");
		}finally{
			session.close();
		}
		return u;
	}

	@Override
	public void update(User user) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		try{
			session.getTransaction().begin();
			session.update(user);
			session.getTransaction().commit();
		}catch(HibernateException e){
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
		
		
	}

	@Override
	public void delete(User user) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		try{
			session.getTransaction().begin();
			session.delete(user);
			session.getTransaction().commit();
		}catch(HibernateException ex){
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
		
	}

	@Override
	public boolean findUserByLoginAndPass(String login, String pass) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = null;
		List<User> list=null;
		try{
			query=session.createSQLQuery("select * from users  where users.login =:login and users.pass=:pass").addEntity(User.class);
			query.setParameter("login",login);
			query.setParameter("pass",pass);
			list=query.list();
			User user = list.get(0);
			//System.err.println(user.getEmployee());
			if(user!=null){
				return true;
			}
		    
		//	System.err.println(query.getNamedParameters());
		//	System.err.println(list);
			return true;
		}catch(HibernateException e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<User> findAll() {
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
