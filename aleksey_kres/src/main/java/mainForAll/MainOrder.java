package mainForAll;

import dao.OrderDaoImpl;
import domain.Order;

public class MainOrder {
	public static void main (String[] args) {
	OrderDaoImpl orderImpl = new OrderDaoImpl();
	Order order = new Order(9L,"NewZakaz",2,5,999);
//	orderImpl.create(order);
	for (Order i : orderImpl.findOrdersByBeginString("z")) {
		System.out.println(i);
	}
	
	}
}
