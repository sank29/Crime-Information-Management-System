package com.managementSystem.usecases;

import java.util.List;

import com.managementSystem.bean.CriminalBean;
import com.managementSystem.dao.CrimeImp;

public class ListAllCriminal {
	
public List<CriminalBean> listAllTheCriminalRecord() {
		
		CrimeImp crimeImp = new CrimeImp();
		
		List<CriminalBean>criminalAllList = crimeImp.listAllTheCriminalRecord();
		
		if(criminalAllList.isEmpty()) {
			
			return null;
		}else {
			
			return criminalAllList;
			
		}
	}
	
	
}
