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
@Table(name = "trip_details")
@NamedQuery(name = "TripDetails.findAll", query = "SELECT c FROM TripDetails c")
public class TripDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer vehicleId;
	private Integer routeId;
	private Integer driverId;
	private String tripName;
	private Date startTime;
	private Date endTime;
	private Boolean checkedIn;
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

	@Column(name = "vehicleid")
	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	@Column(name = "routeid")
	public Integer getRouteId() {
		return routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	@Column(name = "driverid")
	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	@Column(name = "tripname")
	public String getTripName() {
		return tripName;
	}

	public void setTripName(String tripName) {
		this.tripName = tripName;
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

	@Column(name = "checkedin")
	public Boolean getCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(Boolean checkedIn) {
		this.checkedIn = checkedIn;
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
		return "TripDetails [id=" + id + ", vehicleId=" + vehicleId + ", routeId=" + routeId + ", driverId=" + driverId
				+ ", createdTimestamp=" + createdTimestamp + ", updatedTimestamp=" + updatedTimestamp + "]";
	}

}
