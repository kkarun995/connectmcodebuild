package com.vecv.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
@NamedQuery(name = "UserDetails.findAll", query = "SELECT c FROM UserDetails c")
public class UserDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer driverId;
	private String userName;
	private String password;
	private String phoneNumber;
	private Date dob;
	private Date anniversaryDate;
	private String emailId;
	private String role;
	private String gender;
	private byte[] displayPicture;
	private Integer otp;
	private Date createdTimestamp;
	private Date updatedTimestamp;
	private Integer isDeleted;

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

	@Column(name = "username")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "phonenumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "dob")
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Column(name = "anniversarydate")
	public Date getAnniversaryDate() {
		return anniversaryDate;
	}

	public void setAnniversaryDate(Date anniversaryDate) {
		this.anniversaryDate = anniversaryDate;
	}

	@Column(name = "emailid")
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "role")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name = "gender")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "displaypicture")
	public byte[] getDisplayPicture() {
		return displayPicture;
	}

	public void setDisplayPicture(byte[] displayPicture) {
		this.displayPicture = displayPicture;
	}

	@Column(name = "otp")
	public Integer getOtp() {
		return otp;
	}

	public void setOtp(Integer otp) {
		this.otp = otp;
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

	@Column(name = "is_deleted")
	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", driverId=" + driverId + ", userName=" + userName + ", password=" + password
				+ ", phoneNumber=" + phoneNumber + ", dob=" + dob + ", anniversaryDate=" + anniversaryDate
				+ ", emailId=" + emailId + ", role=" + role + ", gender=" + gender + ", displayPicture="
				+ Arrays.toString(displayPicture) + ", otp=" + otp + ", createdTimestamp=" + createdTimestamp
				+ ", updatedTimestamp=" + updatedTimestamp + ", isDeleted=" + isDeleted + "]";
	}

}
