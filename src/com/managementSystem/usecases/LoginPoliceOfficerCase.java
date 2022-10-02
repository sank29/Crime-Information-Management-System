package com.managementSystem.usecases;

import java.sql.SQLException;

import com.managementSystem.dao.CrimeImp;
import com.managementSystem.exception.MySqlExceptions;

public class LoginPoliceOfficerCase {
	
	public  boolean loginPoliceOfficer(String username, String password,String officerName, int officerId) throws MySqlExceptions, SQLException {
		CrimeImp crimeImp = new CrimeImp();
		
		if(crimeImp.loginPolicOfficer(username, password,officerName,officerId) == null)
			return false;
		
		else
			return true;

	}
	
}
