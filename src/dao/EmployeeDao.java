package dao;

import models.Employee;
import models.User;

public interface EmployeeDao {

	public String insertEmployee(Employee employee);
	
	public Employee getAllEmployee(int userId);
	
	public String changeAddress(Employee employee);
	
	public String changeNumber(User user);
	
	public String updateStatus(Employee emp);
}
