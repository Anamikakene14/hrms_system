package service;

import java.util.List;

import models.User;

public interface UserService {

	public String signUp(User user);
	
	public User signIn(String email, String password);
	
    public String updatePassword(User user);
	
	public String createAdmin(User admin);
	
	public String deleteAdmin(int id);
	
	public User searchById(int id);
	
	public List<User> getAllAdmin();
	
	public String updateEmail(User user);
	
}
