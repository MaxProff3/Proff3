package hw6;

import java.util.List;
import java.util.Locale;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.ContructorDAO;
import dao.ContructorDaoImpl;
import dao.OrderDao;
import dao.OrderDaoImpl;
import domain.Contructor;
import domain.Order;
import service.ContructorServiceImpl;
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
			OrderDao odao = new OrderDaoImpl(sessionFactory);
			OrderServiceImpl osi = new OrderServiceImpl(odao);
			
			/*
			ContructorDAO cdao = new ContructorDaoImpl();
			ContructorServiceImpl csi = new ContructorServiceImpl(cdao);
			query=session.createSQLQuery("select id from contructors "
					+ "where name='ФОП Пупкин'");
			List<Integer> list = query.list();
			Long temp = new Long(list.get(0));
			//System.out.println(">>id="+temp);
			
			Contructor cns = csi.read(temp);
			
			
			Order order = new Order("ZAK012",cns,11,1000);
			*/
			
			/*add new Order into DB
			osi.addNewOrder(order);
			*/
			
			/*Get id by number for reading
			query=session.createSQLQuery("select id from orders where number='ZAK012'");
			List<Integer> list2 = query.list();
			Long temp2 = new Long(list2.get(0));
			System.out.println("id: "+temp2);
			
			Order orderFromDB = osi.read(temp2);
			System.out.println(">>orderFromDB: "+orderFromDB);
			*/
			
			/*DOES NOT WORK!!!!!! to delete obg from DB*/
			query=session.createSQLQuery("select * from orders "
					+ "where number='ZAK006'").addEntity(Order.class);
			List<Order> listOrder = query.list();
			System.out.println(">>Order: "+listOrder.get(0));
			osi.deleteOrder(listOrder.get(0));
			
			
			/*Update obj
			query=session.createSQLQuery("select id from orders "
					+ "where number='"+orderFromDB.getNumber()+"'");
			List<Integer> list = query.list();
			Long temp = new Long(list.get(0));
			orderFromDB.setId(temp);
			orderFromDB.setNumber("newZAKAZ");
			osi.updateOrder(orderFromDB);
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
