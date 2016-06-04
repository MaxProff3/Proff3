package action11;

import java.util.List;

import org.hibernate.SessionFactory;

import dao.ContructorDao;
import dao.ContructorDaoImpl;
import dao.ProductDao;
import dao.ProductDaoImpl;
import domain.Contructor;
import util.HibernateUtil;

public class HibernateDaoProduct {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		ProductDao productDao = new ProductDaoImpl(factory);

		// contructorDao.create(new Contructor("Зкешенко"));

		List<Product> contructors = productDao.findAll();
		System.out.println(contructors);
		
		if(factory!=null){
			factory.close();
		}
	}
}
