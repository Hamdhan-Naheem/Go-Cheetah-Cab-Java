package com.hamdhan.cabweb.service;

import java.sql.SQLException;
import java.util.List;

import com.hamdhan.cabweb.dao.BranchDao;
import com.hamdhan.cabweb.model.Branch;


public class BranchService {
	public List<Branch> viewBranches() throws ClassNotFoundException, SQLException{
		return BranchDao.viewAllBranches();
	}
}
