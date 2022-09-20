package com.hamdhan.cabweb.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hamdhan.cabweb.model.Branch;


public class BranchDao {
	static DbFactory factory = new DbFactory();
	static MySqlDbConnector connector = factory.getDb("mysql");
	
	public static List<Branch> viewAllBranches() throws ClassNotFoundException, SQLException{
		Connection connection = connector.getConnection();
		String query = "Select * from branch";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		List<Branch> branch = new ArrayList();
		while(rs.next()) {
			Branch br = new Branch(rs.getInt("branchId"),rs.getString("branch_name"),rs.getInt("total_sale"));
			branch.add(br);
		}
		st.close();
		return branch;
		
	}
}
