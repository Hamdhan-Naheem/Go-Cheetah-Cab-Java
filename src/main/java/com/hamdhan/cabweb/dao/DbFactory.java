package com.hamdhan.cabweb.dao;

public class DbFactory {
	
	public MySqlDbConnector getDb(String type) {
		if(type=="mysql") {
			return new MySqlDbConnectorIml();
		}
		else {
			return null;
		}
	}
}
