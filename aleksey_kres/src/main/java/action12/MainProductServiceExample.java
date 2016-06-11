package action12;

import java.util.List;

import dao.ProductDao;
import dao.ProductDaoImpl;
import domain.Product;
import service.ProductService;
import service.ProductServiceImpl;
import util.HibernateUtil;

public class MainProductServiceExample {
	public static void main(String[] args) {
		ProductDao productDao = new ProductDaoImpl();
		ProductService productService = new ProductServiceImpl(productDao);

		List<Product> products = productService.getAllProducts();
		System.out.println(products);
		
		// HibernateUtil.getSessionFactory().close();
		
		try {
			HibernateUtil.getSessionFactory().close();
		} catch(Exception e){
			
		}
	}
}
