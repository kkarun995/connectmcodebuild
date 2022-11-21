package com.vecv.model.trip;

public class TripMonitorDetailsModel {

	private int totalTripsCompleted;
	private int onTimeTrips;
	private int delayTrips;

	public TripMonitorDetailsModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TripMonitorDetailsModel(int totalTripsCompleted, int onTimeTrips, int delayTrips) {
		super();
		this.totalTripsCompleted = totalTripsCompleted;
		this.onTimeTrips = onTimeTrips;
		this.delayTrips = delayTrips;
	}

	public int getTotalTripsCompleted() {
		return totalTripsCompleted;
	}

	public void setTotalTripsCompleted(int totalTripsCompleted) {
		this.totalTripsCompleted = totalTripsCompleted;
	}

	public int getOnTimeTrips() {
		return onTimeTrips;
	}

	public void setOnTimeTrips(int onTimeTrips) {
		this.onTimeTrips = onTimeTrips;
	}

	public int getDelayTrips() {
		return delayTrips;
	}

	public void setDelayTrips(int delayTrips) {
		this.delayTrips = delayTrips;
	}

	@Override
	public String toString() {
		return "TripMonitorDetailsModel [totalTripsCompleted=" + totalTripsCompleted + ", onTimeTrips=" + onTimeTrips
				+ ", delayTrips=" + delayTrips + "]";
	}

}
