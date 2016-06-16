package hw6;

import java.util.List;
import java.util.Locale;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.OrderPositionDao;
import dao.OrderPositionDaoImpl;
import domain.Order;
import domain.OrderPosition;
import service.OrderPositionServiceImpl;
import util.HibernateUtil;

public class MainOrderPositionTest {

	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	
		Session session = null;
		Query query = null;
		
		try{
			session = sessionFactory.openSession();
			//OrderPosition op = new OrderPosition();
			
			OrderPositionDao opd = new OrderPositionDaoImpl(sessionFactory);
			OrderPositionServiceImpl ops = new OrderPositionServiceImpl(opd);
			
			/*Get id by name for reading 
			 * (to get obj add to query next line: .addEntity(OrderPosition.class))
			 
			query=session.createSQLQuery("select id from order_positions "
					+ "where summa=1200");
			List<Integer> list = query.list();
			Long temp = new Long(list.get(0));
			System.out.println(">>id="+temp);
			
			OrderPosition op = ops.read(temp);
			
			System.out.println(">>Gotten obj = "+op);
			System.out.println(">>Order"+op.getOrder());
			*/
			
			/*add new
			ops.addNewOrderPosition(new OrderPosition());
			*/
			
			/*Update obj (if this id exists)
			
			OrderPosition op = new OrderPosition();
			op.setId(3l);
			op.setCount(6666);
			op.setSumma(77777);
			//ops.updateOrderPosition(op);
			
			//DELETE
			ops.deleteOrderPosition(op);
			*/
			
			
			
			List<OrderPosition> l = ops.getAllOrderPositions();
			for(int i=0;i<l.size();i++){
				System.out.println(">>ORDER_POSITION "+l.get(i));
				System.out.println(">>ORDER "+l.get(i).getOrder());
			}
			
			
			
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
