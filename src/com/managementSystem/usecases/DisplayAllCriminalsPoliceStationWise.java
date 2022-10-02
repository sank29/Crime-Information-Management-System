package com.managementSystem.usecases;

import java.util.List;

import com.managementSystem.bean.CriminalBean;
import com.managementSystem.dao.CrimeImp;

public class DisplayAllCriminalsPoliceStationWise {

	
	public List<CriminalBean> displayAllCriminalsPoliceStationWise(int policeStationId){
		
		CrimeImp crimeImp = new CrimeImp();
		
		List<CriminalBean> criminalAllList = crimeImp.displayAllCrimePoliceStationWise(policeStationId);
		
		if(criminalAllList.isEmpty()) {
			
			return null;
		}else {
			
			return criminalAllList;
			
		}
	}
	

}
