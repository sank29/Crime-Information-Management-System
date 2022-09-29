package com.managementSystem.dao;

import java.util.List;

import com.managementSystem.bean.PoliceOfficerBean;
import com.managementSystem.bean.PoliceStationBean;

public interface CrimeDao {
	
	public PoliceOfficerBean loginPolicOfficer(String username, String password, String officerName, int officerId);
	public List<PoliceStationBean> listAllThePoliceStation();

	
}
