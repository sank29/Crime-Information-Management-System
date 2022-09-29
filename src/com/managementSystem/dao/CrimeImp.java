package com.managementSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.managementSystem.bean.PoliceOfficerBean;
import com.managementSystem.exception.MySqlExceptions;
import com.managementSystem.utility.DataBaseUtility;

public class CrimeImp implements CrimeDao {

	@Override
	public PoliceOfficerBean loginPolicOfficer(String username, String password, String officerName, int officerId) {
		
		PoliceOfficerBean policeOfficerBean = null;
		
		try(Connection connection = DataBaseUtility.GetConnection()) {
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from adminInfo where username = ? AND password = ?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
			ResultSet preparedStatementResult = preparedStatement.executeQuery();
			
			if(preparedStatementResult.next()){
				
				System.out.println("Login Successful " + officerName);
				System.out.println("Your are admin now" + officerName);
				policeOfficerBean = new PoliceOfficerBean(officerName, officerId);
				return policeOfficerBean;
				
			}else {
				throw new MySqlExceptions("Username or Password incorrect");
			}
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return policeOfficerBean;
	
		
	}

}
