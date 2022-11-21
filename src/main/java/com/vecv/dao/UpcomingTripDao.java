package com.vecv.dao;

import java.util.Date;

public class UpcomingTripDao {

	private Integer id;
	private Integer vehicleId;
	private Integer routeId;
	private String routeName;
	private Integer driverId;
	private String tripName;
	private Date startTime;
	private Date endTime;
	private Boolean checkedIn;
	private String startLocation;
	private String endLocation;

	public UpcomingTripDao() {
		super();
	}

	public UpcomingTripDao(Integer id, Integer vehicleId, Integer routeId, String routeName, Integer driverId,
			String tripName, Date startTime, Date endTime, Boolean checkedIn, String startLocation,
			String endLocation) {
		super();
		this.id = id;
		this.vehicleId = vehicleId;
		this.routeId = routeId;
		this.routeName = routeName;
		this.driverId = driverId;
		this.tripName = tripName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.checkedIn = checkedIn;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
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

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public String getTripName() {
		return tripName;
	}

	public void setTripName(String tripName) {
		this.tripName = tripName;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Boolean getCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(Boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public String getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}

	public String getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}

}
