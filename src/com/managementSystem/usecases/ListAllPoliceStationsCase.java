package com.managementSystem.usecases;

import java.util.List;

import com.managementSystem.bean.PoliceStationBean;
import com.managementSystem.dao.CrimeImp;

public class ListAllPoliceStationsCase {
	
	public List<PoliceStationBean> ListAllPoliceStationsInYourArea() {
		
		CrimeImp crimeImp = new CrimeImp();
		
		List<PoliceStationBean>listOfPoliceStations = crimeImp.listAllThePoliceStation();
		
		if(listOfPoliceStations.isEmpty()) {
			
			return null;
		}else {
			
			return listOfPoliceStations;
			
		}
	}
}
