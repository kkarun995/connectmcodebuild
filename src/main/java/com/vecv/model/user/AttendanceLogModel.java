package com.vecv.model.user;

public class AttendanceLogModel {

	private String date;
	private boolean hasMarked;

	public AttendanceLogModel() {
		super();
	}

	public AttendanceLogModel(String date, boolean hasMarked) {
		super();
		this.date = date;
		this.hasMarked = hasMarked;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean getHasMarked() {
		return hasMarked;
	}

	public void setHasMarked(boolean hasMarked) {
		this.hasMarked = hasMarked;
	}

	@Override
	public String toString() {
		return "AttendanceLogModel [date=" + date + ", hasMarked=" + hasMarked + "]";
	}

}
