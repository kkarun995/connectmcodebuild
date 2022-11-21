package com.vecv.service.util;

import java.time.LocalDate;

import com.vecv.dao.UpcomingTripDao;
import com.vecv.entity.AttendanceData;
import com.vecv.entity.DriverDetails;
import com.vecv.entity.VehicleDetails;
import com.vecv.model.trip.TripLogRequestModel;
import com.vecv.model.trip.UpcomingTripDetailsModel;

public class TripUtil {

	private TripUtil() {
	}

	public static UpcomingTripDetailsModel getDefaultLatestTripDetails() {
		UpcomingTripDetailsModel tripDetailsModel = new UpcomingTripDetailsModel();
		tripDetailsModel.setTripId(1);
		tripDetailsModel.setAssignedVehicleNo("DL1 PE 0936");
		tripDetailsModel.setRoute("R1-Del-Jpr");
		tripDetailsModel.setStartPoint("Millennium Depot, Pragati Maidan, New Delhi");
		tripDetailsModel.setEndPoint("IGI Airport, Delhi Aero City, New Delhi");
		tripDetailsModel.setStartTime("06:30 AM");
		tripDetailsModel.setEndTime("03:30 PM");

		if (tripDetailsModel.getStartTime() != null && !tripDetailsModel.getStartTime().isEmpty())
			tripDetailsModel.setAlreadyCheckedIn(false);

		return tripDetailsModel;
	}

	public static UpcomingTripDetailsModel getLatestTripDetails(UpcomingTripDao tripDetails,
			VehicleDetails vehicleDetails, AttendanceData attendanceData, DriverDetails driverDetails) {
		UpcomingTripDetailsModel tripDetailsModel = new UpcomingTripDetailsModel();
		tripDetailsModel.setTripId(tripDetails.getId());
		tripDetailsModel.setAssignedVehicleNo(vehicleDetails.getRegNo());
		tripDetailsModel.setRoute(tripDetails.getRouteName());
		tripDetailsModel.setStartPoint(tripDetails.getStartLocation());
		tripDetailsModel.setEndPoint(tripDetails.getEndLocation());
		if (tripDetails.getStartTime() != null)
			tripDetailsModel.setStartTime(DateTimeUtil.parseText(tripDetails.getStartTime(), "HH:mm aa"));
		if (tripDetails.getEndTime() != null)
			tripDetailsModel.setEndTime(DateTimeUtil.parseText(tripDetails.getEndTime(), "HH:mm aa"));

		if (attendanceData != null)
			tripDetailsModel.setAlreadyCheckedIn(Boolean.TRUE);

		if (driverDetails != null)
			tripDetailsModel.setTagId(driverDetails.getTagId());
		return tripDetailsModel;
	}

	public static void getStartAndEndTimeForTripLogs(TripLogRequestModel tripLogRequestModel) {
		if (tripLogRequestModel != null) {
			LocalDate localDate = LocalDate.now();
			if (tripLogRequestModel.getTodayTrip()) {
				tripLogRequestModel.setFromTime(localDate.toString());
				tripLogRequestModel.setToTime(localDate.toString());
			}
//			else if (tripLogRequestModel.getYesterdayTrip()) {
//				tripLogRequestModel.setFromTime(localDate.minusDays(1).toString());
//				tripLogRequestModel.setToTime(localDate.minusDays(1).toString());
//			}
			else if (tripLogRequestModel.getLast7DaysTrip()) {
				tripLogRequestModel.setFromTime(localDate.minusDays(6).toString());
				tripLogRequestModel.setToTime(localDate.toString());
			} else if (tripLogRequestModel.getLast10DaysTrip()) {
				tripLogRequestModel.setFromTime(localDate.minusDays(9).toString());
				tripLogRequestModel.setToTime(localDate.toString());
			} else if (tripLogRequestModel.getFromTime() != null && !tripLogRequestModel.getFromTime().isEmpty()
					&& tripLogRequestModel.getToTime() != null && !tripLogRequestModel.getToTime().isEmpty()) {
				// Nothing to do
			}
		}
	}

}
