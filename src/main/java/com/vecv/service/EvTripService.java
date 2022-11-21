package com.vecv.service;

import java.util.List;
import java.util.Map;

import com.vecv.core.exception.EvServiceException;
import com.vecv.dao.TripDetailsDao;
import com.vecv.dao.TripLogsDao;
import com.vecv.dao.TripSummaryDao;
import com.vecv.model.trip.ScoreDetailsModel;
import com.vecv.model.trip.TripLogRequestModel;
import com.vecv.model.trip.TripMonitorDetailsModel;
import com.vecv.model.trip.TripStatusRequestModel;
import com.vecv.model.trip.UpcomingTripDetailsModel;

public interface EvTripService {

	UpcomingTripDetailsModel upcomingTrip(Integer userId) throws EvServiceException;

	ScoreDetailsModel getScoreDetails(Integer driverId) throws EvServiceException;

	TripMonitorDetailsModel getTripMonitor(Integer driverId) throws EvServiceException;

	Map<String, Object> getHomePageDetails(Integer driverId) throws EvServiceException;

	List<TripDetailsDao> getAllTrips(Integer driverId) throws EvServiceException;

	String updateTripStatus(TripStatusRequestModel tripStatusRequestModel) throws EvServiceException;

	List<TripLogsDao> getTripLogs(TripLogRequestModel tripLogRequestModel) throws EvServiceException;

	TripSummaryDao getTripSummary(Integer driverId) throws EvServiceException;;

}
