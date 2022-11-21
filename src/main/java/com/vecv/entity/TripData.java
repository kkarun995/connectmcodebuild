package com.vecv.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "trip_data")
@NamedQuery(name = "TripData.findAll", query = "SELECT c FROM TripData c")
public class TripData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String tripName;
	private String driverName;
	private Date startTime;
	private Date endTime;
	private Double soc;
	private Double temperature;
	private Double startOdometer;
	private Double endOdometer;
	private Double distanceTravel;
	private String startLocation;
	private String endLocation;
	private Date createdTimestamp;
	private Date updatedTimestamp;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "INT(11) UNSIGNED")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "tripname")
	public String getTripName() {
		return tripName;
	}

	public void setTripName(String tripName) {
		this.tripName = tripName;
	}

	@Column(name = "drivername")
	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	@Column(name = "starttime")
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Column(name = "endtime")
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Column(name = "soc")
	public Double getSoc() {
		return soc;
	}

	public void setSoc(Double soc) {
		this.soc = soc;
	}

	@Column(name = "temprature")
	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	@Column(name = "startodo")
	public Double getStartOdometer() {
		return startOdometer;
	}

	public void setStartOdometer(Double startOdometer) {
		this.startOdometer = startOdometer;
	}

	@Column(name = "endodo")
	public Double getEndOdometer() {
		return endOdometer;
	}

	public void setEndOdometer(Double endOdometer) {
		this.endOdometer = endOdometer;
	}

	@Column(name = "distancetravel")
	public Double getDistanceTravel() {
		return distanceTravel;
	}

	public void setDistanceTravel(Double distanceTravel) {
		this.distanceTravel = distanceTravel;
	}

	@Column(name = "startlocation")
	public String getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}

	@Column(name = "endlocation")
	public String getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}

	@Column(name = "createdtimestamp")
	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	@Column(name = "updatedtimestamp")
	public Date getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	public void setUpdatedTimestamp(Date updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}

	@Override
	public String toString() {
		return "TripData [id=" + id + ", tripName=" + tripName + ", driverName=" + driverName + ", startTime="
				+ startTime + ", endTime=" + endTime + ", soc=" + soc + ", temperature=" + temperature
				+ ", startOdometer=" + startOdometer + ", endOdometer=" + endOdometer + ", distanceTravel="
				+ distanceTravel + ", startLocation=" + startLocation + ", endLocation=" + endLocation
				+ ", createdTimestamp=" + createdTimestamp + ", updatedTimestamp=" + updatedTimestamp + "]";
	}

}
