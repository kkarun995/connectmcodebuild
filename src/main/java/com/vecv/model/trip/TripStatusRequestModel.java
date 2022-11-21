package com.vecv.model.trip;

public class TripStatusRequestModel {

	private Integer tripId;
	private Integer driverId;
	private Integer vehicleId;
	private String tripStatus;

	public TripStatusRequestModel() {
		super();
	}

	public TripStatusRequestModel(Integer tripId, Integer driverId, String tripStatus) {
		super();
		this.tripId = tripId;
		this.driverId = driverId;
		this.tripStatus = tripStatus;
	}

	public Integer getTripId() {
		return tripId;
	}

	public void setTripId(Integer tripId) {
		this.tripId = tripId;
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

	public String getTripStatus() {
		return tripStatus;
	}

	public void setTripStatus(String tripStatus) {
		this.tripStatus = tripStatus;
	}

	@Override
	public String toString() {
		return "TripStatusRequestModel [tripId=" + tripId + ", driverId=" + driverId + ", tripStatus=" + tripStatus
				+ "]";
	}

}
