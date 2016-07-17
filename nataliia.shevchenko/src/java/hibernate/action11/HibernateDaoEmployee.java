package action11;

import java.util.List;

import org.hibernate.SessionFactory;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import domain.Employee;
import util.HibernateUtil;

public class HibernateDaoEmployee {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		EmployeeDao employeeDao = new EmployeeDaoImpl();
					
		// contructorDao.create(new Contructor("Зкешенко"));

		List<Employee> employeesList = employeeDao.findAll();
		System.out.println(employeesList);
		
		if(factory!=null){
			factory.close();
		}
	}

}
