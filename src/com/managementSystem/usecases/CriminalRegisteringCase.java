package com.managementSystem.usecases;

import com.managementSystem.bean.CriminalBean;
import com.managementSystem.dao.CrimeImp;

public class CriminalRegisteringCase {
	
	CrimeImp crimeImp = new CrimeImp();
	
	public CriminalBean criminalRegistrationCase(int criminalId, String criminalName, String criminalAge, String criminalFaceMarks,
			String criminalFirstArrestLocation, int criminalCrimeId, String criminalGender) {
		
		
		CriminalBean criminalBean = crimeImp.criminalRegistrationCase(criminalId, criminalName, criminalAge, criminalFaceMarks, criminalFirstArrestLocation, criminalCrimeId, criminalGender);
		
		if(criminalBean == null) {
			return null;
		}else {
			return criminalBean;
		}
		
	}

}
