package com.hamdhan.cabweb.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hamdhan.cabweb.dao.VehicleDao;
import com.hamdhan.cabweb.model.Driver;
import com.hamdhan.cabweb.model.Vehicle;


@ExtendWith(MockitoExtension.class)
public class VehicleServiceTest {
	@Mock
	private VehicleDao vehicleDao;
	@Test
	public void testAddVehicle() throws ClassNotFoundException, SQLException {
		when(vehicleDao.addVehicle(any())).thenReturn(true);
		VehicleService service = new VehicleService(vehicleDao);
		boolean actual= service.addVehicle(new Vehicle(1,"Car","toyota"));
		assertTrue(actual);
		
	}
	@Test
	public void testUpdateVehicle() throws ClassNotFoundException, SQLException {
		when(vehicleDao.updateVehicle(any())).thenReturn(true);
		VehicleService service = new VehicleService(vehicleDao);
		boolean actual= service.updateVehicle(new Vehicle(1,"Car","toyota"));
		assertTrue(actual);
	}
	
	@Test
	public void testDeleteVehicle() throws ClassNotFoundException, SQLException {
		when(vehicleDao.deleteVehicle(1)).thenReturn(true);
		VehicleService service = new VehicleService(vehicleDao);
		boolean actual= service.deleteVehicle(1);
		assertTrue(actual);
	}
	@Test
	public void testGetAllvehicle() throws ClassNotFoundException, SQLException {
		when(vehicleDao.getAllVehicle()).thenReturn(new ArrayList<Vehicle>());
		VehicleService service = new VehicleService(vehicleDao);
		List<Vehicle> actual= service.getAllVehicle();
		assertEquals(new ArrayList<Driver>(),actual);
	}
}
