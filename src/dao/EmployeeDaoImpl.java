package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Employee;
import models.User;
import utility.DataBaseConnect;
import utility.QueryUtility;

public class EmployeeDaoImpl implements EmployeeDao {

	QueryUtility que = new QueryUtility();
	
	@Override
	public String insertEmployee(Employee employee) {
		
		String msg = null;
		
		try {
			Connection con = DataBaseConnect.getInstance().getConnection();
			PreparedStatement ppst = con.prepareStatement(que.inserttEmployee());
			
			ppst.setInt(1, employee.getUserId());
			ppst.setDouble(2, employee.getSalary());
			ppst.setString(3, employee.getAddress());
			ppst.setString(4, employee.getDepartment());
			ppst.setString(5, employee.getGender());
			ppst.setString(6, employee.getStatus());
			
			int x = ppst.executeUpdate();
			if(x > 0) {
				msg = "Employee's Data Inserted Successfully! ";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Employee getAllEmployee(int userId) {
		Employee msg = null;
		
		try {
			Connection con = DataBaseConnect.getInstance().getConnection();
			PreparedStatement ppst = con.prepareStatement(que.getAllDetails());
			
			ppst.setInt(1,userId);
			ResultSet rs = ppst.executeQuery();
			
			if(rs.next()) {
				msg = new Employee();
				msg.setEmpId(rs.getInt("emp_id"));
				msg.setSalary(rs.getDouble("salary"));
				msg.setAddress(rs.getString("address"));
				msg.setDepartment(rs.getString("department"));
				msg.setGender(rs.getString("gender"));
				msg.setStatus(rs.getString("status"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return msg;
	}

	@Override
	public String changeAddress(Employee emp) {
		
        String msg = null;
		
		try {
			Connection con = DataBaseConnect.getInstance().getConnection();
			PreparedStatement ppst = con.prepareStatement(que.changeAddress());
			
			ppst.setString(1, emp.getAddress());
			ppst.setInt(2, emp.getUserId());
			
			int rowhampered = ppst.executeUpdate();
			
			if(rowhampered > 0) {
				msg = "Yehh! Address Updated Successfully";
			}
			con.close();
		}catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String changeNumber(User user) {
		
		String msg = null;
		
		try {
			Connection con = DataBaseConnect.getInstance().getConnection();
			PreparedStatement ppst = con.prepareStatement(que.changeNumber());
			
			ppst.setString(1, user.getPhoneNumber());
			ppst.setInt(2, user.getUserId());
			
			int rowhampered = ppst.executeUpdate();
			
			if(rowhampered > 0) {
				msg = "Yehh! Your Number Updated Successfully";
			}
			con.close();
		}catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return msg;
	}

	@Override
	public String updateStatus(Employee emp) {
		String msg = null;
	
		try {
			Connection con = DataBaseConnect.getInstance().getConnection();
			PreparedStatement ppst = con.prepareStatement(que.changeStatus());
			
			ppst.setString(1, emp.getStatus());
			ppst.setInt(2, emp.getUserId());
			
			int rowhampered = ppst.executeUpdate();
			
			if(rowhampered > 0) {
				msg = "Yehh! Employee Status Updated Successfully";
			}
			
			con.close();
		}catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return msg;
	}
	

}
