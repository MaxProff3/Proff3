package action11;

import java.util.List;

import dao.ProductDao;
import dao.ProductDaoImpl;
import domain.Product;
import util.HibernateUtil;

public class HibernateDaoProduct {
	public static void main(String[] args) {
		ProductDao productDao = new ProductDaoImpl();

		List<Product> products = productDao.findAll();
		System.out.println(products);
		
		HibernateUtil.getSessionFactory().close();
	}
}
