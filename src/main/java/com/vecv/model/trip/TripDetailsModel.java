package com.vecv.model.trip;

public class TripDetailsModel {

	private Integer tripId;
	private Integer driverId;
	private Integer vehicleId;
	private String vehicleRegNo;
	private Integer routeId;
	private String routeName;
	private String totalDistance;
	private String startTime;
	private String currentSoc;
	private String liveLocation;
	private String coveredDistance;
	private boolean status;

	public TripDetailsModel() {
		super();
	}

	public TripDetailsModel(Integer tripId, Integer driverId, Integer vehicleId, String vehicleRegNo, Integer routeId,
			String routeName, String totalDistance, String startTime, String currentSoc, String liveLocation,
			String coveredDistance, boolean status) {
		super();
		this.tripId = tripId;
		this.driverId = driverId;
		this.vehicleId = vehicleId;
		this.vehicleRegNo = vehicleRegNo;
		this.routeId = routeId;
		this.routeName = routeName;
		this.totalDistance = totalDistance;
		this.startTime = startTime;
		this.currentSoc = currentSoc;
		this.liveLocation = liveLocation;
		this.coveredDistance = coveredDistance;
		this.status = status;
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

	public String getVehicleRegNo() {
		return vehicleRegNo;
	}

	public void setVehicleRegNo(String vehicleRegNo) {
		this.vehicleRegNo = vehicleRegNo;
	}

	public Integer getRouteId() {
		return routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getTotalDistance() {
		return totalDistance;
	}

	public void setTotalDistance(String totalDistance) {
		this.totalDistance = totalDistance;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getCurrentSoc() {
		return currentSoc;
	}

	public void setCurrentSoc(String currentSoc) {
		this.currentSoc = currentSoc;
	}

	public String getLiveLocation() {
		return liveLocation;
	}

	public void setLiveLocation(String liveLocation) {
		this.liveLocation = liveLocation;
	}

	public String getCoveredDistance() {
		return coveredDistance;
	}

	public void setCoveredDistance(String coveredDistance) {
		this.coveredDistance = coveredDistance;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TripDetailsModel [tripId=" + tripId + ", driverId=" + driverId + ", vehicleId=" + vehicleId
				+ ", vehicleRegNo=" + vehicleRegNo + ", routeId=" + routeId + ", routeName=" + routeName
				+ ", totalDistance=" + totalDistance + ", startTime=" + startTime + ", currentSoc=" + currentSoc
				+ ", liveLocation=" + liveLocation + ", coveredDistance=" + coveredDistance + ", status=" + status
				+ "]";
	}

}
