package com.vecv.dao;

public class TripSummaryDao {

	private Integer driverId;
	private Double startOdometer;
	private Double endOdometer;
	private Double totalDistanceCovered;
	private Double startSoc;
	private Double endSoc;
	private Double consumedSoc;
	private Double avgSpeed;
	private String totalTimeSpent;
	private String checkedInDuration;

	public TripSummaryDao() {
		super();
	}

	public TripSummaryDao(Integer driverId, Double startOdometer, Double endOdometer, Double totalDistanceCovered,
			Double startSoc, Double endSoc, Double consumedSoc, Double avgSpeed, String totalTimeSpent,
			String checkedInDuration) {
		super();
		this.driverId = driverId;
		this.startOdometer = startOdometer;
		this.endOdometer = endOdometer;
		this.totalDistanceCovered = totalDistanceCovered;
		this.startSoc = startSoc;
		this.endSoc = endSoc;
		this.consumedSoc = consumedSoc;
		this.avgSpeed = avgSpeed;
		this.totalTimeSpent = totalTimeSpent;
		this.checkedInDuration = checkedInDuration;
	}

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public Double getStartOdometer() {
		return startOdometer;
	}

	public void setStartOdometer(Double startOdometer) {
		this.startOdometer = startOdometer;
	}

	public Double getEndOdometer() {
		return endOdometer;
	}

	public void setEndOdometer(Double endOdometer) {
		this.endOdometer = endOdometer;
	}

	public Double getTotalDistanceCovered() {
		return totalDistanceCovered;
	}

	public void setTotalDistanceCovered(Double totalDistanceCovered) {
		this.totalDistanceCovered = totalDistanceCovered;
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

	public Double getConsumedSoc() {
		return consumedSoc;
	}

	public void setConsumedSoc(Double consumedSoc) {
		this.consumedSoc = consumedSoc;
	}

	public Double getAvgSpeed() {
		return avgSpeed;
	}

	public void setAvgSpeed(Double avgSpeed) {
		this.avgSpeed = avgSpeed;
	}

	public String getTotalTimeSpent() {
		return totalTimeSpent;
	}

	public void setTotalTimeSpent(String totalTimeSpent) {
		this.totalTimeSpent = totalTimeSpent;
	}

	public String getCheckedInDuration() {
		return checkedInDuration;
	}

	public void setCheckedInDuration(String checkedInDuration) {
		this.checkedInDuration = checkedInDuration;
	}

	@Override
	public String toString() {
		return "TripSummaryDao [driverId=" + driverId + ", startOdometer=" + startOdometer + ", endOdometer="
				+ endOdometer + ", totalDistanceCovered=" + totalDistanceCovered + ", startSoc=" + startSoc
				+ ", endSoc=" + endSoc + ", consumedSoc=" + consumedSoc + ", avgSpeed=" + avgSpeed + ", totalTimeSpent="
				+ totalTimeSpent + ", checkedInDuration=" + checkedInDuration + "]";
	}

}
