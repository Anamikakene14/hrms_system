package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.User;
import utility.DataBaseConnect;
import utility.QueryUtility;

public class UserDaoImpl implements UserDao {
	QueryUtility que = new QueryUtility();

	@Override
	public String signUp(User user) {
		String msg = null;

		try {
			Connection conn = DataBaseConnect.getInstance().getConnection();
			PreparedStatement ppst = conn.prepareStatement(que.signUp());
			
			ppst.setString(1, user.getName());
			ppst.setString(2, user.getEmail());
			ppst.setString(3, user.getPassword());
			ppst.setString(4, user.getPhoneNumber());
			ppst.setString(5, user.getRole());
			
			int x = ppst.executeUpdate();
			if(x > 0) {
				msg = "Data Inserted Successfully";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}
	
	@Override
	public User signIn(String email, String password) {
		User user = null;
		
		try {
			Connection conn = DataBaseConnect.getInstance().getConnection();
			PreparedStatement ppst = conn.prepareStatement(que.signIn());
			
			ppst.setString(1, email);
			ppst.setString(2, password);
            ResultSet rs = ppst.executeQuery();
            
            
            if (rs.next()) {
                user = new User(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("phone_number"),
                        rs.getString("role")
                );
            }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
		
	}

	@Override
	public String updatePassword(User user) {
		String msg = null;
		
		try {
			Connection con = DataBaseConnect.getInstance().getConnection();
			PreparedStatement ppst = con.prepareStatement(que.updatePassword());
			
			ppst.setString(1, user.getPassword());
			ppst.setInt(2, user.getUserId());
			
			int rowhampered = ppst.executeUpdate();
			
			if(rowhampered > 0) {
				msg = "Yehh! Password Updated Successfully";
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}
	
	public String updateEmail(User user) {
		String msg = null;
		
		try {
			Connection con = DataBaseConnect.getInstance().getConnection();
			PreparedStatement ppst = con.prepareStatement(que.updateEmail());
			
			ppst.setString(1, user.getEmail());
			ppst.setInt(2, user.getUserId());
			
			int rowhampered = ppst.executeUpdate();
			
			if(rowhampered > 0) {
				msg = "Yehh! Email Updated Successfully";
			}
			con.close();
		}catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return msg;
		
	}

	@Override
	public String createAdmin(User admin) {
		
		String msg = null;

		try {
			Connection conn = DataBaseConnect.getInstance().getConnection();
			PreparedStatement ppst = conn.prepareStatement(que.insertAdmin());
			
			ppst.setString(1, admin.getName());
			ppst.setString(2, admin.getEmail());
			ppst.setString(3, admin.getPassword());
			ppst.setString(4, admin.getPhoneNumber());
			ppst.setString(5, admin.getRole());
			
			int x = ppst.executeUpdate();
			if(x > 0) {
				msg = "Admin's Data Inserted Successfully";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String deleteAdmin(int id) {
		String msg = null;
		try {
			Connection con = DataBaseConnect.getInstance().getConnection();
			PreparedStatement ppst = con.prepareStatement(que.deleteAdmin());
			
			ppst.setInt(1, id);
			
			int rowhampered = ppst.executeUpdate();
			if(rowhampered > 0) {
				msg = "Admin Delete Successfully";
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return msg;
	}

	@Override
	public User searchById(int id) {
		User user = null;
		try {
			Connection con = DataBaseConnect.getInstance().getConnection();
			PreparedStatement ppst = con.prepareStatement(que.searchById());
			ppst.setInt(1, id);
			
			ResultSet rset = ppst.executeQuery();
			
			if(rset.next()) {
				user = new User();
				
				user.setUserId(rset.getInt("user_id"));
				user.setName(rset.getString("name"));
				user.setEmail(rset.getString("email"));
				user.setPhoneNumber(rset.getString("phone_number"));
				user.setRole(rset.getString("role"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	
	@Override
	public List<User> getAllAdmin() {
		List<User> allAdmin = new ArrayList<>();
		try {
			Connection con = DataBaseConnect.getInstance().getConnection();
			PreparedStatement ppst = con.prepareStatement(que.listAllUser());
			
			ResultSet rset = ppst.executeQuery();
			while(rset.next()) {
				User user = new User();
				user.setUserId(rset.getInt("user_id"));
				user.setName(rset.getString("name"));
				user.setEmail(rset.getString("email"));
				user.setPhoneNumber(rset.getString("phone_number"));
				user.setRole(rset.getString("role"));
				
				allAdmin.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allAdmin;
	}

}
