package com.hamdhan.cabweb.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface MySqlDbConnector {
	public Connection getConnection() throws ClassNotFoundException, SQLException;

}
