package com.managementSystem.dao;

import com.managementSystem.bean.PoliceOfficerBean;

public interface CrimeDao {
	public PoliceOfficerBean loginPolicOfficer(String username, String password);
	
	
}
