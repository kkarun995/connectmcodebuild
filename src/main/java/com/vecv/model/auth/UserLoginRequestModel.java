package com.vecv.model.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserLoginRequestModel {

	@JsonProperty(value = "phone_number")
	private String phoneNumber;
	private String password;
	private Integer otp;
	private String role;
	@JsonProperty(value = "login_type")
	private String loginType;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getOtp() {
		return otp;
	}

	public void setOtp(Integer otp) {
		this.otp = otp;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	@Override
	public String toString() {
		return "UserLoginRequestModel [phoneNumber=" + phoneNumber + ", password=" + password + ", otp=" + otp
				+ ", role=" + role + ", loginType=" + loginType + "]";
	}

}
