package com.managementSystem.mainApplication;

import java.util.List;
import java.util.Scanner;

import com.managementSystem.bean.PoliceStationBean;
import com.managementSystem.usecases.ListAllPoliceStationsCase;
import com.managementSystem.usecases.LoginPoliceOfficerCase;
import com.managementSystem.usecases.RegisteringTheCase;

public class Main {
	
	public static Scanner sc = new Scanner(System.in);
	
	// Crime information management System menu
	
	public static void crimeInformationMenu() {
		System.out.print("1.");
	}
	
	
	// Input taking section
	
	public static boolean takeInputFromUserForLogin() {
		
		System.out.println("Please enter username");
		String username = sc.next();
		
		System.out.println("Please enter password");
		String password = sc.next();
		
		System.out.println("Plese enter your officerName");
		String officerName = sc.next();
		
		System.out.println("Please enter your officerId");
		int officerId = sc.nextInt();
		
		return loginValidation(username, password,officerName, officerId);
	}
	
	public static boolean takeInputFromUserForRegisteringTheCase() {
		
		
		
		System.out.println("Please enter crime Id");
		int crimeId = sc.nextInt();
		
		System.out.println("Please enter date when crime happen");
		String date = sc.next();
		
		System.out.println("Please enter crime description");
		sc.nextLine();
		String crimeDescription = sc.nextLine();
		
		System.out.println("Please enter crime victims");
		String crimeVictims = sc.nextLine();
		
		System.out.println("Please enter crime details description");
		String crimeDetailsDescription = sc.nextLine();
		
		System.out.println("Please enter crime main suspect");
		String crimeMainSuspect = sc.nextLine();
		
		System.out.println("Please enter crime under which police station. Enter police station id");
		int crimeUnderWhichPoliceStationId = sc.nextInt();
		
		
		return registeringTheCase(crimeId, date, crimeDescription, crimeVictims,
				crimeDetailsDescription, crimeMainSuspect, crimeUnderWhichPoliceStationId);
		
	}
	
	// Calling the method section
	
	public static boolean loginValidation(String username, String password,String officerName,int officerId) {
		LoginPoliceOfficerCase loginPoliceOfficerCase = new LoginPoliceOfficerCase();
		
		return loginPoliceOfficerCase.loginPoliceOfficer(username, password, officerName, officerId);
	}
	
	public static void ListingAllThePoliceStation() {
		
		ListAllPoliceStationsCase listAllPoliceStationsCase = new ListAllPoliceStationsCase();
		printAllThePoliceStaion(listAllPoliceStationsCase.ListAllPoliceStationsInYourArea());

	}
	
	public static boolean registeringTheCase(int crimeid, String date, String crimeDescription,String crimeVictims,
			String crimeDetailsDescription, String crimeMainSuspect, int crimeUnderWhichPoliceStationId) {
		
		RegisteringTheCase registeringTheCase = new RegisteringTheCase();
		
		return registeringTheCase.registeringTheCase(crimeid, date, crimeDescription, crimeVictims, crimeDetailsDescription, crimeMainSuspect, crimeUnderWhichPoliceStationId);
	}
	
	// Printing the result section
	
	public static void printAllThePoliceStaion(List<PoliceStationBean> listPoliceStationBeans) {
		
		if(listPoliceStationBeans == null) {
			System.out.println("No Police station found in your area");
			
		}else {
			
			System.out.println("Below all the police stations near you");
			System.out.println("=====================================");
			for(int i=0; i<=listPoliceStationBeans.size()-1; i++) {
				
				PoliceStationBean policeStationBean = listPoliceStationBeans.get(i);
				System.out.println("Police Station Number is " + policeStationBean.getPoliceStationNo());
				System.out.println("Police area is " + policeStationBean.getPoliceArea());
				System.out.println("Police station detail address " + policeStationBean.getPoliceStationAddress());
				System.out.println("=====================================");
				
			}
		}
		
	}


	public static void main(String[] args) {
		
		System.out.println("Welcome in Crime Infomation Management System");
		takeInputFromUserForLogin();
		ListingAllThePoliceStation();
		takeInputFromUserForRegisteringTheCase();
		
	}

}
