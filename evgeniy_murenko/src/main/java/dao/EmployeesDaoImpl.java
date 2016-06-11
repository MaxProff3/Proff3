package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import domain.Employee;
import util.HibernateUtil;

public class EmployeesDaoImpl implements EmployeesDao {
	private static Logger log = Logger.getLogger(EmployeesDaoImpl.class);

	@Override
	public Long create(Employee employ) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(employ);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return id;
	}

	@Override
	public Employee read(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Employee employ = null;
		try {
			employ = (Employee) session.get(Employee.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		} finally {
			session.close();
		}
		return employ;
	}

	@Override
	public void update(Employee employ) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(employ);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}
		
	}

	@Override
	public void delete(Employee employ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			// Query query = session.createQuery("from product");
			Query query = session.createQuery("from Employees");
			return query.list();
		} finally {
			session.close();
		}
	}

}
