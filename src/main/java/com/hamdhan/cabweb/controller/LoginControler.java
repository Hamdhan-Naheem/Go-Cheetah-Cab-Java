package com.hamdhan.cabweb.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.hamdhan.cabweb.dao.LoginDao;
import com.hamdhan.cabweb.model.Login;
import com.hamdhan.cabweb.service.RegisterService;

/**
 * Servlet implementation class LoginControler
 */
public class LoginControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final LoginDao loginDao = new LoginDao();
       
    public LoginControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("usename");
		String passw = request.getParameter("psw");
		
		Login login = new Login();
		login.setUsername(uname);
		login.setPassword(passw);
		
		
		RegisterService service = new RegisterService(loginDao);
		
		try {
			String authenticate = service.validateUser(login);
			if(authenticate.equals("customer")) {
				System.out.println("Customer's View");
				 
	            HttpSession session = request.getSession(); 
	            session.setAttribute("name", login); 
	            request.setAttribute("validate", uname);
	            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
	    		rd.forward(request, response);
	         	}
			  else if(authenticate.equals("admin"))
		        {
		            System.out.println("Admin's home");
		            HttpSession session = request.getSession();
		            session.setAttribute("admin", login);
		            request.setAttribute("validate", uname);
		            RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
		    		rd.forward(request, response);
		        }
		        else
		        {
		        	request.setAttribute("status", "failed");
		            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		    		rd.forward(request, response);
		        }
		} catch (ClassNotFoundException | SQLException e) {
			request.setAttribute("status", "error");
		}
	}

}
