package com.hamdhan.cabweb.model;

public class Driver extends Person {
	private int D_id;
	private int branchId;
	private String password;
	
	public Driver() {
		
	}

	public Driver(int D_id,String username, int age, String email, int phoneNo,int branchId, String password) {
		super(username, age, email, phoneNo);
	}

	public Driver(String username, int age, String email, String district, int phoneNo) {
		super(username, age, email, district, phoneNo);
	}

	public Driver(String username) {
		super(username);
	}

	public int getD_id() {
		return D_id;
	}

	public void setD_id(int d_id) {
		D_id = d_id;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
		
}

