package com.vecv.dao;

public class StoppageDetails {

	private String routeName;
	private Integer stoppageNumber;
	private String stoppageTime;
	private String location;
	private String latitude;
	private String longitude;

	public StoppageDetails() {
		super();
	}

	public StoppageDetails(String routeName, String stoppageTime, String location, String latitude, String longitude) {
		super();
		this.routeName = routeName;
		this.stoppageTime = stoppageTime;
		this.location = location;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public StoppageDetails(String routeName, Integer stoppageNumber, String stoppageTime, String location,
			String latitude, String longitude) {
		super();
		this.routeName = routeName;
		this.stoppageNumber = stoppageNumber;
		this.stoppageTime = stoppageTime;
		this.location = location;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public Integer getStoppageNumber() {
		return stoppageNumber;
	}

	public void setStoppageNumber(Integer stoppageNumber) {
		this.stoppageNumber = stoppageNumber;
	}

	public String getStoppageTime() {
		return stoppageTime;
	}

	public void setStoppageTime(String stoppageTime) {
		this.stoppageTime = stoppageTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "StoppageDetails [routeName=" + routeName + ", stoppageTime=" + stoppageTime + ", location=" + location
				+ ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}
