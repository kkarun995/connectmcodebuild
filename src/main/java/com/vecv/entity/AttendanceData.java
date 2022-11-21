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
@Table(name = "attandance_data")
@NamedQuery(name = "AttendanceData.findAll", query = "SELECT c FROM AttendanceData c")
public class AttendanceData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer driverId;
	private Date date;
	private String day;
	private Date startTime;
	private Date endTime;
	private String startLocation;
	private String endLocation;
	private Boolean checkedin;
	private String latitude;
	private String longitude;
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

	@Column(name = "driverid")
	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	@Column(name = "date")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "day")
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
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

	public Boolean getCheckedin() {
		return checkedin;
	}

	public void setCheckedin(Boolean checkedin) {
		this.checkedin = checkedin;
	}

	@Column(name = "latitude")
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@Column(name = "longitude")
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
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
		return "AttendanceData [id=" + id + ", driverId=" + driverId + ", date=" + date + ", day=" + day
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", startLocation=" + startLocation
				+ ", endLocation=" + endLocation + ", checkedin=" + checkedin + ", createdTimestamp=" + createdTimestamp
				+ ", updatedTimestamp=" + updatedTimestamp + "]";
	}

}
