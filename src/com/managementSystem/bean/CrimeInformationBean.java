package com.managementSystem.bean;

public class CrimeInformationBean {
	
	private int crimeId;
	private String date;
	private String crimeDescription;
	private String crimeVictims;
	private String crimeDetailsDescription;
	private String crimeMainSuspect;
	private int crimeUnderWhichPoliceStationId;
	
	public CrimeInformationBean(int crimeId, String date, String crimeDescription, String crimeVictims,
			String crimeDetailsDescription, String crimeMainSuspect, int crimeUnderWhichPoliceStationId) {
		
		this.crimeId = crimeId;
		this.date = date;
		this.crimeDescription = crimeDescription;
		this.crimeVictims = crimeVictims;
		this.crimeDetailsDescription = crimeDetailsDescription;
		this.crimeMainSuspect = crimeMainSuspect;
		this.crimeUnderWhichPoliceStationId = crimeUnderWhichPoliceStationId;
		
	}

	public int getCrimeId() {
		return crimeId;
	}

	public void setCrimeId(int crimeId) {
		this.crimeId = crimeId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCrimeDescription() {
		return crimeDescription;
	}

	public void setCrimeDescription(String crimeDescription) {
		this.crimeDescription = crimeDescription;
	}

	public String getCrimeVictims() {
		return crimeVictims;
	}

	public void setCrimeVictims(String crimeVictims) {
		this.crimeVictims = crimeVictims;
	}

	public String getCrimeDetailsDescription() {
		return crimeDetailsDescription;
	}

	public void setCrimeDetailsDescription(String crimeDetailsDescription) {
		this.crimeDetailsDescription = crimeDetailsDescription;
	}

	public String getCrimeMainSuspect() {
		return crimeMainSuspect;
	}

	public void setCrimeMainSuspect(String crimeMainSuspect) {
		this.crimeMainSuspect = crimeMainSuspect;
	}

	public int getCrimeUnderWhichPoliceStationId() {
		return crimeUnderWhichPoliceStationId;
	}

	public void setCrimeUnderWhichPoliceStationId(int crimeUnderWhichPoliceStationId) {
		this.crimeUnderWhichPoliceStationId = crimeUnderWhichPoliceStationId;
	}

}
