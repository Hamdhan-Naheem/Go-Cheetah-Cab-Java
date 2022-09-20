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


import com.hamdhan.cabweb.dao.LoginDao;
import com.hamdhan.cabweb.dao.RegistrationDao;

import com.hamdhan.cabweb.model.Login;
import com.hamdhan.cabweb.model.Register;

@ExtendWith(MockitoExtension.class)
public class RegisterServiceTest {
	@Mock
	private RegistrationDao registrationDao;
	@Mock
	private LoginDao loginDao;
	@Test
	public void testAddCustomer() throws ClassNotFoundException, SQLException {
		when(registrationDao.addUser(any())).thenReturn(true);
		RegisterService service = new RegisterService(registrationDao);
		boolean actual= service.addUser(new Register());
		assertTrue(actual);
		
	}
	@Test
	public void getAllCustomerTest() throws ClassNotFoundException, SQLException {
		when(registrationDao.getAllCustomer()).thenReturn(new ArrayList<Register>());
		RegisterService service = new RegisterService(registrationDao);
		List<Register> actual= service.getAllCustomer();
		assertEquals(new ArrayList<Register>(),actual);
	}
	
	@Test
	public void loginTest() throws ClassNotFoundException, SQLException {
		when(loginDao.validateUser(any())).thenReturn("");
		RegisterService service = new RegisterService(loginDao);
		String actual= service.validateUser(new Login());
		assertEquals("",actual);
	}
	
}
