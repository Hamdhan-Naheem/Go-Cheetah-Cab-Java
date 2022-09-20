package com.hamdhan.cabweb.model;

public class Branch {
	private int branchId;
	private String branch_name;
	private int sales =0;
	
	
	public Branch() {
		
	}
	
	
	
	public Branch(int branchId, String branch_name, int sales) {
		super();
		this.branchId = branchId;
		this.branch_name = branch_name;
		this.sales = sales;
	}



	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	
	
}
