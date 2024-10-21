package service;

import java.util.List;

import models.User;

public interface AdminService {
    public int createEmployee(User employee);
	
	public String deleteEmployee(int id);
	
	public List<User> getAllEmployee();
}
