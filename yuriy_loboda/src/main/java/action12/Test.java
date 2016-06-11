package action12;


import dao.OrderDao;
import dao.OrderDaoImpl;
import dao.Order_positionDao;
import dao.Order_positionDaoImpl;
import dao.ProductDao;
import dao.ProductDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import dao.ContructorDao;
import dao.ContructorDaoImpl;
import domain.Contructor;
import domain.Order;
import domain.Order_position;
import domain.Product;
import domain.User;
import services.OrderServ;
import services.OrderServImpl;
import services.Order_positionServ;
import services.Order_positionServImpl;
import services.ProductServiceImpl;
import services.UserServ;
import services.UserServImpl;
import services.test.ContructorServ;
import services.test.ContructorServImpl;
import util.HibernateUtil;


public class Test {

	public static void main(String[] args) {
		
	OrderDao dao = new OrderDaoImpl();
	OrderServ serv = new OrderServImpl(dao);
	Order or = serv.read(20l);
	serv.deleteOrder(or);
	
	}
}
