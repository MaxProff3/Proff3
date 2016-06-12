package action11;

import java.util.List;

import org.hibernate.SessionFactory;

import dao.ProductDao;
import dao.ProductDaoImpl;
import domain.Product;
import util.HibernateUtil;

public class HibernateDaoProduct {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		ProductDao productDao = new ProductDaoImpl(sessionFactory);

		List<Product> products = productDao.findAll();
		System.out.println(products);
		
		HibernateUtil.getSessionFactory().close();
	}
}
