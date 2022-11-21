package com.vecv.model.trip;

public class TripLogRequestModel {

	private Integer driverId;
	private Integer vehicleId;
	private boolean todayTrip;
	private boolean last7DaysTrip;
	private boolean last10DaysTrip;
	private String fromTime;
	private String toTime;

	public TripLogRequestModel() {
		super();
	}

	public TripLogRequestModel(Integer driverId, Integer vehicleId, boolean todayTrip, boolean last7DaysTrip,
			boolean last10DaysTrip, String fromTime, String toTime) {
		super();
		this.driverId = driverId;
		this.vehicleId = vehicleId;
		this.todayTrip = todayTrip;
		this.last7DaysTrip = last7DaysTrip;
		this.last10DaysTrip = last10DaysTrip;
		this.fromTime = fromTime;
		this.toTime = toTime;
	}

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public boolean getTodayTrip() {
		return todayTrip;
	}

	public void setTodayTrip(boolean todayTrip) {
		this.todayTrip = todayTrip;
	}

	public boolean getLast7DaysTrip() {
		return last7DaysTrip;
	}

	public void setLast7DaysTrip(boolean last7DaysTrip) {
		this.last7DaysTrip = last7DaysTrip;
	}

	public boolean getLast10DaysTrip() {
		return last10DaysTrip;
	}

	public void setLast10DaysTrip(boolean last10DaysTrip) {
		this.last10DaysTrip = last10DaysTrip;
	}

	public String getFromTime() {
		return fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public String getToTime() {
		return toTime;
	}

	public void setToTime(String toTime) {
		this.toTime = toTime;
	}

	@Override
	public String toString() {
		return "TripLogRequestModel [driverId=" + driverId + ", vehicleId=" + vehicleId + ", todayTrip=" + todayTrip
				+ ", last7DaysTrip=" + last7DaysTrip + ", last10DaysTrip=" + last10DaysTrip + ", fromTime=" + fromTime
				+ ", toTime=" + toTime + "]";
	}

}
