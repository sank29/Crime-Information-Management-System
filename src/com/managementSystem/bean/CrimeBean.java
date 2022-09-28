package com.managementSystem.bean;

import java.sql.Date;
import java.util.List;

public class CrimeBean {
	
	private int crimeId;
	private Date dateOfCrime;
	private String crimeDescription;
	private List<String> victims;
	private String descrimption;
	private List<String> mainSuspected;
	
	public CrimeBean(int crimeId, Date dateOfCrime, String crimeDescription, List<String> victims, String descrimption,
			List<String> mainSuspected) {
		super();
		this.crimeId = crimeId;
		this.dateOfCrime = dateOfCrime;
		this.crimeDescription = crimeDescription;
		this.victims = victims;
		this.descrimption = descrimption;
		this.mainSuspected = mainSuspected;
	}

	public int getCrimeId() {
		return crimeId;
	}

	public void setCrimeId(int crimeId) {
		this.crimeId = crimeId;
	}

	public Date getDateOfCrime() {
		return dateOfCrime;
	}

	public void setDateOfCrime(Date dateOfCrime) {
		this.dateOfCrime = dateOfCrime;
	}

	public String getCrimeDescription() {
		return crimeDescription;
	}

	public void setCrimeDescription(String crimeDescription) {
		this.crimeDescription = crimeDescription;
	}

	public List<String> getVictims() {
		return victims;
	}

	public void setVictims(List<String> victims) {
		this.victims = victims;
	}

	public String getDescrimption() {
		return descrimption;
	}

	public void setDescrimption(String descrimption) {
		this.descrimption = descrimption;
	}

	public List<String> getMainSuspected() {
		return mainSuspected;
	}

	public void setMainSuspected(List<String> mainSuspected) {
		this.mainSuspected = mainSuspected;
	}

}
