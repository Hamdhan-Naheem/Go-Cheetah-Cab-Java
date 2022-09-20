package com.hamdhan.cabweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hamdhan.cabweb.model.Login;

public class LoginDao {
	static DbFactory factory = new DbFactory();
	static MySqlDbConnector connector = factory.getDb("mysql");
	
	public String validateUser(Login login) throws ClassNotFoundException, SQLException {
		Connection connection = connector.getConnection();
		String query = "select * from register where username=? and password=?";
		PreparedStatement ps = connection.prepareStatement(query);
		System.out.println("=======================");
		
		ps.setString(1, login.getUsername());
		ps.setString(2, login.getPassword());
		
		String message = "";
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			String DBusername = rs.getString("username");
			String DBpassword = rs.getString("password");
			String DBrole = rs.getString("user_role");
			
			if(login.getUsername().equals(DBusername) && login.getPassword().equals(DBpassword) && DBrole.equals("admin")) {
				message = "admin";
				System.out.println("Tharaka");
			}
			
			else if(login.getUsername().equals(DBusername) && login.getPassword().equals(DBpassword) && DBrole.equals("customer")) {
				message = "customer";
				System.out.println("hamdhan");
			}
		}
		
		ps.close();
		connection.close();
		return message;
	}

}
