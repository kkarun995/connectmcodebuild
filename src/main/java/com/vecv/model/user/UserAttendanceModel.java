package com.vecv.model.user;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class UserAttendanceModel {

	@JsonProperty(value = "user_id", access = Access.READ_ONLY)
	private Integer userId;
	@JsonProperty(value = "user_name")
	private String userName;
	private String role;
	@JsonProperty(value = "attendances")
	private List<AttendanceModel> attendanceList;

	public UserAttendanceModel() {
		super();
	}

	public UserAttendanceModel(Integer userId, String userName, String role, List<AttendanceModel> attendanceList) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.role = role;
		this.attendanceList = attendanceList;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<AttendanceModel> getAttendanceList() {
		return attendanceList;
	}

	public void setAttendanceList(List<AttendanceModel> attendanceList) {
		this.attendanceList = attendanceList;
	}

	@Override
	public String toString() {
		return "UserAttendanceModel [userId=" + userId + ", userName=" + userName + ", role=" + role
				+ ", attendanceList=" + attendanceList + "]";
	}

}
