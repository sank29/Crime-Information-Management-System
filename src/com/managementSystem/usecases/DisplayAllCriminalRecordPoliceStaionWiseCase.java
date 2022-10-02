package com.managementSystem.usecases;

import java.util.List;

import com.managementSystem.bean.CrimeInformationBean;
import com.managementSystem.dao.CrimeImp;

public class DisplayAllCriminalRecordPoliceStaionWiseCase {
	
	
	public List<CrimeInformationBean> displayAllCriminalRecordPoliceStationWise(int policeStationId) {
		
		CrimeImp crimeImp = new CrimeImp();
		
		List<CrimeInformationBean>crimeInformationBean = crimeImp.displayAllCriminalRecordPoliceStaionWise(policeStationId);
		
		if(crimeInformationBean.isEmpty()) {
			
			return null;
		}else {
			
			return crimeInformationBean;
			
		}
		
	}

}
