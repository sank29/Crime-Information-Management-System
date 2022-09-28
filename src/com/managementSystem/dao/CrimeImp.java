package com.managementSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.managementSystem.bean.PoliceOfficerBean;
import com.managementSystem.utility.DataBaseUtility;

public class CrimeImp implements CrimeDao {

	@Override
	public PoliceOfficerBean loginPolicOfficer(String username, String password) {
		PoliceOfficerBean policeOfficerBean = null;
		
		try(Connection connection = DataBaseUtility.GetConnection()) {
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from adminInfo where "
					+ "username = ? AND password = ?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
			ResultSet preparedStatementResult = preparedStatement.executeQuery();
			
			if(preparedStatementResult != null){
				
				System.out.println("Login Successful.");
				System.out.println("Your are admin now");
				
			}
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		return policeOfficerBean;
	}

}
