package com.vecv.dao;

public class VehicleHomepageDao {

	private Integer driverId;
	private Integer vehicleId;
	private String vehicleRegNo;
	private String startTime;
	private String endTime;

	public VehicleHomepageDao() {
		super();
	}

	public VehicleHomepageDao(Integer driverId, Integer vehicleId, String vehicleRegNo, String startTime,
			String endTime) {
		super();
		this.driverId = driverId;
		this.vehicleId = vehicleId;
		this.vehicleRegNo = vehicleRegNo;
		this.startTime = startTime;
		this.endTime = endTime;
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

	public String getVehicleRegNo() {
		return vehicleRegNo;
	}

	public void setVehicleRegNo(String vehicleRegNo) {
		this.vehicleRegNo = vehicleRegNo;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
