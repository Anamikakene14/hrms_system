package service;

import models.Employee;
import models.User;

public interface EmployeeService {
	public String createEmployee(Employee employee);
	
	public Employee getAllEmployee(int userId);
	
	public String changeAddress(Employee employee);
	
	public String changeNumber(User user);
	
	public String updateStatus(Employee emp);
}
