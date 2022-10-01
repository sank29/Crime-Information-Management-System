package com.managementSystem.usecases;

import com.managementSystem.dao.CrimeImp;

public class UpdateCaseStatus {

	public boolean updatingTheCaseStatus(int crimeId) {
		
			CrimeImp crimeImp = new CrimeImp();
			
			return crimeImp.changeCrimeStatus(crimeId);
	}
}
