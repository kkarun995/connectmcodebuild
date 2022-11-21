package com.vecv.model.trip;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VehicleModel {

	@JsonProperty(value = "driver_id")
	private Integer driverId;
	@JsonProperty(value = "vehicle_id")
	private Integer vehicleId;
	@JsonProperty(value = "reg_no")
	private String regNo;
	@JsonProperty(value = "start_time")
	private String startTime;
	@JsonProperty(value = "end_time")
	private String endTime;

	public VehicleModel() {
		super();
	}

	public VehicleModel(Integer driverId, Integer vehicleId, String regNo, String startTime, String endTime) {
		super();
		this.driverId = driverId;
		this.vehicleId = vehicleId;
		this.regNo = regNo;
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

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
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

	@Override
	public String toString() {
		return "VehicleModel [driverId=" + driverId + ", vehicleId=" + vehicleId + ", regNo=" + regNo + ", startTime="
				+ startTime + ", endTime=" + endTime + "]";
	}

}
