package com.hamdhan.cabweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hamdhan.cabweb.model.Register;

public class RegistrationDao {
	static DbFactory factory = new DbFactory();
	static MySqlDbConnector connector = factory.getDb("mysql");
	
	public boolean addUser(Register re) throws ClassNotFoundException, SQLException {
		Connection connection = connector.getConnection();
		String query = "INSERT INTO register(username,email,phonenum,age,password) values (?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, re.getUsername());
		ps.setString(2, re.getEmail());
		ps.setInt(3, re.getPhoneNo());
		ps.setInt(4, re.getAge());
		ps.setString(5, re.getPassword());
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
	}
	
	public List<Register> getAllCustomer() throws ClassNotFoundException, SQLException{	
		Connection connection = connector.getConnection();
		String query = "select * from register";
		Statement st = connection.createStatement();
		
		//Execute query
		ResultSet rs = st.executeQuery(query);
		List<Register> re = new ArrayList();
		while(rs.next()) {
			Register cust = new Register(rs.getInt("id"),rs.getString("username"),rs.getString("email"),rs.getInt("phonenum"),rs.getInt("age"),rs.getString("password"));
			re.add(cust);	
		}
		st.close();
		return re;
		}
}
