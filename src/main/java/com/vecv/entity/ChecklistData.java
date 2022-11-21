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
@Table(name = "checklist_data")
@NamedQuery(name = "ChecklistData.findAll", query = "SELECT c FROM ChecklistData c")
public class ChecklistData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Date date;
	private String checklistName;
	private Integer checklistId;
	private Integer userId;
	private Integer driverId;
	private Integer tripId;
	private Integer vehicleId;
	private String description;
	private Boolean status;
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

	@Column(name = "date")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "checklistname")
	public String getChecklistName() {
		return checklistName;
	}

	public void setChecklistName(String checklistName) {
		this.checklistName = checklistName;
	}

	@Column(name = "checklistid")
	public Integer getChecklistId() {
		return checklistId;
	}

	public void setChecklistId(Integer checklistId) {
		this.checklistId = checklistId;
	}

	@Column(name = "userid")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "driverid")
	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	@Column(name = "tripid")
	public Integer getTripId() {
		return tripId;
	}

	public void setTripId(Integer tripId) {
		this.tripId = tripId;
	}

	@Column(name = "vehicleid")
	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "status")
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
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
		return "ChecklistData [id=" + id + ", date=" + date + ", checklistName=" + checklistName + ", checklistId="
				+ checklistId + ", userId=" + userId + ", driverId=" + driverId + ", tripId=" + tripId + ", vehicleId="
				+ vehicleId + ", description=" + description + ", status=" + status + ", createdTimestamp="
				+ createdTimestamp + ", updatedTimestamp=" + updatedTimestamp + "]";
	}

}
