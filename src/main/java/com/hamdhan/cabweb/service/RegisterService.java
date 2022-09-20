package com.hamdhan.cabweb.service;

import java.sql.SQLException;
import java.util.List;

import com.hamdhan.cabweb.dao.DriverDao;
import com.hamdhan.cabweb.dao.LoginDao;
import com.hamdhan.cabweb.dao.RegistrationDao;
import com.hamdhan.cabweb.service.RegisterService;
import com.hamdhan.cabweb.model.Login;
import com.hamdhan.cabweb.model.Register;

public class RegisterService {
	
	private RegistrationDao registerDao;
	private LoginDao loginDao;
	public RegisterService(RegistrationDao registerDao ) {
		this.registerDao= registerDao;
	}
	
	public RegisterService(RegistrationDao registerDao, LoginDao loginDao ) {
		this.registerDao= registerDao;
		this.loginDao = loginDao;
	}
	
	public RegisterService(LoginDao loginDao ) {
		this.loginDao = loginDao;
	}
	
	public boolean addUser(Register re) throws ClassNotFoundException, SQLException {
		return registerDao.addUser(re);
	}
	
	public String validateUser(Login log) throws ClassNotFoundException, SQLException {
		return loginDao.validateUser(log);
	}
	
	public List<Register> getAllCustomer() throws ClassNotFoundException, SQLException{
		return registerDao.getAllCustomer();
	}
	
}
