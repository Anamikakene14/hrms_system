package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import miniProject.uility.DataBaseConnectivity;

public class DataBaseConnect {
	
	public static DataBaseConnect obj = null;
	private DataBaseConnect() {}
	
	public Connection getConnection() {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms_system","root","anamika@142001");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static DataBaseConnect getInstance() {
		if(obj == null) {
			obj = new DataBaseConnect();
		}
		return obj;
	}
}
