package service;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import models.Employee;
import models.User;

public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDao dao = new EmployeeDaoImpl();

	@Override
	public String createEmployee(Employee employee) {
		
		String msg = dao.insertEmployee(employee);
		
		return msg;
	}

	@Override
	public Employee getAllEmployee(int userId) {
		
		return dao.getAllEmployee(userId);
	}

	@Override
	public String changeAddress(Employee employee) {

		String msg = dao.changeAddress(employee);
		
		return msg;
	}

	@Override
	public String changeNumber(User user) {
		
		String msg = dao.changeNumber(user);
		
		return msg;
	}

	@Override
	public String updateStatus(Employee emp) {
		
		String msg = dao.updateStatus(emp);
		
		return msg;
	}

}
