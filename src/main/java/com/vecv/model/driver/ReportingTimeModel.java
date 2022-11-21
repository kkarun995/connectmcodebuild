package com.vecv.model.driver;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class ReportingTimeModel {

	private Integer driverId;
	@JsonProperty(access = Access.READ_ONLY)
	private String reportingTime;
//	@JsonProperty(access = Access.READ_ONLY)
	private String location;
	private String latitude;
	private String longitude;

	public ReportingTimeModel() {
		super();
	}

	public ReportingTimeModel(Integer driverId, String reportingTime, String location, String latitude,
			String longitude) {
		super();
		this.driverId = driverId;
		this.reportingTime = reportingTime;
		this.location = location;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public String getReportingTime() {
		return reportingTime;
	}

	public void setReportingTime(String reportingTime) {
		this.reportingTime = reportingTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	@Override
	public String toString() {
		return "ReportingTimeRequestModel [driverId=" + driverId + ", reportingTime=" + reportingTime + ", location="
				+ location + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}
