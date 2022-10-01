package com.managementSystem.usecases;

import java.util.List;

import com.managementSystem.bean.CrimeInformationBean;
import com.managementSystem.dao.CrimeImp;

public class ListAllCrimeInformation {
	
	public List<CrimeInformationBean> listAllCrimeInformation(int userChoice){
		
		CrimeImp crimeImp = new CrimeImp();
		
		List<CrimeInformationBean>crimeInformationBean = crimeImp.numberOfSolvedAndUnsolvedCrime(userChoice);
		
		if(crimeInformationBean.isEmpty()) {
			
			return null;
		}else {
			
			return crimeInformationBean;
			
		}
	}

}
