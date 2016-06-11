package action11;

import dao.EmployeesDaoImpl;
import dao.test.ContructorDao;
import dao.test.ContructorDaoImpl;
import domain.Employees;
import services.test.ContructorServ;
import services.test.ContructorServImpl;

public class MyHibTest {

	public static void main(String[] args) {
		EmployeesDaoImpl emplDAO = new EmployeesDaoImpl();
		//Employees empl = new Employees("Yuriy", 1000);
		ContructorDao dao = new ContructorDaoImpl();
		ContructorServ c = new ContructorServImpl(dao); 
       System.out.println(c.read(4l));
	}

}
