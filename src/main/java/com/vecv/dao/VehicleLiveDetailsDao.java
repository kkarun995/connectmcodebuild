package com.vecv.dao;

public class VehicleLiveDetailsDao {

	private Integer driverId;
	private Integer vehicleId;
	private Integer tripId;
	private Integer routeId;
	private String routeName;
	private String latitude;
	private String longitude;
	private double distance;
	private double distanceCovered;
	private double distanceLeft;
	private double soc;
	private String lastStoppageReached;
	private String checkedInDuration;

	public VehicleLiveDetailsDao() {
		super();
	}

	public VehicleLiveDetailsDao(Integer driverId, Integer vehicleId, Integer tripId, Integer routeId, String latitude,
			String longitude, double distance, double distanceCovered, double distanceLeft, double soc,
			String lastStoppageReached, String checkedInDuration) {
		super();
		this.driverId = driverId;
		this.vehicleId = vehicleId;
		this.tripId = tripId;
		this.routeId = routeId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.distance = distance;
		this.distanceCovered = distanceCovered;
		this.distanceLeft = distanceLeft;
		this.soc = soc;
		this.lastStoppageReached = lastStoppageReached;
		this.checkedInDuration = checkedInDuration;
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

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getDistanceCovered() {
		return distanceCovered;
	}

	public void setDistanceCovered(double distanceCovered) {
		this.distanceCovered = distanceCovered;
	}

	public double getDistanceLeft() {
		return distanceLeft;
	}

	public void setDistanceLeft(double distanceLeft) {
		this.distanceLeft = distanceLeft;
	}

	public Double getSoc() {
		return soc;
	}

	public void setSoc(Double soc) {
		this.soc = soc;
	}

	public String getLastStoppageReached() {
		return lastStoppageReached;
	}

	public void setLastStoppageReached(String lastStoppageReached) {
		this.lastStoppageReached = lastStoppageReached;
	}

	public String getCheckedInDuration() {
		return checkedInDuration;
	}

	public void setCheckedInDuration(String checkedInDuration) {
		this.checkedInDuration = checkedInDuration;
	}

	@Override
	public String toString() {
		return "VehicleLiveDetailsDao [driverId=" + driverId + ", vehicleId=" + vehicleId + ", tripId=" + tripId
				+ ", routeId=" + routeId + ", latitude=" + latitude + ", longitude=" + longitude + ", distance="
				+ distance + ", distanceCovered=" + distanceCovered + ", distanceLeft=" + distanceLeft + ", soc=" + soc
				+ ", lastStoppageReached=" + lastStoppageReached + ", checkedInDuration=" + checkedInDuration + "]";
	}

}
