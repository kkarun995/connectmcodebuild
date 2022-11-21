package com.vecv.dao;

public class TripLogsDao {

	private Integer driverId;
	private Integer vehicleId;
	private String vehicleRegNo;
	private Integer routeId;
	private String routeName;
	private int numOfTripsCompleted;
	private double startSoc;
	private double endSoc;
	private double startOdometer;
	private double endOdometer;
	private String duration;
	private String status;
	private String startTime;

	public TripLogsDao() {
		super();
	}

	public TripLogsDao(Integer driverId, Integer vehicleId, String vehicleRegNo, Integer routeId, String routeName,
			int numOfTripsCompleted, double startSoc, double endSoc, double startOdometer, double endOdometer,
			String duration, String status, String startTime) {
		super();
		this.driverId = driverId;
		this.vehicleId = vehicleId;
		this.vehicleRegNo = vehicleRegNo;
		this.routeId = routeId;
		this.routeName = routeName;
		this.numOfTripsCompleted = numOfTripsCompleted;
		this.startSoc = startSoc;
		this.endSoc = endSoc;
		this.startOdometer = startOdometer;
		this.endOdometer = endOdometer;
		this.duration = duration;
		this.status = status;
		this.startTime = startTime;
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

	public int getNumOfTripsCompleted() {
		return numOfTripsCompleted;
	}

	public void setNumOfTripsCompleted(int numOfTripsCompleted) {
		this.numOfTripsCompleted = numOfTripsCompleted;
	}

	public double getStartSoc() {
		return startSoc;
	}

	public void setStartSoc(double startSoc) {
		this.startSoc = startSoc;
	}

	public double getEndSoc() {
		return endSoc;
	}

	public void setEndSoc(double endSoc) {
		this.endSoc = endSoc;
	}

	public double getStartOdometer() {
		return startOdometer;
	}

	public void setStartOdometer(double startOdometer) {
		this.startOdometer = startOdometer;
	}

	public double getEndOdometer() {
		return endOdometer;
	}

	public void setEndOdometer(double endOdometer) {
		this.endOdometer = endOdometer;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	@Override
	public String toString() {
		return "TripLogsDao [driverId=" + driverId + ", vehicleId=" + vehicleId + ", vehicleRegNo=" + vehicleRegNo
				+ ", routeId=" + routeId + ", routeName=" + routeName + ", numOfTripsCompleted=" + numOfTripsCompleted
				+ ", startSoc=" + startSoc + ", endSoc=" + endSoc + ", startOdometer=" + startOdometer
				+ ", endOdometer=" + endOdometer + ", duration=" + duration + ", status=" + status + "]";
	}

}
