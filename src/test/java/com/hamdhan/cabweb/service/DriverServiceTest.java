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

import com.hamdhan.cabweb.dao.DriverDao;
import com.hamdhan.cabweb.model.Driver;


@ExtendWith(MockitoExtension.class)
public class DriverServiceTest {
	@Mock
	private DriverDao driverDao;
	@Test
	public void testAddDriver() throws ClassNotFoundException, SQLException {
		when(driverDao.addDriver(any())).thenReturn(true);
		DriverService service = new DriverService(driverDao);
		boolean actual= service.addDriver(new Driver(1,"Hamdhan",25,"hamdhan@gmail.com",12,2,"123"));
		assertTrue(actual);
		
	}
	@Test
	public void updateDriver() throws ClassNotFoundException, SQLException {
		when(driverDao.updateDriver(any())).thenReturn(true);
		DriverService service = new DriverService(driverDao);
		boolean actual= service.updateDriver(new Driver(1,"Hamdhan",25,"hamdhan@gmail.com",12,2,"123"));
		assertTrue(actual);
	}
	
	@Test
	public void deleteDriver() throws ClassNotFoundException, SQLException {
		when(driverDao.deleteDriver(1)).thenReturn(true);
		DriverService service = new DriverService(driverDao);
		boolean actual= service.deleteDriver(1);
		assertTrue(actual);
	}
	@Test
	public void getAllDriver() throws ClassNotFoundException, SQLException {
		when(driverDao.getAllDriver()).thenReturn(new ArrayList<Driver>());
		DriverService service = new DriverService(driverDao);
		List<Driver> actual= service.getAllDriver();
		assertEquals(new ArrayList<Driver>(),actual);
	}

}
