package com.managementSystem.usecases;

import com.managementSystem.dao.CrimeImp;

public class RegisteringTheCase {
	
	public boolean registeringTheCase(int crimeid, String date, String crimeDescription,
			String crimeVictims,String crimeDetailsDescription, String crimeMainSuspect, int crimeUnderWhichPoliceStationId) {
		
		CrimeImp crimeImp = new CrimeImp();
		
		return crimeImp.registeringTheCase(crimeid, date, crimeDescription, crimeVictims, crimeDetailsDescription, crimeMainSuspect, crimeUnderWhichPoliceStationId);
		
	}

}




