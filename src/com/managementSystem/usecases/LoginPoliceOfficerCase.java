package com.managementSystem.usecases;

import com.managementSystem.dao.CrimeImp;

public class LoginPoliceOfficerCase {
	
	public  boolean loginPoliceOfficer(String username, String password,String officerName, int officerId) {
		CrimeImp crimeImp = new CrimeImp();
		
		if(crimeImp.loginPolicOfficer(username, password,officerName,officerId) == null)
			return false;
		
		else
			return true;

	}
	
}
