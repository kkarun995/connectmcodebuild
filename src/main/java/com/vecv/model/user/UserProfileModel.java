package com.vecv.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserProfileModel {

	@JsonProperty(value = "user_id")
	private Integer userId;
	private String userName;
	private String designation;
	@JsonProperty(value = "phone_number")
	private String phoneNumber;
	private String gender;
	@JsonProperty(value = "anniversary_date")
	private String anniversaryDate;
	@JsonProperty(value = "date_of_birth")
	private String dateOfBirth;
	private String role;
	@JsonProperty(value = "checked_in_status")
	private boolean checkedInStatus;
	@JsonProperty(value = "checked_in_time")
	private String checkedInTime;
	private boolean isReported;
	private String tagId;

	public UserProfileModel() {
		super();
	}

	public UserProfileModel(Integer userId, String userName, String designation, String phoneNumber, String gender,
			String anniversaryDate, String dateOfBirth, String role, boolean checkedInStatus, String checkedInTime) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.designation = designation;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.anniversaryDate = anniversaryDate;
		this.dateOfBirth = dateOfBirth;
		this.role = role;
		this.checkedInStatus = checkedInStatus;
		this.checkedInTime = checkedInTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAnniversaryDate() {
		return anniversaryDate;
	}

	public void setAnniversaryDate(String anniversaryDate) {
		this.anniversaryDate = anniversaryDate;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isCheckedInStatus() {
		return checkedInStatus;
	}

	public void setCheckedInStatus(boolean checkedInStatus) {
		this.checkedInStatus = checkedInStatus;
	}

	public String getCheckedInTime() {
		return checkedInTime;
	}

	public void setCheckedInTime(String checkedInTime) {
		this.checkedInTime = checkedInTime;
	}

	public boolean getIsReported() {
		return isReported;
	}

	public void setIsReported(boolean isReported) {
		this.isReported = isReported;
	}

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	@Override
	public String toString() {
		return "UserProfileModel [userId=" + userId + ", userName=" + userName + ", designation=" + designation
				+ ", phoneNumber=" + phoneNumber + ", gender=" + gender + ", anniversaryDate=" + anniversaryDate
				+ ", dateOfBirth=" + dateOfBirth + ", role=" + role + ", checkedInStatus=" + checkedInStatus
				+ ", checkedInTime=" + checkedInTime + "]";
	}

}
