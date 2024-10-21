package service;

import java.util.List;

import dao.UserDao;
import dao.UserDaoImpl;
import models.User;

public class UserServiceImpl implements UserService {
	  
	UserDao dao = new UserDaoImpl(); 

	@Override
	public String signUp(User user) {
		
		String msg = dao.signUp(user);
		
		return msg;
	}

	@Override
	public User signIn(String email, String password) {
		User msg = dao.signIn(email, password);
		
		return msg;
	}

	@Override
	public String updatePassword(User user) {
		String msg = dao.updatePassword(user);
		
		return msg;
	}
	
	@Override
	public String updateEmail(User user) {
		String msg = dao.updateEmail(user);
		
		return msg;
	}

	@Override
	public String createAdmin(User admin) {
		String msg = dao.createAdmin(admin);
		
		return msg;
	}

	@Override
	public String deleteAdmin(int id) {
		String msg = dao.deleteAdmin(id);
		
		return msg;
	}
	
	@Override
	public User searchById(int id) {
		User user = dao.searchById(id);
		
		return user;
	}

	@Override
	public List<User> getAllAdmin() {
		List<User> list = dao.getAllAdmin();
		
		return list;
	}

}
