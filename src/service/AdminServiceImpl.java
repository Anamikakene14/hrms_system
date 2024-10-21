package service;

import java.util.List;
import dao.AdminDao;
import dao.AdminDaoImpl;

import models.User;

public class AdminServiceImpl implements AdminService {
	
	AdminDao dao = new AdminDaoImpl();

	@Override
	public int createEmployee(User employee) {
		
		return dao.createEmployee(employee) ;
	}

	@Override
	public String deleteEmployee(int id) {
		String msg = dao.deleteEmployee(id);
		
		return msg;
	}

	@Override
	public List<User> getAllEmployee() {
		List<User> list = dao.getAllEmployee();
		
		return list;
	}

}
