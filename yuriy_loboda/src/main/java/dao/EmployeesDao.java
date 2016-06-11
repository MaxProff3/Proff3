package dao;

import java.util.List;

import domain.Employees;

public interface EmployeesDao {
	
	 Long create (Employees empl);
	 Employees read(Long id);
	 void update(Employees empl);
	 void delete(Employees empl);
	 List<Employees> findAll();
     List<Employees> findById(int id);
}
