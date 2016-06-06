package dao;

import java.util.List;
import domain.Employee;


public interface EmployeesDao {
	
	Long create(Employee employ);

	Employee read(Long id);

	void update(Employee employ);

	void delete(Employee employ);

	List<Employee> findAll();

}
