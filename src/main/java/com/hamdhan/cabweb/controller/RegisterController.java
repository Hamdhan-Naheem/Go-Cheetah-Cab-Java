package com.hamdhan.cabweb.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.hamdhan.cabweb.dao.RegistrationDao;
import com.hamdhan.cabweb.model.Register;
import com.hamdhan.cabweb.service.RegisterService;




/**
 * Servlet implementation class RegisterController
 */
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final RegistrationDao registerDao = new RegistrationDao();
       

    public RegisterController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("all")) {
			getAllCus(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uname = request.getParameter("name");
		String eml = request.getParameter("email");
		
		int phnNo = Integer.parseInt(request.getParameter("phoneno"));
		int ag = Integer.parseInt(request.getParameter("age"));
		String pwd = request.getParameter("pass");
		
		RegisterService service = new RegisterService(registerDao);
		Register register = new Register();
		
		register.setUsername(uname);
		register.setEmail(eml);
		register.setPhoneNo(phnNo);
		register.setAge(ag);
		register.setPassword(pwd);
		
		try {
			boolean result = service.addUser(register);
			if(result) {
				request.setAttribute("status", "success");
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("status", "failed");
				RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
				rd.forward(request, response);
			}

		} catch (ClassNotFoundException | SQLException e) {
			
			request.setAttribute("status", "error");
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
		}
		
		
		
	}
	
	private void getAllCus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		RegisterService service = new RegisterService(registerDao);
		try {
			List<Register> cust = service.getAllCustomer();
			if(cust.isEmpty()) {
				message = "There are no sales agents at the moment";
			}
			request.setAttribute("customerAll", cust);
			
		    } 
		catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("adminn.jsp");
		rd.forward(request, response);
	}

}


