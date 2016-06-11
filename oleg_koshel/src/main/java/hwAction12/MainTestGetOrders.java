package hwAction12;

import java.util.List;

import dao.ContructorDaoImpl;
import dao.OrderDaoImpl;
import domain.Contructor;
import domain.Order;
import service.ContructorServiceImpl;
import service.OrderServiceImpl;

public class MainTestGetOrders {
	
	public static void main(String[] args) {
		
        OrderDaoImpl contructorDaoImpl =new OrderDaoImpl();  
        OrderServiceImpl orderServiceImpl = new OrderServiceImpl(contructorDaoImpl); 
        
        List<Order> orderArray = orderServiceImpl.getAllOrders();
        
        
		for (Order c:orderArray){
			
			System.out.println("______________");
			
			System.out.println(c);
			
		}
		
	}

}
