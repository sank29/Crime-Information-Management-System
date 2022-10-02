package com.managementSystem.mainApplication;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.managementSystem.bean.CrimeInformationBean;
import com.managementSystem.bean.CriminalBean;
import com.managementSystem.bean.PoliceStationBean;
import com.managementSystem.exception.MySqlExceptions;
import com.managementSystem.usecases.CriminalRegisteringCase;
import com.managementSystem.usecases.DisplayAllCriminalRecordPoliceStaionWiseCase;
import com.managementSystem.usecases.DisplayAllCriminalsPoliceStationWise;
import com.managementSystem.usecases.ListAllCrimeInformation;
import com.managementSystem.usecases.ListAllCriminal;
import com.managementSystem.usecases.ListAllCurrentMothsCrimeInformation;
import com.managementSystem.usecases.ListAllPoliceStationsCase;
import com.managementSystem.usecases.LoginPoliceOfficerCase;
import com.managementSystem.usecases.RegisteringTheCase;
import com.managementSystem.usecases.UpdateCaseStatus;


public class Main {
	
	public static Scanner sc = new Scanner(System.in);
	
	
	
	
	// Input taking section
	
	public static boolean takeInputFromUserForLogin() throws MySqlExceptions, SQLException {
		
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
	
	public static CriminalBean takeInputFromUserForRegisteringCriminal() {
		
		System.out.println("Please enter criminal id");
		int criminalId = sc.nextInt();
		
		System.out.println("Please enter criminal name");
		sc.nextLine();
		String criminalName = sc.nextLine();
		
		System.out.println("Please enter criminal age (YYYY-MM-DD) format");
		String criminalAge = sc.next();
		
		System.out.println("Please enter criminal face marks");
		sc.nextLine();
		String faceMark = sc.nextLine();
		
		System.out.println("Please enter criminal first Arrest Location");
		String firstArrestLocation = sc.nextLine();
		
		System.out.println("Please enter criminal crime id");
		int criminalCrimeId = sc.nextInt();
		
		System.out.println("Please enter criminal Gender");
		String criminalGender = sc.next();
		
		return criminalRegistrationCase(criminalId, criminalName, criminalAge, faceMark, firstArrestLocation, criminalCrimeId, criminalGender);
		
	}
	

	
	public static List<CrimeInformationBean> takeInputFromUserFornumberOfSolvedAndUnsolvedCrime(){
		
		System.out.println("1. For solved crime");
		System.out.println("2. For unsolved crime");
		
		int userChoice = sc.nextInt();
		
		List<CrimeInformationBean> listInformationBeans =  listAllSolvedAndUnsolvedCrime(userChoice);
		if(listInformationBeans == null) {
			System.out.println("No result found");
		}else {
			printAllTheSolvedAndUnsolvedCrimeInformation(listInformationBeans, userChoice);			
		}
		
		return listInformationBeans;
	}
	
	public static boolean takeInputFromUserForUpdatingTheCrimeStatus() {
		
		System.out.println("Please enter which case you want make it close");
		
		int crimeId = sc.nextInt();
		
		
		return updateTheCrimeStatus(crimeId);
	}
	
	public static List<CrimeInformationBean> takeInputFromUserForDisplayingTheCrimeInformationPolicesationWise(){
		
		System.out.println("Please enter police staion area crime list you want. Please enter poliice station id");
		int userChoice = sc.nextInt();
		
		return DisplayingTheCrimeInformationPolicesationWise(userChoice);
		
	}
	
	public static List<CriminalBean> takeInputFromUserForDisplayingTheCriminalPoliceStationWise(){
		System.out.println("Please enter police station id to print all the criminal register there.");
		int userChoice = sc.nextInt();
		
		return displayingTheAllCriminalPoliceStationWise(userChoice);
	}
	
	// Calling the method section
	
	public static boolean loginValidation(String username, String password,String officerName,int officerId) throws MySqlExceptions, SQLException {
		
		LoginPoliceOfficerCase loginPoliceOfficerCase = new LoginPoliceOfficerCase();
		return loginPoliceOfficerCase.loginPoliceOfficer(username, password, officerName, officerId);
	}
	
	public static void listingAllThePoliceStation() {
		
		ListAllPoliceStationsCase listAllPoliceStationsCase = new ListAllPoliceStationsCase();
		printAllThePoliceStaion(listAllPoliceStationsCase.ListAllPoliceStationsInYourArea());
		
	}
	
	public static boolean registeringTheCase(int crimeid, String date, String crimeDescription,String crimeVictims,
			String crimeDetailsDescription, String crimeMainSuspect, int crimeUnderWhichPoliceStationId) {
		
		RegisteringTheCase registeringTheCase = new RegisteringTheCase();
		
		return registeringTheCase.registeringTheCase(crimeid, date,
				crimeDescription, crimeVictims, crimeDetailsDescription, crimeMainSuspect, crimeUnderWhichPoliceStationId);
	}
	
	public static CriminalBean criminalRegistrationCase(int criminalId, String criminalName, String criminalAge, String criminalFaceMarks,
			String criminalFirstArrestLocation, int criminalCrimeId, String criminalGender) {
		
		CriminalRegisteringCase criminalRegisteringCase = new CriminalRegisteringCase();
		
		CriminalBean criminalBean = criminalRegisteringCase.criminalRegistrationCase(criminalId, criminalName,
				criminalAge, criminalFaceMarks, criminalFirstArrestLocation, criminalCrimeId, criminalGender);
		
		return criminalBean;
		
	}
	
	public static void listAllCriminals() {
		ListAllCriminal listAllCriminal = new ListAllCriminal();
		printAllTheCriminals(listAllCriminal.listAllTheCriminalRecord());
		
	}
	
	public static List<CrimeInformationBean> listAllSolvedAndUnsolvedCrime(int userChoice){
		
		ListAllCrimeInformation listAllCrimeInformation = new ListAllCrimeInformation();
		List<CrimeInformationBean>listOfCrimeInformation = listAllCrimeInformation.listAllCrimeInformation(userChoice);
		return listOfCrimeInformation;
		
	}
	
	 public static boolean updateTheCrimeStatus(int crimeId) {
		 
	    	UpdateCaseStatus updateCaseStatus = new UpdateCaseStatus();
	    	
	    	return updateCaseStatus.updatingTheCaseStatus(crimeId);
	 }
	 
	 public static List<CrimeInformationBean> DisplayingTheCrimeInformationPolicesationWise(int policeStationId){
		 
		 DisplayAllCriminalRecordPoliceStaionWiseCase displayAllCriminalRecordPoliceStaionWiseCase = new DisplayAllCriminalRecordPoliceStaionWiseCase();
			return displayAllCriminalRecordPoliceStaionWiseCase.displayAllCriminalRecordPoliceStationWise(policeStationId);
	 }
	 
	 public static List<CriminalBean> displayingTheAllCriminalPoliceStationWise(int policeStationId){
		 
		 DisplayAllCriminalsPoliceStationWise displayAllCriminalsPoliceStationWise = new DisplayAllCriminalsPoliceStationWise();
	
		 
		 return displayAllCriminalsPoliceStationWise.displayAllCriminalsPoliceStationWise(policeStationId);
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
	
	public static void printAllTheCriminals(List<CriminalBean> listAllCriminal) {
			
		if(listAllCriminal == null) {
				System.out.println("No Police station found in your area");
			
		}else {
			
			System.out.println("Below all the police stations near you");
			System.out.println("=====================================");
			for(int i=0; i<=listAllCriminal.size()-1; i++) {
				
				CriminalBean criminalBean = listAllCriminal.get(i);
				
				System.out.println("Criminal id is " + criminalBean.getCriminalId());
				System.out.println("Criminal name " + criminalBean.getCriminalName());
				System.out.println("Criminal age is " + criminalBean.getCriminalAge());
				System.out.println("Criminal face marks is " + criminalBean.getCriminalFaceMarks());
				System.out.println("Criminal first arrrest location " + criminalBean.getCriminalFirstArrestLocation());
				System.out.println("Criminal crime id " + criminalBean.getCriminalId());
				System.out.println("Criminal gender " + criminalBean.getCriminalGender());
				
				System.out.println("=====================================");
				
			}
		}
		
	}
	
	public static void printAllTheSolvedAndUnsolvedCrimeInformation(List<CrimeInformationBean> crimeInformationBeans, int userChoice) {
		
		if(userChoice == 1)
			System.out.println("Solved cases counted are "  + crimeInformationBeans.size());
		
		if(userChoice == 2)
			System.out.println("Unsolved cases counted are " + crimeInformationBeans.size());
		
		System.out.println("=====================================");
		for(int i=0; i<=crimeInformationBeans.size()-1; i++) {
			CrimeInformationBean crimeInformationBean = crimeInformationBeans.get(i);
			System.out.println("Crime id is " + crimeInformationBean.getCrimeId());
			System.out.println("Crime Date is " + crimeInformationBean.getDate());
			System.out.println("Crime Description is " + crimeInformationBean.getCrimeDescription());
			System.out.println("Crime victimes is  " + crimeInformationBean.getCrimeVictims());
			System.out.println("Crime detatils description " + crimeInformationBean.getCrimeDescription());
			System.out.println("Crime main suspect " + crimeInformationBean.getCrimeMainSuspect());
			System.out.println("Crime under which police station id " + crimeInformationBean.getCrimeUnderWhichPoliceStationId());
			System.out.println("Crime status " + crimeInformationBean.getCrimeStatus());
			System.out.println("=====================================");
		}
		
	}
	
	public static void printAllTheSolvedAndUnsolvedCrimeInformationCurrentMonth() {
		    
		    ListAllCurrentMothsCrimeInformation listAllCurrentMothsCrimeInformation = new ListAllCurrentMothsCrimeInformation();
		
			List<CrimeInformationBean> listInformationBeans = listAllCurrentMothsCrimeInformation.listAllCrimeInformation();
			
			if(listInformationBeans == null) {
				System.out.println("No result found");
			}else {
					System.out.println("No of current cases are "  + listInformationBeans.size());
					
				System.out.println("=====================================");
				for(int i=0; i<=listInformationBeans.size()-1; i++) {
					CrimeInformationBean crimeInformationBean = listInformationBeans.get(i);
					
					System.out.println("Crime id is " + crimeInformationBean.getCrimeId());
					System.out.println("Crime Date is " + crimeInformationBean.getDate());
					System.out.println("Crime Description is " + crimeInformationBean.getCrimeDescription());
					System.out.println("Crime victimes is  " + crimeInformationBean.getCrimeVictims());
					System.out.println("Crime detatils description " + crimeInformationBean.getCrimeDescription());
					System.out.println("Crime main suspect " + crimeInformationBean.getCrimeMainSuspect());
					System.out.println("Crime under which police station id " + crimeInformationBean.getCrimeUnderWhichPoliceStationId());
					System.out.println("Crime status " + crimeInformationBean.getCrimeStatus());
					System.out.println("=====================================");
				}
			}
			
		
		
	}

    public static void printingTheCaseUpdatingStatus() {
    	
    	if(takeInputFromUserForUpdatingTheCrimeStatus()) {
    		System.out.println("Status code got update successfully");
    	}else {
    		System.out.println("Status code not updated");
    	}
    }
    
    public static void printingTheCrimeInformationPoliceStationWise() {
    	List<CrimeInformationBean> crimeInformationBeans = takeInputFromUserForDisplayingTheCrimeInformationPolicesationWise();
    	
    	if(crimeInformationBeans == null) {
			System.out.println("No result found");
		}else {
				System.out.println("No of current cases are "  + crimeInformationBeans.size());
				
			System.out.println("=====================================");
			for(int i=0; i<=crimeInformationBeans.size()-1; i++) {
				
				CrimeInformationBean crimeInformationBean = crimeInformationBeans.get(i);
				
				System.out.println("Crime id is " + crimeInformationBean.getCrimeId());
				System.out.println("Crime Date is " + crimeInformationBean.getDate());
				System.out.println("Crime Description is " + crimeInformationBean.getCrimeDescription());
				System.out.println("Crime victimes is  " + crimeInformationBean.getCrimeVictims());
				System.out.println("Crime detatils description " + crimeInformationBean.getCrimeDescription());
				System.out.println("Crime main suspect " + crimeInformationBean.getCrimeMainSuspect());
				System.out.println("Crime under which police station id " + crimeInformationBean.getCrimeUnderWhichPoliceStationId());
				System.out.println("Crime status " + crimeInformationBean.getCrimeStatus());
				System.out.println("=====================================");
			}
		}
    	
    }
    
    public static void printingTheCriminalPoliceStationWise() {
    
    List<CriminalBean> listAllCriminal = takeInputFromUserForDisplayingTheCriminalPoliceStationWise();
    	
	if(listAllCriminal == null) {
		System.out.println("No criminal found");
		
	}else {
		
		System.out.println("Below all the criminal found " + listAllCriminal.size());
		System.out.println("=====================================");
		
		for(int i=0; i<=listAllCriminal.size()-1; i++) {
			
			CriminalBean criminalBean = listAllCriminal.get(i);
			
			System.out.println("Criminal id is " + criminalBean.getCriminalId());
			System.out.println("Criminal name " + criminalBean.getCriminalName());
			System.out.println("Criminal age is " + criminalBean.getCriminalAge());
			System.out.println("Criminal face marks is " + criminalBean.getCriminalFaceMarks());
			System.out.println("Criminal first arrrest location " + criminalBean.getCriminalFirstArrestLocation());
			System.out.println("Criminal crime id " + criminalBean.getCriminalId());
			System.out.println("Criminal gender " + criminalBean.getCriminalGender());
			
			System.out.println("=====================================");
			
		}
	}
    }
    
 // Crime information management System menu
	
 	public static int crimeInformationMenuMainMenu() {
 		System.out.println("=====================================");
 		System.out.println("1. For Main Menu Option");
 		System.out.println("2. List All The Police Station In Our Area");
 		System.out.println("3. For Registering The Case");
 		System.out.println("4. For Registering The Criminal");
 		System.out.println("5. List All The Criminals");
 		System.out.println("6. See Number OF Solved And Unsolved Case");
 		System.out.println("7. See Number of Solved And Unsolved Case Current Month");
 		System.out.println("8. Updating The Crime Status");
 		System.out.println("9. Displaying The Crime PoliceStation Wise");
 		System.out.println("10. Printing the Criminals PoliceStation Wise");
 		System.out.println("11. For Quiting The Application");
 		System.out.println("=====================================");
 		int userChoise = sc.nextInt();
 		return userChoise;
 		
 	}
    
    // switch case section 
    
    public static void swichCaseSection()  {
    	
    	System.out.println("Welcome in Crime Infomation Management System");
    	System.out.println("Login required for the access the database");
    	
    	boolean endingTheLoop = false;
    	
    	while(!endingTheLoop) {
    		
    		try {
				if(takeInputFromUserForLogin()) {
					
							
					boolean quit = false;
					
					while(!quit) {
						int userChoice = crimeInformationMenuMainMenu();
						
						switch (userChoice) {
						
						case 1: {
							
							 userChoice = crimeInformationMenuMainMenu();
							 
						}case 2:{
							
							listingAllThePoliceStation();
							break;
							
						}case 3:{
							
							takeInputFromUserForRegisteringTheCase();
							break;
						
						}case 4:{
							
							takeInputFromUserForRegisteringCriminal();
							break;
							
						}case 5:{
							
							listAllCriminals();
							break;
							
						}case 6:{
							
							takeInputFromUserFornumberOfSolvedAndUnsolvedCrime();
							break;
							
						}case 7:{
							
							printAllTheSolvedAndUnsolvedCrimeInformationCurrentMonth();
							break;
							
						}case 8:{
							
							takeInputFromUserForUpdatingTheCrimeStatus();
							break;
							
						}case 9:{
							
							printingTheCrimeInformationPoliceStationWise();
							break;
						}case 10:{
							
							printingTheCriminalPoliceStationWise();
							break;
							
						}case 11:{
							
							System.out.println("You Quit The Appliction. Thank You !");
							quit = true;
							endingTheLoop = true;
							break;
							
						}
						
						default:
							throw new IllegalArgumentException("Unexpected value: " + userChoice);
						}
					}
					
				}else {
					
					System.out.println("Please try again");
					System.out.println("1. Login again");
					System.out.println("2. Quit the application");
					
					int userChoice2 = sc.nextInt();
					
					if(userChoice2 == 2) {
						System.out.println("You Quit The Appliction. Thank You !");
						endingTheLoop = true;
					}
				}
			} catch (MySqlExceptions e) {
				System.out.println(e.getMessage());
			}catch (SQLException e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
    	}
		
    	
    }

   


	public static void main(String[] args) {
		
		swichCaseSection();
		
	}

}
