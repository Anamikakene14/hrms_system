package dao;

import java.util.List;

import models.User;

public interface AdminDao {
	
	public int createEmployee(User employee);
	
	public String deleteEmployee(int id);
	
	public List<User> getAllEmployee();
}
