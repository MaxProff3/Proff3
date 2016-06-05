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
		ProductDao contructorDao = new ProductDaoImpl();
		ProductService productService = new ProductServiceImpl(contructorDao);

		List<Product> products = productService.getAllProducts();
		System.out.println(products);

		try{
			HibernateUtil.getSessionFactory().close();
		} catch(Exception e){
			
		}
	}
}
