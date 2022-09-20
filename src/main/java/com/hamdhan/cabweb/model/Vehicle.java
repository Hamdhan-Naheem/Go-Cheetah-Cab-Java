package com.hamdhan.cabweb.model;

public class Vehicle{
	private int V_id;
	private String V_type;
	private String V_name;
	
	
	public Vehicle() {
		
	}
	
	public Vehicle(int v_id, String v_type, String v_name) {
		super();
		V_id = v_id;
		V_type = v_type;
		V_name = v_name;
	}


	public int getV_id() {
		return V_id;
	}


	public void setV_id(int v_id) {
		V_id = v_id;
	}


	public String getV_type() {
		return V_type;
	}


	public void setV_type(String v_type) {
		V_type = v_type;
	}


	public String getV_name() {
		return V_name;
	}


	public void setV_name(String v_name) {
		V_name = v_name;
	}
	
	

}
