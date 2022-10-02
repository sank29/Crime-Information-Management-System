package com.managementSystem.bean;

public class CriminalBean {
	
	private int criminalId;
	private String criminalName;
	private String criminalAge;
	private String criminalFaceMarks;
	private String criminalFirstArrestLocation;
	private int criminalCrimeId;
	private String criminalGender;
	
	public CriminalBean(int criminalId, String criminalName, String criminalAge, String criminalFaceMarks,
			String criminalFirstArrestLocation, int criminalCrimeId, String criminalGender) {
		
		this.criminalId = criminalId;
		this.criminalName = criminalName;
		this.criminalAge = criminalAge;
		this.criminalFaceMarks = criminalFaceMarks;
		this.criminalFirstArrestLocation = criminalFirstArrestLocation;
		this.criminalCrimeId = criminalCrimeId;
		this.criminalGender = criminalGender;
		
	}

    public String getCriminalAge() {
		return criminalAge;
	}

	public void setCriminalAge(String criminalAge) {
		this.criminalAge = criminalAge;
	}

	public String getCriminalGender() {
		return criminalGender;
	}

	public void setCriminalGender(String criminalGender) {
		this.criminalGender = criminalGender;
	}

	public int getCriminalId() {
		return criminalId;
	}

	public void setCriminalId(int criminalId) {
		this.criminalId = criminalId;
	}

	public String getCriminalName() {
		return criminalName;
	}

	public void setCriminalName(String criminalName) {
		this.criminalName = criminalName;
	}

	public String getDate() {
		return criminalAge;
	}

	public void setDate(String criminalAge) {
		this.criminalAge = criminalAge;
	}

	public String getCriminalFaceMarks() {
		return criminalFaceMarks;
	}

	public void setCriminalFaceMarks(String criminalFaceMarks) {
		this.criminalFaceMarks = criminalFaceMarks;
	}

	public String getCriminalFirstArrestLocation() {
		return criminalFirstArrestLocation;
	}

	public void setCriminalFirstArrestLocation(String criminalFirstArrestLocation) {
		this.criminalFirstArrestLocation = criminalFirstArrestLocation;
	}

	public int getCriminalCrimeId() {
		return criminalCrimeId;
	}

	public void setCriminalCrimeId(int criminalCrimeId) {
		this.criminalCrimeId = criminalCrimeId;
	}
	
	
	
	
}
