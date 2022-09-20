package com.hamdhan.cabweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hamdhan.cabweb.model.Driver;


public class DriverDao {
	
	static DbFactory factory = new DbFactory();
	static MySqlDbConnector connector = factory.getDb("mysql");

	public boolean addDriver(Driver dr) throws ClassNotFoundException, SQLException {
		
		Connection connection = connector.getConnection();
		
		String query = "INSERT into driver(username, age, email, phoneNo,branchId,password) values (?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, dr.getUsername());
		ps.setInt(2, dr.getAge());
		ps.setString(3, dr.getEmail());
		ps.setInt(4, dr.getPhoneNo());
		ps.setInt(5, dr.getBranchId());
		ps.setString(6, dr.getPassword());
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
		
		
	}
	
	public List<Driver> getAllDriver() throws ClassNotFoundException, SQLException{
		//Establish the connection
		Connection connection = connector.getConnection();
		//Create the statement
		String query = "SELECT * from driver";
		Statement st = connection.createStatement();
		//Execute query
		ResultSet rs = st.executeQuery(query);
		List<Driver> drivers = new ArrayList();
		while(rs.next()) {
			Driver driver = new Driver(rs.getInt("D_id"),rs.getString("username"),rs.getInt("age"),rs.getString("email"),rs.getInt("phoneNo"), rs.getInt("branchId"),rs.getString("password"));
			drivers.add(driver);
		}
		st.close();
		connection.close();
		return drivers;
	}
	
	public boolean updateDriver(Driver driver) throws ClassNotFoundException, SQLException {
		Connection connection = connector.getConnection();
		
		String query = "UPDATE driver SET username=?,age=?,email=?, phoneNo=?, branchId=?, password=? WHERE D_id=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, driver.getUsername());
		ps.setInt(2, driver.getAge());
		ps.setString(3, driver.getEmail());
		ps.setInt(4, driver.getPhoneNo());
		ps.setInt(5, driver.getBranchId());
		ps.setString(6, driver.getPassword());
		ps.setInt(7, driver.getD_id());
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;
	}
	
	public boolean deleteDriver(int D_id) throws ClassNotFoundException, SQLException {
		Connection connection = connector.getConnection();
		String query = "DELETE from driver WHERE D_id=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, D_id);
		 boolean result = ps.executeUpdate() > 0;
		 ps.close();
		 connection.close();
		 return result;	
	}

}
