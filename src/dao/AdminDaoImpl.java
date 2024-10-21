package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.User;
import utility.DataBaseConnect;
import utility.QueryUtility;

public class AdminDaoImpl implements AdminDao {
	QueryUtility que = new QueryUtility();

	@Override
	public int createEmployee(User employee) {
		int  userId = 0;

		try {
			Connection conn = DataBaseConnect.getInstance().getConnection();
			PreparedStatement ppst = conn.prepareStatement(que.insertEmployee(),Statement.RETURN_GENERATED_KEYS);
			
			ppst.setString(1, employee.getName());
			ppst.setString(2, employee.getEmail());
			ppst.setString(3, employee.getPassword());
			ppst.setString(4, employee.getPhoneNumber());
			ppst.setString(5, employee.getRole());
			
			int rowhampered = ppst.executeUpdate();
			
			if(rowhampered > 0) {
				ResultSet rs = ppst.getGeneratedKeys();
				if(rs.next()) {
					userId = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userId;
	}

	@Override
	public String deleteEmployee(int id) {
		String msg = null;
		try {
			Connection con = DataBaseConnect.getInstance().getConnection();
			PreparedStatement ppst = con.prepareStatement(que.deleteEmployee());
			
			ppst.setInt(1, id);
			
			int rowhampered = ppst.executeUpdate();
			if(rowhampered > 0) {
				msg = "Employee Delete Successfully";
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return msg;
	}

	@Override
	public List<User> getAllEmployee() {
		List<User> allEmp = new ArrayList<>();
		try {
			Connection con = DataBaseConnect.getInstance().getConnection();
			PreparedStatement ppst = con.prepareStatement(que.getAllEmployee());
			
			ResultSet rset = ppst.executeQuery();
			while(rset.next()) {
				User user = new User();
				user.setUserId(rset.getInt("user_id"));
				user.setName(rset.getString("name"));
				user.setEmail(rset.getString("email"));
				user.setPhoneNumber(rset.getString("phone_number"));
				user.setRole(rset.getString("role"));
				
				allEmp.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allEmp;
	}

}
