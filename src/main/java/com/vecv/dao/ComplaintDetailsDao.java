package com.vecv.dao;

public class ComplaintDetailsDao {

	private Integer driverId;
	private Integer vehicleId;
	private String phoneNumber;
	private String alternatePhoneNumber;
	private String location;
	private String description;
	private String date;

	public ComplaintDetailsDao() {
		super();
	}

	public ComplaintDetailsDao(Integer driverId, Integer vehicleId, String phoneNumber, String alternatePhoneNumber,
			String location, String description, String date) {
		super();
		this.driverId = driverId;
		this.vehicleId = vehicleId;
		this.phoneNumber = phoneNumber;
		this.alternatePhoneNumber = alternatePhoneNumber;
		this.location = location;
		this.description = description;
		this.date = date;
	}

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAlternatePhoneNumber() {
		return alternatePhoneNumber;
	}

	public void setAlternatePhoneNumber(String alternatePhoneNumber) {
		this.alternatePhoneNumber = alternatePhoneNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ComplaintDetailsDao [driverId=" + driverId + ", vehicleId=" + vehicleId + ", phoneNumber=" + phoneNumber
				+ ", alternatePhoneNumber=" + alternatePhoneNumber + ", location=" + location + ", description="
				+ description + ", date=" + date + "]";
	}

}
