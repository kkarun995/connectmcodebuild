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
@Table(name = "driver_details")
@NamedQuery(name = "DriverDetails.findAll", query = "SELECT c FROM DriverDetails c")
public class DriverDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private Date dob;
	private Date anniversaryDate;
	private String tagId;
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

	@Column(name = "dob")
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Column(name = "anniversary")
	public Date getAnniversaryDate() {
		return anniversaryDate;
	}

	public void setAnniversaryDate(Date anniversaryDate) {
		this.anniversaryDate = anniversaryDate;
	}

	@Column(name = "tag_id")
	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
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
		return "DriverDetails [id=" + id + ", name=" + name + ", dob=" + dob + ", anniversaryDate=" + anniversaryDate
				+ ", createdTimestamp=" + createdTimestamp + ", updatedTimestamp=" + updatedTimestamp + "]";
	}

}
