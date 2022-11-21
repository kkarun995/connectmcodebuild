package com.vecv.dao;

public class TripMonitorDetailsDao {

	private double totalTripsCompleted;
	private double onTimeTrips;
	private double delayTrips;

	public TripMonitorDetailsDao() {
		super();
	}

	public TripMonitorDetailsDao(double totalTripsCompleted, double onTimeTrips, double delayTrips) {
		super();
		this.totalTripsCompleted = totalTripsCompleted;
		this.onTimeTrips = onTimeTrips;
		this.delayTrips = delayTrips;
	}

	public double getTotalTripsCompleted() {
		return totalTripsCompleted;
	}

	public void setTotalTripsCompleted(double totalTripsCompleted) {
		this.totalTripsCompleted = totalTripsCompleted;
	}

	public double getOnTimeTrips() {
		return onTimeTrips;
	}

	public void setOnTimeTrips(double onTimeTrips) {
		this.onTimeTrips = onTimeTrips;
	}

	public double getDelayTrips() {
		return delayTrips;
	}

	public void setDelayTrips(double delayTrips) {
		this.delayTrips = delayTrips;
	}

	@Override
	public String toString() {
		return "TripMonitorDetailsModel [totalTripsCompleted=" + totalTripsCompleted + ", onTimeTrips=" + onTimeTrips
				+ ", delayTrips=" + delayTrips + "]";
	}

}
