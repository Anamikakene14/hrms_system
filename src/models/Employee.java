package models;

public class Employee {
	private int empId;
	private int userId;
	private double salary;
	private String address;
	private String department;
	private String gender;
	private String status;
	
	public int getEmpId() {
		return empId;
	}
	
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public Employee(int empId, int userId, double salary, String address, String department, String gender,
			String status) {
		super();
		this.empId = empId;
		this.userId = userId;
		this.salary = salary;
		this.address = address;
		this.department = department;
		this.gender = gender;
		this.status = status;
	}
	
	public Employee() {
		
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", userId=" + userId + ", salary=" + salary + ", address=" + address
				+ ", department=" + department + ", gender=" + gender + ", status=" + status + "]";
	}

	
	
}

