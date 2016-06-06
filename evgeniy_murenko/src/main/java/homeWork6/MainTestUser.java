package homeWork6;

import java.util.List;
import dao.UserDao;
import dao.UserDaoImpl;
import domain.User;
import service.UserService;
import service.UserServiceImpl;
import util.HibernateUtil;

public class MainTestUser {
	public static void main(String[] args) {
		UserDao userDao = new UserDaoImpl();
		UserService userService = new UserServiceImpl(userDao);
		List<User> products = userService.getAllUser();
		System.out.println(products);
		try {
			HibernateUtil.getSessionFactory().close();
		} catch (Exception e) {

		}
	}
}
