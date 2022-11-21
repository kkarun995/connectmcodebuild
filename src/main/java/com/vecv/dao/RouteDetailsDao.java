package com.vecv.dao;

import java.util.List;

public class RouteDetailsDao {

	private Integer driverId;
	private Integer vehicleId;
	private Integer tripId;
	private Integer routeId;
	private String routeName;
	private String tripStatus;
	private int numOfStops;
	private Double totalDistance;
	private String estimatedTimeToDestination;
	private String startTime;
	private String endTime;
//	private String startLocation;
//	private String endLocation;
//	private String startLatitude;
//	private String startLongitude;
//	private String endLatitude;
//	private String endLongitude;
	private List<StoppageDetails> stoppageList;

	public RouteDetailsDao() {
		super();
	}

	public RouteDetailsDao(Integer driverId, Integer vehicleId, Integer tripId, Integer routeId, String routeName,
			String tripStatus, int numOfStops, Double totalDistance, String estimatedTimeToDestination,
			List<StoppageDetails> stoppageList) {
		super();
		this.driverId = driverId;
		this.vehicleId = vehicleId;
		this.tripId = tripId;
		this.routeId = routeId;
		this.routeName = routeName;
		this.tripStatus = tripStatus;
		this.numOfStops = numOfStops;
		this.totalDistance = totalDistance;
		this.estimatedTimeToDestination = estimatedTimeToDestination;
		this.stoppageList = stoppageList;
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

	public Integer getTripId() {
		return tripId;
	}

	public void setTripId(Integer tripId) {
		this.tripId = tripId;
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

	public String getTripStatus() {
		return tripStatus;
	}

	public void setTripStatus(String tripStatus) {
		this.tripStatus = tripStatus;
	}

	public int getNumOfStops() {
		return numOfStops;
	}

	public void setNumOfStops(int numOfStops) {
		this.numOfStops = numOfStops;
	}

	public Double getTotalDistance() {
		return totalDistance;
	}

	public void setTotalDistance(Double totalDistance) {
		this.totalDistance = totalDistance;
	}

	public String getEstimatedTimeToDestination() {
		return estimatedTimeToDestination;
	}

	public void setEstimatedTimeToDestination(String estimatedTimeToDestination) {
		this.estimatedTimeToDestination = estimatedTimeToDestination;
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

	public List<StoppageDetails> getStoppageList() {
		return stoppageList;
	}

	public void setStoppageList(List<StoppageDetails> stoppageList) {
		this.stoppageList = stoppageList;
	}

	@Override
	public String toString() {
		return "RouteDetailsDao [driverId=" + driverId + ", vehicleId=" + vehicleId + ", tripId=" + tripId
				+ ", routeId=" + routeId + ", routeName=" + routeName + ", tripStatus=" + tripStatus + ", numOfStops="
				+ numOfStops + ", totalDistance=" + totalDistance + ", estimatedTimeToDestination="
				+ estimatedTimeToDestination + ", stoppageList=" + stoppageList + "]";
	}

}
