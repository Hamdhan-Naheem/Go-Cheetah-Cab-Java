package com.hamdhan.cabweb.service;

import java.sql.SQLException;
import java.util.List;

import com.hamdhan.cabweb.dao.DriverDao;
import com.hamdhan.cabweb.model.Driver;


public class DriverService {
	
	private DriverDao driverDao;
	public DriverService(DriverDao driverDao) {
		this.driverDao= driverDao;
	}
			
	
	public boolean addDriver(Driver driver) throws ClassNotFoundException, SQLException {
		return driverDao.addDriver(driver);
	}
	
	public List<Driver> getAllDriver() throws ClassNotFoundException, SQLException {
		return driverDao.getAllDriver();
	}
	
	public boolean updateDriver(Driver driver) throws ClassNotFoundException, SQLException {
		return driverDao.updateDriver(driver);
	}
	
	public boolean deleteDriver(int D_id ) throws ClassNotFoundException, SQLException {
		return driverDao.deleteDriver(D_id);
	}
}
