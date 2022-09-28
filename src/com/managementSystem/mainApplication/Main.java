package com.managementSystem.mainApplication;

import java.util.Scanner;

import com.managementSystem.usecases.LoginPoliceOfficerCase;

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
	
	
	
	// Calling the method section
	
	public static boolean loginValidation(String username, String password,String officerName,int officerId) {
		LoginPoliceOfficerCase loginPoliceOfficerCase = new LoginPoliceOfficerCase();
		
		return loginPoliceOfficerCase.loginPoliceOfficer(username, password, officerName, officerId);
	}
	

	public static void main(String[] args) {
		System.out.println("Welcome in Crime Infomation Management System");
		takeInputFromUserForLogin();
	}

}
