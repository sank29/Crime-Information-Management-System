package com.managementSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.managementSystem.bean.PoliceOfficerBean;
import com.managementSystem.bean.PoliceStationBean;
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

	@Override
	public List<PoliceStationBean> listAllThePoliceStation() {
		
		List<PoliceStationBean> policeStationList = new ArrayList<>();
		
		try(Connection connection = DataBaseUtility.GetConnection()){
		
			PreparedStatement preparedStatement = connection.prepareStatement("select * from policestation");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				int policeStationNumber = resultSet.getInt("policeStationNo");
				String policeStationArea = resultSet.getString("policeStationArea");
				String policeStationAddress = resultSet.getString("policeStationAddress");
				
				
				PoliceStationBean policeStationBean = new PoliceStationBean(policeStationNumber, policeStationArea, policeStationAddress);
				policeStationList.add(policeStationBean);
			}
			
			
		}catch(Exception exception){
			System.out.println(exception.getMessage());
		}
		
		return policeStationList;
		
	}

}































