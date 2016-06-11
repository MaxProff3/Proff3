package hw6;

import java.util.List;
import java.util.Locale;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.OrderDao;
import dao.OrderDaoImpl;
import domain.Order;
import service.OrderServiceImpl;
import util.HibernateUtil;

public class MainOrderTest {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.ENGLISH);
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	
		Session session = null;
		Query query = null;
		
		try{
			session = sessionFactory.openSession();
			Order order = new Order("ZAK001",11,1000);
			OrderDao odao = new OrderDaoImpl();
			OrderServiceImpl osi = new OrderServiceImpl(odao);
			
			/*add new Order into DB
			osi.addNewOrder(order);
			*/
			
			/*Get id by number for reading
			query=session.createSQLQuery("select id from orders where number='"+order.getNumber()+"'");
			List<Integer> list = query.list();
			Long temp = new Long(list.get(0));
			System.out.println("id: "+temp);
			
			Order orderFromDB = osi.read(temp);
			System.out.println("orderFromDB: "+orderFromDB);
			*/
			
			/*to delete obg from DB
			query=session.createSQLQuery("select * from orders "
					+ "where number='"+order.getNumber()+"'").addEntity(Order.class);
			List<Order> listOrder = query.list();
			osi.deleteOrder(listOrder.get(0));
			*/
			
			/*Update obj
			query=session.createSQLQuery("select id from orders "
					+ "where number='"+order.getNumber()+"'");
			List<Integer> list = query.list();
			Long temp = new Long(list.get(0));
			order.setId(temp);
			order.setNumber("newZAKAZ");
			osi.updateOrder(order);
			*/
			
		}catch (HibernateException e) {
			System.out.println("Error!!!");
			e.printStackTrace();
		}finally {
			if (session != null) {
				session.close();
			}
			if (sessionFactory != null) {
				sessionFactory.close();
			}
			System.out.println("Session is closed!");
		}
	}

}
