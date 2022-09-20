package com.hamdhan.cabweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hamdhan.cabweb.model.Vehicle;



public class VehicleDao {
	static DbFactory factory = new DbFactory();
	static MySqlDbConnector connector = factory.getDb("mysql");

	public boolean addVehicle(Vehicle veh) throws ClassNotFoundException, SQLException {
		
		Connection connection = connector.getConnection();
		
		String query = "INSERT into vehicle(V_type, V_name) values (?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, veh.getV_type());
		ps.setString(2, veh.getV_name());
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
		
		
	}
	
	public List<Vehicle> getAllVehicle() throws ClassNotFoundException, SQLException{
		//Establish the connection
		Connection connection = connector.getConnection();
		//Create the statement
		String query = "SELECT * from vehicle";
		Statement st = connection.createStatement();
		//Execute query
		ResultSet rs = st.executeQuery(query);
		List<Vehicle> vehicles = new ArrayList();
		while(rs.next()) {
			Vehicle vehicle = new Vehicle(rs.getInt("V_id"),rs.getString("V_type"),rs.getString("V_name"));
			vehicles.add(vehicle);
		}
		st.close();
		connection.close();
		return vehicles;
	}
	
	public boolean updateVehicle(Vehicle vehicle) throws ClassNotFoundException, SQLException {
		Connection connection = connector.getConnection();
		
		String query = "UPDATE vehicle SET V_type=?,V_name=? WHERE V_id=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, vehicle.getV_type());
		ps.setString(2, vehicle.getV_name());
		ps.setInt(3, vehicle.getV_id());
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;
	}
	
	public boolean deleteVehicle(int V_id) throws ClassNotFoundException, SQLException {
		Connection connection = connector.getConnection();
		String query = "DELETE from vehicle WHERE V_id=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, V_id);
		 boolean result = ps.executeUpdate() > 0;
		 ps.close();
		 connection.close();
		 return result;	
	}
}
