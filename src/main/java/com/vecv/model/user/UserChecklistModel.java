package com.vecv.model.user;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class UserChecklistModel {

	@JsonProperty(value = "user_id", access = Access.READ_ONLY)
	private Integer userId;
	@JsonProperty(value = "driver_id", access = Access.READ_ONLY)
	private Integer driverId;
	@JsonProperty(value = "user_name", access = Access.READ_ONLY)
	private String userName;
	@JsonProperty(value = "vehicle_number", access = Access.READ_ONLY)
	private String vehicleNumber;
	@JsonProperty(value = "start_odometer", access = Access.READ_ONLY)
	private Double startOdometer;
	@JsonProperty(value = "end_odometer", access = Access.READ_ONLY)
	private String endOdometer;
	private List<ChecklistModel> checklist;

	public UserChecklistModel() {
		super();
	}

	public UserChecklistModel(Integer userId, Integer driverId, String userName, String vehicleNumber,
			Double startOdometer, String endOdometer, List<ChecklistModel> checklist) {
		super();
		this.userId = userId;
		this.driverId = driverId;
		this.userName = userName;
		this.vehicleNumber = vehicleNumber;
		this.startOdometer = startOdometer;
		this.endOdometer = endOdometer;
		this.checklist = checklist;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public Double getStartOdometer() {
		return startOdometer;
	}

	public void setStartOdometer(Double startOdometer) {
		this.startOdometer = startOdometer;
	}

	public String getEndOdometer() {
		return endOdometer;
	}

	public void setEndOdometer(String endOdometer) {
		this.endOdometer = endOdometer;
	}

	public List<ChecklistModel> getChecklist() {
		return checklist;
	}

	public void setChecklist(List<ChecklistModel> checklist) {
		this.checklist = checklist;
	}

	@Override
	public String toString() {
		return "UserChecklistModel [userId=" + userId + ", driverId=" + driverId + ", userName=" + userName
				+ ", vehicleNumber=" + vehicleNumber + ", startOdometer=" + startOdometer + ", endOdometer="
				+ endOdometer + ", checklist=" + checklist + "]";
	}

}
