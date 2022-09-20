package com.hamdhan.cabweb.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hamdhan.cabweb.model.Driver;
import com.hamdhan.cabweb.service.DriverService;
import com.hamdhan.cabweb.dao.DriverDao;



/**
 * Servlet implementation class DriverController
 */
public class DriverController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final DriverDao driverDao = new DriverDao();
	
	
    public DriverController() {
 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("all")) {
			getAllDrive(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("add")) {
			addDriver(request, response);
			
		}
		else if(action.equals("edit")) {
			editDriver(request,response);
		}
		
		else if(action.equals("delete")) {
			
			deleteDriver(request,response);
		}
	}
	
	
	private void getAllDrive(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		DriverService service = new DriverService(driverDao);
		try {
			List<Driver> drv = service.getAllDriver();
			if(drv.isEmpty()) {
				message = "There are no driver registered yet";
			}
			request.setAttribute("driverList", drv);
			
		    } 
		catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("adminn.jsp");
		rd.forward(request, response);
	}
	
	private void addDriver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		DriverService service = new DriverService(driverDao);
		Driver drv = new Driver();
		drv.setUsername(request.getParameter("name"));
		drv.setAge(Integer.parseInt(request.getParameter("age")));
		drv.setEmail(request.getParameter("email"));
		drv.setPhoneNo(Integer.parseInt(request.getParameter("phone")));
		drv.setBranchId(Integer.parseInt(request.getParameter("branchid")));
		drv.setPassword(request.getParameter("password"));
		try {
			boolean result = service.addDriver(drv);
			if(result) {
				request.setAttribute("status", "success");
			}
			else
			{
				request.setAttribute("status", "failed");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("status", "error");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("addDriver.jsp");
		rd.forward(request, response);	
	}
	
	private void deleteDriver(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	String message = "";
    	int D_id = Integer.parseInt(request.getParameter("D_id"));
    	DriverService service = new DriverService(driverDao);
    	try {
			service.deleteDriver(D_id);
			request.setAttribute("status", "success");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("status", "error");
		}
    	response.sendRedirect("/GoCheeta-cab/driver_add?action=all");
    	
     }
	
	private void editDriver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		DriverService service = new DriverService(driverDao);
		Driver drv = new Driver();
		drv.setD_id(Integer.parseInt(request.getParameter("D_id")));
		drv.setUsername(request.getParameter("username"));
		drv.setAge(Integer.parseInt(request.getParameter("age")));
		drv.setEmail(request.getParameter("email"));
		drv.setPhoneNo(Integer.parseInt(request.getParameter("phoneNo")));
		drv.setBranchId(Integer.parseInt(request.getParameter("branchId")));
		drv.setPassword(request.getParameter("password"));
		 
		try {
			boolean result = service.updateDriver(drv);
			if(result) {
				message = "Details updated successfully";
			}
			else {
				message = "Failed to update details";
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);  
		response.sendRedirect("/GoCheeta-cab/driver_add?action=all");
	}

}
