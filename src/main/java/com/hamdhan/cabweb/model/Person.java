package com.hamdhan.cabweb.model;

public class Person {
	private String username;
	private int age;
	private String email;
	private String district;
	private int phoneNo;
	
	public Person() {
		
	}
	
	public Person(String username) {
		this.username = username;
	}
	
	

	public Person(String username, int age, String email, String district, int phoneNo) {
		super();
		this.username = username;
		this.age = age;
		this.email = email;
		this.district = district;
		this.phoneNo = phoneNo;
	}



	public Person(String username, int age, String email, int phoneNo) {
		super();
		this.username = username;
		this.age = age;
		this.email = email;
		this.phoneNo = phoneNo;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
	
}
