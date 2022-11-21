package com.vecv.dao;

public class TripKpiDao {

	private Integer driverId;
	private Integer vehicleId;
	private Double startOdo;
	private Double endOdo;
	private Double totalKm;
	private Double startSoc;
	private Double endSoc;
	private Double totalSoc;
	private Double maxSpeed;
	private String startTime;
	private String endTime;
	private String totalTime;
	private String startLocation;
	private String endLocation;
	private String tripStatus;

	public TripKpiDao() {
		super();
	}

	public TripKpiDao(Integer driverId, Integer vehicleId, Double startOdo, Double endOdo, Double totalKm,
			Double startSoc, Double endSoc, Double totalSoc, Double maxSpeed, String startTime, String endTime,
			String totalTime, String startLocation, String endLocation, String tripStatus) {
		super();
		this.driverId = driverId;
		this.vehicleId = vehicleId;
		this.startOdo = startOdo;
		this.endOdo = endOdo;
		this.totalKm = totalKm;
		this.startSoc = startSoc;
		this.endSoc = endSoc;
		this.totalSoc = totalSoc;
		this.maxSpeed = maxSpeed;
		this.startTime = startTime;
		this.endTime = endTime;
		this.totalTime = totalTime;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		this.tripStatus = tripStatus;
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

	public Double getStartOdo() {
		return startOdo;
	}

	public void setStartOdo(Double startOdo) {
		this.startOdo = startOdo;
	}

	public Double getEndOdo() {
		return endOdo;
	}

	public void setEndOdo(Double endOdo) {
		this.endOdo = endOdo;
	}

	public Double getTotalKm() {
		return totalKm;
	}

	public void setTotalKm(Double totalKm) {
		this.totalKm = totalKm;
	}

	public Double getStartSoc() {
		return startSoc;
	}

	public void setStartSoc(Double startSoc) {
		this.startSoc = startSoc;
	}

	public Double getEndSoc() {
		return endSoc;
	}

	public void setEndSoc(Double endSoc) {
		this.endSoc = endSoc;
	}

	public Double getTotalSoc() {
		return totalSoc;
	}

	public void setTotalSoc(Double totalSoc) {
		this.totalSoc = totalSoc;
	}

	public Double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(Double maxSpeed) {
		this.maxSpeed = maxSpeed;
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

	public String getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
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

	public String getTripStatus() {
		return tripStatus;
	}

	public void setTripStatus(String tripStatus) {
		this.tripStatus = tripStatus;
	}

	@Override
	public String toString() {
		return "TripKpiDao [driverId=" + driverId + ", vehicleId=" + vehicleId + ", startOdo=" + startOdo + ", endOdo="
				+ endOdo + ", totalKm=" + totalKm + ", startSoc=" + startSoc + ", endSoc=" + endSoc + ", totalSoc="
				+ totalSoc + ", maxSpeed=" + maxSpeed + ", startLocation=" + startLocation + ", endLocation="
				+ endLocation + ", tripStatus=" + tripStatus + ", totalTime=" + totalTime + "]";
	}

}
