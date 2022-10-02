package com.managementSystem.dao;

import java.util.List;

import com.managementSystem.bean.CrimeInformationBean;
import com.managementSystem.bean.CriminalBean;
import com.managementSystem.bean.PoliceOfficerBean;
import com.managementSystem.bean.PoliceStationBean;

public interface CrimeDao {
	
	public PoliceOfficerBean loginPolicOfficer(String username, String password, String officerName, int officerId);
	
	public List<PoliceStationBean> listAllThePoliceStation();
	
	public Boolean registeringTheCase(int crimeid, String date, String crimeDescription, String crimeVictims,
			String crimeDetailsDescription, String crimeMainSuspect, int crimeUnderWhichPoliceStationId);
	
	public CriminalBean criminalRegistrationCase(int criminalId, String criminalName, String criminalAge, String criminalFaceMarks,
			String criminalFirstArrestLocation, int criminalCrimeId, String criminalGender);
	
	public List<CriminalBean> listAllTheCriminalRecord();
	
	public List<CrimeInformationBean> numberOfSolvedAndUnsolvedCrime(int userChoice);
	
	public List<CrimeInformationBean> numberOfCrimeInformationBasedOnMonth();
	
	public boolean changeCrimeStatus(int crimeId);
	
	public List<CrimeInformationBean> displayAllCriminalRecordPoliceStaionWise(int policeStationId);
	
	public List<CriminalBean> displayAllCrimePoliceStationWise(int policeStationId); //Ongoing
	
}
















