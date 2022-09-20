package com.hamdhan.cabweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDbConnectorIml implements MySqlDbConnector {

	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/cheetahcab";
		String username = "root";
		String password = "ham123Ham321";
		Connection connection = DriverManager.getConnection(url,username,password);
		return connection;
	}

}
