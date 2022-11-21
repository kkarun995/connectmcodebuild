package com.vecv.dao;

public class CurrentDataDao {

	private String deviceId;
	private String latitude;
	private String longitude;
	private Double odometer;
	private Double soc;
	private String location;

	public CurrentDataDao() {
		super();
	}

	public CurrentDataDao(String deviceId, String latitude, String longitude, Double odometer, Double soc,
			String location) {
		super();
		this.deviceId = deviceId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.odometer = odometer;
		this.soc = soc;
		this.location = location;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
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

	public Double getOdometer() {
		return odometer;
	}

	public void setOdometer(Double odometer) {
		this.odometer = odometer;
	}

	public Double getSoc() {
		return soc;
	}

	public void setSoc(Double soc) {
		this.soc = soc;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "CurrentDataDao [deviceId=" + deviceId + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", odometer=" + odometer + ", soc=" + soc + ", location=" + location + "]";
	}

}
