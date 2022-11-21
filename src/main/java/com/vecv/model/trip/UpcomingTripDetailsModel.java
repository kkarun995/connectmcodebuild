package com.vecv.model.trip;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class UpcomingTripDetailsModel {

	@JsonProperty(value = "trip_id")
	private Integer tripId;
	@JsonProperty(value = "assigned_vehicle_no")
	private String assignedVehicleNo;
	private String route;
	@JsonProperty(value = "start_time")
	private String startTime;
	@JsonProperty(value = "end_time")
	private String endTime;
	@JsonProperty(value = "start_point")
	private String startPoint;
	@JsonProperty(value = "end_point")
	private String endPoint;
	@JsonProperty(value = "already_checked_in", access = Access.READ_ONLY)
	private boolean alreadyCheckedIn;
	private String tagId;

	public UpcomingTripDetailsModel() {
		super();
	}

	public UpcomingTripDetailsModel(Integer tripId, String assignedVehicleNo, String route, String startTime,
			String endTime, String startPoint, String endPoint, boolean alreadyCheckedIn) {
		super();
		this.tripId = tripId;
		this.assignedVehicleNo = assignedVehicleNo;
		this.route = route;
		this.startTime = startTime;
		this.endTime = endTime;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.alreadyCheckedIn = alreadyCheckedIn;
	}

	public Integer getTripId() {
		return tripId;
	}

	public void setTripId(Integer tripId) {
		this.tripId = tripId;
	}

	public String getAssignedVehicleNo() {
		return assignedVehicleNo;
	}

	public void setAssignedVehicleNo(String assignedVehicleNo) {
		this.assignedVehicleNo = assignedVehicleNo;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
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

	public String getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public boolean isAlreadyCheckedIn() {
		return alreadyCheckedIn;
	}

	public void setAlreadyCheckedIn(boolean alreadyCheckedIn) {
		this.alreadyCheckedIn = alreadyCheckedIn;
	}

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	@Override
	public String toString() {
		return "UpcomingTripDetailsModel [tripId=" + tripId + ", assignedVehicleNo=" + assignedVehicleNo + ", route="
				+ route + ", startTime=" + startTime + ", endTime=" + endTime + ", startPoint=" + startPoint
				+ ", endPoint=" + endPoint + ", alreadyCheckedIn=" + alreadyCheckedIn + "]";
	}

}
