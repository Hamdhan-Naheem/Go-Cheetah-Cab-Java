package com.hamdhan.cabweb.service;

import java.sql.SQLException;
import java.util.List;

import com.hamdhan.cabweb.dao.VehicleDao;
import com.hamdhan.cabweb.model.Vehicle;



public class VehicleService {
	private VehicleDao vehicleDao;
	public VehicleService(VehicleDao vehicleDao) {
		this.vehicleDao= vehicleDao;
	}
	
	public boolean addVehicle(Vehicle vehicle) throws ClassNotFoundException, SQLException {
		return vehicleDao.addVehicle(vehicle);
	}
	
	public List<Vehicle> getAllVehicle() throws ClassNotFoundException, SQLException {
		return vehicleDao.getAllVehicle();
	}
	
	public boolean updateVehicle(Vehicle vehicle) throws ClassNotFoundException, SQLException {
		return vehicleDao.updateVehicle(vehicle);
	}
	
	public boolean deleteVehicle(int V_id ) throws ClassNotFoundException, SQLException {
		return vehicleDao.deleteVehicle(V_id);
	}
}
