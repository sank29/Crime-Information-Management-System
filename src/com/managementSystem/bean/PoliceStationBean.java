package com.managementSystem.bean;

public class PoliceStationBean {
	
	private int policeStationNo;
	private String policeArea;
	private String policeStationAddress;
	
	public PoliceStationBean(int policeStationNo, String policeArea, String policeStationAddress) {
		this.policeStationNo = policeStationNo;
		this.policeArea = policeArea;
		this.policeStationAddress = policeStationAddress;
	}

	public int getPoliceStationNo() {
		return policeStationNo;
	}

	public void setPoliceStationNo(int policeStationNo) {
		this.policeStationNo = policeStationNo;
	}

	public String getPoliceArea() {
		return policeArea;
	}

	public void setPoliceArea(String policeArea) {
		this.policeArea = policeArea;
	}

	public String getPoliceStationAddress() {
		return policeStationAddress;
	}

	public void setPoliceStationAddress(String policeStationAddress) {
		this.policeStationAddress = policeStationAddress;
	}

}
