package com.vecv.model.user;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vecv.service.util.DateTimeUtil;

public class AttendanceModel {

	@JsonProperty(value = "checked_in_time")
	private String checkedInTime;
	@JsonProperty(value = "checked_out_time")
	private String checkedOutTime;
	@JsonProperty(value = "checked_in_location")
	private String checkedInLocation;
	@JsonProperty(value = "checked_out_location")
	private String checkedOutLocation;
	private String duration;
	private String latitude;
	private String longitude;

	public AttendanceModel() {
		super();
	}

	public AttendanceModel(String checkedInTime, String checkedOutTime, String checkedInLocation,
			String checkedOutLocation, String duration) {
		super();
		this.checkedInTime = checkedInTime;
		this.checkedOutTime = checkedOutTime;
		this.checkedInLocation = checkedInLocation;
		this.checkedOutLocation = checkedOutLocation;
		this.duration = duration;
	}

	public AttendanceModel(String checkedInTime, String checkedOutTime, String checkedInLocation,
			String checkedOutLocation, String duration, String latitude, String longitude) {
		super();
		this.checkedInTime = checkedInTime;
		this.checkedOutTime = checkedOutTime;
		this.checkedInLocation = checkedInLocation;
		this.checkedOutLocation = checkedOutLocation;
		this.duration = duration;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getCheckedInTime() {
		return checkedInTime;
	}

	public void setCheckedInTime(String checkedInTime) {
		this.checkedInTime = checkedInTime;
	}

	public String getCheckedOutTime() {
		return checkedOutTime;
	}

	public void setCheckedOutTime(String checkedOutTime) {
		this.checkedOutTime = checkedOutTime;
	}

	public String getCheckedInLocation() {
		return checkedInLocation;
	}

	public void setCheckedInLocation(String checkedInLocation) {
		this.checkedInLocation = checkedInLocation;
	}

	public String getCheckedOutLocation() {
		return checkedOutLocation;
	}

	public void setCheckedOutLocation(String checkedOutLocation) {
		this.checkedOutLocation = checkedOutLocation;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "AttendanceModel [checkedInTime=" + checkedInTime + ", checkedOutTime=" + checkedOutTime
				+ ", checkedInLocation=" + checkedInLocation + ", checkedOutLocation=" + checkedOutLocation
				+ ", duration=" + duration + "]";
	}

	public static String getCheckInDuration(String checkedInTime, String checkedoutTime) {
		String duration = null;
		LocalDateTime checkedInDateTime = null;
		LocalDateTime checkedOutDateTime = null;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);

//		Date firstDate = null;
//		Date secondDate = null;
//				
//		if(checkedInTime != null)
//			firstDate = sdf.parse(checkedInTime);
//		secondDate = sdf.parse(checkedoutTime);
//
//		long diffInMillies = Math.abs(checkedoutTime - checkedInTime);

//		if (checkedoutTime == null || checkedoutTime.isEmpty())
//			checkedOutDateTime = LocalDateTime.now();
//		else
//			checkedOutDateTime = LocalDateTime.parse(checkedoutTime, DateTimeFormatter.ofPattern(""));

		duration = "";
		return duration;
	}

	public static String getCheckInDuration(Date checkedInTime, Date checkedoutTime) {
		String duration = null;
		if (checkedoutTime == null)
			checkedoutTime = new Date();

		long durationInMillis = DateTimeUtil.getDifferenceBetweenTwoDatesInHours(checkedInTime, checkedoutTime);

		String formattedText = formatElapsedTime(durationInMillis / 1000);
		System.out.println("String formattedText : " + formattedText);

		return formattedText;
	}

	public static String formatElapsedTime(long seconds) {

		long hours = TimeUnit.SECONDS.toHours(seconds);
		seconds -= TimeUnit.HOURS.toSeconds(hours);

		long minutes = TimeUnit.SECONDS.toMinutes(seconds);
		seconds -= TimeUnit.MINUTES.toSeconds(minutes);

//		return String.format("%dhr:%dmin:%dsec", hours, minutes, seconds);
		return String.format("%dhr:%dmin", hours, minutes);
	}

}
