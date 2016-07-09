package dao;

import java.util.List;
import domain.Employee;

// CRUD
public interface EmployeeDao {
	
	Long create (Employee employee);
	Employee read(Long id);
	void update(Employee employee);
	void delete(Employee employee);
	List<Employee> findAll();
	
}
