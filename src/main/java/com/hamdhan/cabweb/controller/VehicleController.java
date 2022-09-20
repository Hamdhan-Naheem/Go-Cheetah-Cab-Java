package com.hamdhan.cabweb.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hamdhan.cabweb.dao.VehicleDao;
import com.hamdhan.cabweb.model.Vehicle;
import com.hamdhan.cabweb.service.VehicleService;

/**
 * Servlet implementation class VehicleController
 */
public class VehicleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final VehicleDao vehicleDao = new VehicleDao();
       
    public VehicleController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("all")) {
			getAllVehicle(request,response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("add")) {
			addVehicle(request, response);
			
		}
		else if(action.equals("edit")) {
			editVehicle(request,response);
		}
		
		else if(action.equals("delete")) {
			
			deleteVehicle(request,response);
		}
	}
	
	private void getAllVehicle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		VehicleService service = new VehicleService(vehicleDao);
		try {
			List<Vehicle> veh = service.getAllVehicle();
			if(veh.isEmpty()) {
				message = "There are no vehicle yet";
			}
			request.setAttribute("VehicleList", veh);
			
		    } 
		catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("adminn.jsp");
		rd.forward(request, response);
	}
	
	private void addVehicle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		VehicleService service = new VehicleService(vehicleDao);
		Vehicle veh = new Vehicle();
		veh.setV_type(request.getParameter("V_type"));
		veh.setV_name(request.getParameter("V_name"));
		try {
			boolean result = service.addVehicle(veh);
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
		
		RequestDispatcher rd = request.getRequestDispatcher("addVehicle.jsp");
		rd.forward(request, response);	
	}
	
	private void deleteVehicle(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	String message = "";
    	int V_id = Integer.parseInt(request.getParameter("V_id"));
    	VehicleService service = new VehicleService(vehicleDao);
    	try {
			service.deleteVehicle(V_id);
			request.setAttribute("status", "success");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("status", "error");
		}
    	response.sendRedirect("/GoCheeta-cab/vehicle_add?action=all");
    	
     }
	
	private void editVehicle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		VehicleService service = new VehicleService(vehicleDao);
		Vehicle veh = new Vehicle();
		veh.setV_id(Integer.parseInt(request.getParameter("V_id")));
		veh.setV_type(request.getParameter("V_type"));
		veh.setV_name(request.getParameter("V_name"));
		 
		try {
			boolean result = service.updateVehicle(veh);
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
		response.sendRedirect("/GoCheeta-cab/vehicle_add?action=all");
	}

}
