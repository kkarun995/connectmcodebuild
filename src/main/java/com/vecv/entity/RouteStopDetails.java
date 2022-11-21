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
@Table(name = "route_stop_details")
@NamedQuery(name = "RouteStopDetails.findAll", query = "SELECT c FROM RouteStopDetails c")
public class RouteStopDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private Date startTime;
	private Date endTime;
	private String stopLocation;
	private String stopLatitude;
	private String stopLongitude;
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

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Column(name = "stoplocation")
	public String getStopLocation() {
		return stopLocation;
	}

	public void setStopLocation(String stopLocation) {
		this.stopLocation = stopLocation;
	}

	@Column(name = "stoplatitude")
	public String getStopLatitude() {
		return stopLatitude;
	}

	public void setStopLatitude(String stopLatitude) {
		this.stopLatitude = stopLatitude;
	}

	@Column(name = "stoplongitude")
	public String getStopLongitude() {
		return stopLongitude;
	}

	public void setStopLongitude(String stopLongitude) {
		this.stopLongitude = stopLongitude;
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
		return "RouteStopDetails [id=" + id + ", name=" + name + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", stopLocation=" + stopLocation + ", stopLatitude=" + stopLatitude + ", stopLongitude="
				+ stopLongitude + ", createdTimestamp=" + createdTimestamp + ", updatedTimestamp=" + updatedTimestamp
				+ "]";
	}

}
