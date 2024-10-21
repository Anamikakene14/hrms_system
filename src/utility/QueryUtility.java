package utility;

public class QueryUtility {
	
	public String signUp() {
		return "insert into Users(name,email,password,phone_number,role) values(?,?,?,?,?) ";
	}
	
	public String signIn() {
		return "SELECT * FROM Users WHERE email = ? AND password = ?";
	}
	
	public String updatePassword() {
		return "update users set password = ? where user_id = ?";
	}
	
	public String updateEmail() {
		return "update users set email = ? where user_id = ?";
	}
	
	public String insertAdmin() {
		return "insert into Users(name,email,password,phone_number,role) values(?,?,?,?,?)";
	}
	
	public String listAllUser() {
		return "select * from users where role = 'Admin'";
	}
	
	public String searchById() {
		return "select * from users where user_id = ? ";
	}
	
	public String deleteAdmin() {
		return "delete from Users where user_id = ?";
	}
	
	public String insertEmployee() {
		return "insert into Users(name,email,password,phone_number,role) values(?,?,?,?,?)";
	}
	
	public String deleteEmployee() {
		return "delete from Users where user_id = ?";
	}
	
	public String getAllEmployee() {
		return "select * from users where role = 'Employee'";
	}
	
	public String inserttEmployee() {
		return "insert into Employee(user_id,salary,address,department,gender,status) values(?,?,?,?,?,?)" ;
	}
	
	public String getAllDetails() {
		return "select e.emp_id,e.salary,e.address, e.department, e.gender, e.status from employee e join users u on e.user_id = u.user_id where u.user_id = ?";
	}
	
	public String changeAddress() {
		return "update employee set address = ? where user_id = ? "; 
	}
	
	public String changeNumber() {
		return "update users set phone_number = ? where user_id = ?";
	}
	
	public String changeStatus() {
		return "update employee set status = ? where user_id = ?";
	}
}
