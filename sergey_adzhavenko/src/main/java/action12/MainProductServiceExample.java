package action12;

import java.util.List;

import org.hibernate.SessionFactory;

import dao.ProductDao;
import dao.ProductDaoImpl;
import domain.Product;
import service.ProductService;
import service.ProductServiceImpl;
import util.HibernateUtil;

public class MainProductServiceExample {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		ProductDao productDao = new ProductDaoImpl(sessionFactory);
		ProductService productService = new ProductServiceImpl(productDao);

		List<Product> products = productService.getAllProducts();
		System.out.println(products);

		// HibernateUtil.getSessionFactory().close();

		try {
			HibernateUtil.getSessionFactory().close();
		} catch (Exception e) {

		}
	}
}
