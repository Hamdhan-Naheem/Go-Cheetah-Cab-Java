package com.hamdhan.cabweb.model;

public class Register extends Person {
	int id;
	String password;
	private String user_role;
	
	public Register() {
		
	};
	
	public Register(String username,String password,int id, String user_role) {
		super(username);
	}
	
	
	public Register(int id,String username,String email, int phoneNo,int age,String password){
		super(username,age,email, phoneNo);
		this.id = id;
		this.password = password;
		
	}
	
	public Register(String username, int age, String email, int phoneNo,int id, String password){
		super(username,age,email, phoneNo);
		this.id = id;
		this.password = password;
		
	}
	
	

	public String getUser_role() {
		return user_role;
	}
	

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
