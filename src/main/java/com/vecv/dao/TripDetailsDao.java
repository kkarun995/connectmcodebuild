package com.vecv.dao;

public class TripDetailsDao {

	private Integer tripId;
	private Integer driverId;
	private String driverName;
	private Integer vehicleId;
	private String vehicleRegNo;
	private Integer routeId;
	private String routeName;
	private Double totalDistance;
	private String startTime;
	private String endTime;
	private Double currentSoc;
	private String liveLocation;
	private Double coveredDistance;
	private String status;
	private String deviceId;
	private int numOfStops;

	public TripDetailsDao() {
		super();
	}

	public TripDetailsDao(Integer tripId, Integer driverId, Integer vehicleId, String vehicleRegNo, Integer routeId,
			String routeName, Double totalDistance, String startTime, Double currentSoc, String liveLocation,
			Double coveredDistance, String status, String deviceId) {
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
		this.deviceId = deviceId;
	}

	public TripDetailsDao(Integer tripId, Integer driverId, String driverName, Integer vehicleId, String vehicleRegNo,
			Integer routeId, String routeName, Double totalDistance, String startTime, Double currentSoc,
			String liveLocation, Double coveredDistance, String status, String deviceId, int numOfStops) {
		super();
		this.tripId = tripId;
		this.driverId = driverId;
		this.driverName = driverName;
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
		this.deviceId = deviceId;
		this.numOfStops = numOfStops;
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

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
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

	public Double getTotalDistance() {
		return totalDistance;
	}

	public void setTotalDistance(Double totalDistance) {
		this.totalDistance = totalDistance;
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

	public Double getCurrentSoc() {
		return currentSoc;
	}

	public void setCurrentSoc(Double currentSoc) {
		this.currentSoc = currentSoc;
	}

	public String getLiveLocation() {
		return liveLocation;
	}

	public void setLiveLocation(String liveLocation) {
		this.liveLocation = liveLocation;
	}

	public Double getCoveredDistance() {
		return coveredDistance;
	}

	public void setCoveredDistance(Double coveredDistance) {
		this.coveredDistance = coveredDistance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public int getNumOfStops() {
		return numOfStops;
	}

	public void setNumOfStops(int numOfStops) {
		this.numOfStops = numOfStops;
	}

	@Override
	public String toString() {
		return "TripDetailsDao [tripId=" + tripId + ", driverId=" + driverId + ", driverName=" + driverName
				+ ", vehicleId=" + vehicleId + ", vehicleRegNo=" + vehicleRegNo + ", routeId=" + routeId
				+ ", routeName=" + routeName + ", totalDistance=" + totalDistance + ", startTime=" + startTime
				+ ", currentSoc=" + currentSoc + ", liveLocation=" + liveLocation + ", coveredDistance="
				+ coveredDistance + ", status=" + status + ", deviceId=" + deviceId + ", numOfStops=" + numOfStops
				+ "]";
	}

}
