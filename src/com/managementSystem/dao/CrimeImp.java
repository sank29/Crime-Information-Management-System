package com.managementSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.managementSystem.bean.CrimeInformationBean;
import com.managementSystem.bean.CriminalBean;
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
				System.out.println("Your are admin now " + officerName);
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
	
	@Override
	public Boolean registeringTheCase(int crimeId, String date, String crimeDescription, String crimeVictims,
			String crimeDetailsDescription, String crimeMainSuspect, int crimeUnderWhichPoliceStationId) {
		
		try(Connection connection = DataBaseUtility.GetConnection()) {
			
			PreparedStatement preparedStatement = connection.prepareStatement("insert into crimeinformation(crimeId,crimeDate,crimeDescription,crimeVictims,crimeDetailsDescription,crimeMainSuspecte,crimeUnderWhichPoliceStationId) values "
					
					+ "(?,"
					+ "?,"
					+ "?,"
					+ "?,"
					+ "?,"
					+ "?,"
					+ "?)"
					);
			
			preparedStatement.setInt(1, crimeId);
			preparedStatement.setString(2, date);
			preparedStatement.setString(3, crimeDescription);
			preparedStatement.setString(4, crimeVictims);
			preparedStatement.setString(5, crimeDetailsDescription);
			preparedStatement.setString(6, crimeMainSuspect);
			preparedStatement.setInt(7, crimeUnderWhichPoliceStationId);
			
			int result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				
				System.out.println("Crime record update sucessfully");
				return true;
			}else {
				System.out.println("Crime record not inserted");
			}
			
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		return false;
	}

	@Override
	public CriminalBean criminalRegistrationCase(int criminalId, String criminalName, String criminalAge, String criminalFaceMarks,
			String criminalFirstArrestLocation, int criminalCrimeId, String criminalGender) {
		
		CriminalBean criminalBean = null;
		
		try(Connection connection = DataBaseUtility.GetConnection()) {
			
			PreparedStatement preparedStatement = connection.prepareStatement("insert into criminallist values(?,?,?,?,?,?,?)");
			
			preparedStatement.setInt(1, criminalId);
			preparedStatement.setString(2, criminalName);
			preparedStatement.setString(3, criminalAge);
			preparedStatement.setString(4, criminalFaceMarks);
			preparedStatement.setString(5,criminalFirstArrestLocation);
			preparedStatement.setInt(6, criminalCrimeId);
			preparedStatement.setString(7, criminalGender);
			
			int x = preparedStatement.executeUpdate();
			
			if(x > 0) {
				criminalBean = new CriminalBean(criminalId, criminalName, criminalAge, criminalFaceMarks, criminalFirstArrestLocation, criminalCrimeId, criminalGender);
				System.out.println("Criminal Recorde registering done!");;
				
			}else {
				System.out.println("Criminal not inseted into database");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return criminalBean;
	}

	@Override
	public List<CriminalBean> listAllTheCriminalRecord() {
		
		List<CriminalBean>listCriminalBeans = new ArrayList<>();
		
		try(Connection connection = DataBaseUtility.GetConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from criminallist");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				int criminalId = resultSet.getInt("criminalId");
				String criminalName = resultSet.getString("criminalName");
				String criminalAge = resultSet.getString("criminalAge");
				String criminalFaceMarks = resultSet.getString("criminalFaceMarks");
				String criminalFirstArrestLocation = resultSet.getString("criminalFirstArrestLocation");
				int criminalCrimeId = resultSet.getInt("criminalCrimeId");
				String criminalGender = resultSet.getString("criminalGender");
				
				
				CriminalBean policeStationBean = new CriminalBean(criminalId, criminalName, criminalAge, criminalFaceMarks, criminalFirstArrestLocation, criminalCrimeId, criminalGender);
				listCriminalBeans.add(policeStationBean);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		return listCriminalBeans;
	}
	
	@Override
	public List<CrimeInformationBean> displayAllCriminalRecordPoliceStaionWise(int policeStationId) {
		
		List<CrimeInformationBean>listCriminalRecord = new ArrayList<>();
		
		try(Connection connection = DataBaseUtility.GetConnection()) {
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from crimeinformation where crimeUnderWhichPoliceStationId = ?");
			preparedStatement.setInt(1, policeStationId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				int crimeId = resultSet.getInt("crimeId");
				String crimeDate = resultSet.getString("crimeDate");
				String crimeDescription = resultSet.getString("crimeDescription");
				String crimeVictims = resultSet.getString("crimeVictims");
				String crimeDetailsDescription = resultSet.getString("crimeDetailsDescription");
				String crimeMainSuspecte = resultSet.getString("crimeMainSuspecte");
				int crimeUnderWhichPoliceStationId = resultSet.getInt("crimeUnderWhichPoliceStationId");
				int crimeStatus = resultSet.getInt("crimeStatus");
				
				CrimeInformationBean crimeInformationBean= new CrimeInformationBean(crimeId, crimeDate, crimeDescription, crimeVictims, crimeDetailsDescription,
						crimeMainSuspecte, crimeUnderWhichPoliceStationId, crimeStatus);
				
				listCriminalRecord.add(crimeInformationBean);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		return listCriminalRecord;
	}

	@Override
	public List<CrimeInformationBean> numberOfSolvedAndUnsolvedCrime(int userChoice) {
		
		int crimeCode = 400;
		
		if(userChoice == 2) {
			crimeCode = 500;
		}
		
		List<CrimeInformationBean> listOfcrimeInformationBean = new ArrayList<>();
		
		try(Connection connection = DataBaseUtility.GetConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement("select * from crimeInformation where crimeStatus = ?");
			preparedStatement.setInt(1, crimeCode);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				int crimeId = resultSet.getInt("crimeId");
				String crimeDate = resultSet.getString("crimeDate");
				String crimeDescription = resultSet.getString("crimeDescription");
				String crimeVictims = resultSet.getString("crimeVictims");
				String crimeDetailsDescription = resultSet.getString("crimeDetailsDescription");
				String crimeMainSuspecte = resultSet.getString("crimeMainSuspecte");
				int crimeUnderWhichPoliceStationId = resultSet.getInt("crimeUnderWhichPoliceStationId");
				int crimeStatus = resultSet.getInt("crimeStatus");
				
				CrimeInformationBean crimeInformationBean = new CrimeInformationBean(crimeId, crimeDate, crimeDescription, crimeVictims, crimeDetailsDescription, crimeMainSuspecte, crimeUnderWhichPoliceStationId,crimeStatus);
				listOfcrimeInformationBean.add(crimeInformationBean);
				
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return listOfcrimeInformationBean;
	}

	@Override
	public List<CrimeInformationBean> numberOfCrimeInformationBasedOnMonth() {
		
		List<String>mothsArray = dateGenerator();
		
        List<CrimeInformationBean> listOfcrimeInformationBean = new ArrayList<>();
		
		try(Connection connection = DataBaseUtility.GetConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement("select * from crimeInformation where crimeDate BETWEEN ? AND ?");
			preparedStatement.setString(1, mothsArray.get(0));
			preparedStatement.setString(2, mothsArray.get(1));
			
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				int crimeId = resultSet.getInt("crimeId");
				String crimeDate = resultSet.getString("crimeDate");
				String crimeDescription = resultSet.getString("crimeDescription");
				String crimeVictims = resultSet.getString("crimeVictims");
				String crimeDetailsDescription = resultSet.getString("crimeDetailsDescription");
				String crimeMainSuspecte = resultSet.getString("crimeMainSuspecte");
				int crimeUnderWhichPoliceStationId = resultSet.getInt("crimeUnderWhichPoliceStationId");
				int crimeStatus = resultSet.getInt("crimeStatus");
				
				CrimeInformationBean crimeInformationBean = new CrimeInformationBean(crimeId, crimeDate, crimeDescription, crimeVictims, crimeDetailsDescription, crimeMainSuspecte, crimeUnderWhichPoliceStationId,crimeStatus);
				listOfcrimeInformationBean.add(crimeInformationBean);
				
			}
			
		}catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		return listOfcrimeInformationBean;
		
	}
	
	@Override
	public boolean changeCrimeStatus(int crimeId) {
		
		try(Connection connection = DataBaseUtility.GetConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from crimeinformation where crimeId = ?");
			preparedStatement.setInt(1, crimeId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int databaseCrimeId = resultSet.getInt("crimeStatus");
			if(databaseCrimeId == 400) {
				
				System.out.println("Case already solved");
				
			}else {
				
				PreparedStatement preparedStatement2 = connection.prepareStatement("update crimeinformation set crimeStatus = 400 where crimeId = ?");
				preparedStatement2.setInt(1, crimeId);
				int result = preparedStatement2.executeUpdate();
				
				if(result > 0) {
					System.out.println("Crime Status Update Successfully. Case has been closed.");
					return true;
				}
			}

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return false;
	}
	
	
	@Override
	public List<CriminalBean> displayAllCrimePoliceStationWise(int policeStationId) {
		
		List<CriminalBean>listCriminalBeans = new ArrayList<>();
		
		try(Connection connection = DataBaseUtility.GetConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from crimeinformation inner join criminallist on crimeinformation.crimeId = criminallist.criminalCrimeId");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int crimeUnderWhichPoliceStationId = resultSet.getInt("crimeUnderWhichPoliceStationId");
				if(crimeUnderWhichPoliceStationId == policeStationId) {
					
					int criminalId = resultSet.getInt("criminalId");
					String criminalName = resultSet.getString("criminalName");
					String criminalAge = resultSet.getString("criminalAge");
					String criminalFaceMarks = resultSet.getString("criminalFaceMarks");
					String criminalFirstArrestLocation = resultSet.getString("criminalFirstArrestLocation");
					int criminalCrimeId = resultSet.getInt("criminalCrimeId");
					String criminalGender = resultSet.getString("criminalGender");
					
					
					CriminalBean policeStationBean = new CriminalBean(criminalId, criminalName, criminalAge, criminalFaceMarks, criminalFirstArrestLocation, criminalCrimeId, criminalGender);
					listCriminalBeans.add(policeStationBean);
				}
				
				
			}
			
			
			
		}catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		return listCriminalBeans;
	}
	

	public static List<String> dateGenerator() {
		
		List<String>arrayListOfDates = new ArrayList<>();
		
		LocalDate date= LocalDate.now();
		int months = date.getMonthValue();
		int year = date.getYear();
		int currentDate = date.getDayOfMonth();
		int pastDate = 1;
		
		String currentDateString = year + "-" + months + "-" + currentDate;
		String pastDateString = year + "-" + months + "-" + pastDate;
		
		arrayListOfDates.add(pastDateString);
		arrayListOfDates.add(currentDateString);
		
		return arrayListOfDates;
		
	}

	

	

	
	
	
}































