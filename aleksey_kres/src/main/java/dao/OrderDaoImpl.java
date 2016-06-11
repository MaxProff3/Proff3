package dao;
	import java.util.List;
	import org.apache.log4j.Logger;
	import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sun.org.apache.bcel.internal.generic.ReturnaddressType;

import domain.Order;
import util.HibernateUtil;

	public class OrderDaoImpl implements OrderDao {
		private static Logger log = Logger.getLogger(ProductDaoImpl.class);

		@Override
		public Long create(Order order) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Long id = null;
			try {
				session.beginTransaction();
				id = (Long) session.save(order);
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
		public Order read(Long id) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Order order = null;
			try {
				order = (Order) session.get(Order.class, id);
			} catch (HibernateException e) {
				log.error("Transaction failed");
			} finally {
				session.close();
			}
			return order;
		}

		@Override
		public void update(Order order) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				session.beginTransaction();
				session.update(order);
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
		public void delete(Order order) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				session.beginTransaction();
				session.delete(order);
				session.getTransaction().commit();
			} catch (HibernateException e) {
				log.error("Transaction failed");
				session.getTransaction().rollback();
			}finally {
				if (session != null) {
					session.clear();
				}
			}
		}

		@Override
		public List<Order> findAll() {
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				// Query query = session.createQuery("from product");
				Query query = session.createQuery("from Order");
				return query.list();
			} finally {
				session.close();
			}
		}

		@Override
		public List<Order> findOrdersByBeginString(String begin) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Query query = session.createQuery("from Order where number like '" + begin + "%'");
				return query.list();
			} finally {
				session.close();
			}
		}

}
