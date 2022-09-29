package com.managementSystem.bean;

public class PoliceOfficerBean {
	private String officerName;
	private int offficerId;
	
	public PoliceOfficerBean(String officerName, int offficerId) {
		this.officerName = officerName;
		this.offficerId = offficerId;
	}

	public String getOfficerName() {
		return officerName;
	}

	public void setOfficerName(String officerName) {
		this.officerName = officerName;
	}

	public int getOffficerId() {
		return offficerId;
	}

	public void setOffficerId(int offficerId) {
		this.offficerId = offficerId;
	}
	
	
}
