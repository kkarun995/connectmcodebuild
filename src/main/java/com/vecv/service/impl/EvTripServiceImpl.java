package com.vecv.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vecv.aws.PublishSubscriber;
import com.vecv.core.EvLoggerConstants;
import com.vecv.core.exception.EvServiceException;
import com.vecv.dao.CurrentDataDao;
import com.vecv.dao.TripDetailsDao;
import com.vecv.dao.TripLogsDao;
import com.vecv.dao.TripSummaryDao;
import com.vecv.dao.UpcomingTripDao;
import com.vecv.entity.AttendanceData;
import com.vecv.entity.DriverDetails;
import com.vecv.entity.VehicleDetails;
import com.vecv.model.trip.ScoreDetailsModel;
import com.vecv.model.trip.TripLogRequestModel;
import com.vecv.model.trip.TripMonitorDetailsModel;
import com.vecv.model.trip.TripStatusRequestModel;
import com.vecv.model.trip.UpcomingTripDetailsModel;
import com.vecv.repository.EvAttendanceDataRepository;
import com.vecv.repository.EvDriverDetailsRepository;
import com.vecv.repository.HomepageRepository;
import com.vecv.repository.TripManagementRepository;
import com.vecv.service.EvTripService;
import com.vecv.service.util.DateTimeUtil;
import com.vecv.service.util.DecimalFormatterUtil;
import com.vecv.service.util.TripUtil;

@Service
public class EvTripServiceImpl implements EvTripService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EvTripServiceImpl.class);

	@Autowired
	private EvAttendanceDataRepository attendanceDataRepository;
	@Autowired
	private HomepageRepository homepageRepository;
	@Autowired
	private TripManagementRepository tripManagementRepository;
	@Autowired
	private PublishSubscriber publishSubscriber;
	@Autowired
	private EvDriverDetailsRepository driverDetailsRepository;

	@Override
	public UpcomingTripDetailsModel upcomingTrip(@Valid Integer driverId) throws EvServiceException {
		LOGGER.info("Started getting latest trip details for user id: {}", driverId);
		try {
			if (driverId == null)
				throw new EvServiceException("User not found");

			AttendanceData attendanceData = attendanceDataRepository.findTodayAttendanceByDriverId(driverId);
			if (attendanceData != null) {
				throw new EvServiceException("It is already checked in");
			}

//			TripDetails tripDetails = tripDetailsRepository.findUpcomingTripByDriverId(driverId);
//			TripDetails tripDetails = homepageRepository.findUpcomingTripByDriverId(driverId);
			UpcomingTripDao tripDetails = homepageRepository.findUpcomingTrip(driverId);
			if (tripDetails == null) {
				throw new EvServiceException("No Upcoming trip found");
			}
			VehicleDetails vehicleDetails = homepageRepository.findByVehicleId(tripDetails.getVehicleId());

			DriverDetails driverDetails = driverDetailsRepository.findByDriverId(driverId);
//			return TripUtil.getDefaultLatestTripDetails();
			return TripUtil.getLatestTripDetails(tripDetails, vehicleDetails, attendanceData, driverDetails);
		} catch (EvServiceException e) {
			throw new EvServiceException(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(EvLoggerConstants.EXCEPTION, e.getMessage());
			e.printStackTrace();
			throw new EvServiceException(e.getMessage());
		}
	}

	@Override
	public ScoreDetailsModel getScoreDetails(@Valid Integer driverId) throws EvServiceException {
		LOGGER.info("Started getting score details for driverId: {}", driverId);
		try {
			if (driverId == null)
				throw new EvServiceException("Driver not registered");

			return new ScoreDetailsModel(driverId, 30, 02, 05, 10);
		} catch (EvServiceException e) {
			throw new EvServiceException(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(EvLoggerConstants.EXCEPTION, e.getMessage());
			e.printStackTrace();
			throw new EvServiceException(e.getMessage());
		}
	}

	@Override
	public TripMonitorDetailsModel getTripMonitor(@Valid Integer driverId) throws EvServiceException {
		LOGGER.info("Started getting trip monitor details for driverId: {}", driverId);
		try {
			if (driverId == null)
				throw new EvServiceException("Driver not registered");

			return new TripMonitorDetailsModel(17, 12, 5);
		} catch (EvServiceException e) {
			throw new EvServiceException(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(EvLoggerConstants.EXCEPTION, e.getMessage());
			e.printStackTrace();
			throw new EvServiceException(e.getMessage());
		}
	}

	@Override
	public Map<String, Object> getHomePageDetails(@Valid Integer driverId) throws EvServiceException {
		LOGGER.info("Started getting home page details for driverId: {}", driverId);
		try {
			if (driverId == null)
				throw new EvServiceException("Driver not registered");

			Map<String, Object> homePageMap = new HashMap<>();
			homePageMap.put("score", homepageRepository.getScoreDetails(driverId));
			homePageMap.put("trip_monitor", homepageRepository.getTripMonitor(driverId));
			homePageMap.put("vehicle_details", homepageRepository.getVehicleDetails(driverId));

			return homePageMap;
		} catch (EvServiceException e) {
			throw new EvServiceException(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(EvLoggerConstants.EXCEPTION, e.getMessage());
			e.printStackTrace();
			throw new EvServiceException(e.getMessage());
		}
	}

	@Override
	public List<TripDetailsDao> getAllTrips(@Valid Integer driverId) throws EvServiceException {
		LOGGER.info("Started getting home page details for driverId: {}", driverId);
		try {
			if (driverId == null)
				throw new EvServiceException("Driver not registered");

//			List<TripDetailsDao> tripDetailsList = homepageRepository.getAllTrips(driverId);

			List<TripDetailsDao> ongoingTripDetailsList = homepageRepository.getAllOngoingTrips(driverId);
			List<Integer> ongoingTripIds = null;
			if (ongoingTripDetailsList != null && !ongoingTripDetailsList.isEmpty()) {
				ongoingTripIds = ongoingTripDetailsList.stream().map(tp -> tp.getTripId()).collect(Collectors.toList());
			}
			List<TripDetailsDao> upcomingTripDetailsList = homepageRepository.getAllUpcomingTrips(driverId,
					ongoingTripIds);

			List<TripDetailsDao> tripDetailsList = new ArrayList<>();
			tripDetailsList.addAll(upcomingTripDetailsList);
			tripDetailsList.addAll(ongoingTripDetailsList);

			if (tripDetailsList != null && !tripDetailsList.isEmpty()) {
				List<String> deviceIds = tripDetailsList.stream()
						.filter(trip -> trip.getDeviceId() != null && !trip.getDeviceId().isEmpty())
						.map(TripDetailsDao::getDeviceId).collect(Collectors.toList());

				Map<String, CurrentDataDao> currentDataMap = homepageRepository.getCurrentData(deviceIds);

				tripDetailsList.forEach(trip -> {
					if (currentDataMap.containsKey(trip.getDeviceId())) {
						CurrentDataDao currentDataDao = currentDataMap.get(trip.getDeviceId());
						trip.setLiveLocation(currentDataDao.getLocation());
						trip.setCurrentSoc(currentDataDao.getSoc());
//						trip.setCoveredDistance(null);
					}
				});

				List<TripDetailsDao> tripDetailsDaoList = homepageRepository.getAllTripsDetails(driverId);
				if (tripDetailsDaoList != null && !tripDetailsDaoList.isEmpty()) {
					tripDetailsList.forEach(trip -> {
						Double lastDistanceCoveredRecord = 0d;
						Double currentDistanceCovered = 0d;
						if (currentDataMap.containsKey(trip.getDeviceId())) {
							CurrentDataDao currentDataDao = currentDataMap.get(trip.getDeviceId());
							trip.setLiveLocation(currentDataDao.getLocation());
							trip.setCurrentSoc(currentDataDao.getSoc());
							currentDistanceCovered = currentDataDao.getOdometer();
//							trip.setCoveredDistance(null);
						}

						for (TripDetailsDao td : tripDetailsDaoList) {
							if (trip.getTripId().intValue() == td.getTripId().intValue()) {
								lastDistanceCoveredRecord = td.getCoveredDistance();
							}
						}
						trip.setCoveredDistance(Double.valueOf(
								DecimalFormatterUtil.format(currentDistanceCovered - lastDistanceCoveredRecord)));

					});
				}

			} else {
				tripDetailsList = new ArrayList<>();
				tripDetailsList.add(new TripDetailsDao());
			}

			return tripDetailsList;
		} catch (EvServiceException e) {
			throw new EvServiceException(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(EvLoggerConstants.EXCEPTION, e.getMessage());
			e.printStackTrace();
			throw new EvServiceException(e.getMessage());
		}
	}

	@Override
	public String updateTripStatus(@Valid TripStatusRequestModel tripStatusRequestModel) throws EvServiceException {
		String status = null;
		try {
			if (tripStatusRequestModel.getDriverId() == null)
				throw new EvServiceException("Driver not registered");

//			pushTripDataToMqtt(tripStatusRequestModel);

			TripDetailsDao tripDetailsDao = homepageRepository.tripDetails(tripStatusRequestModel.getTripId(),
					tripStatusRequestModel.getDriverId());
			if (tripDetailsDao == null)
				throw new EvServiceException("Trip does not exist");
			boolean tripStatusExist = homepageRepository.getTripStatus(tripStatusRequestModel.getTripId(),
					tripStatusRequestModel.getDriverId());

			// INSERT/UPDATE RECORD
			if (tripStatusExist)
				homepageRepository.updateTripStatus(tripDetailsDao, tripStatusRequestModel.getTripStatus());
			else
				homepageRepository.insertTripStatus(tripDetailsDao, tripStatusRequestModel.getTripStatus());

			if (tripStatusRequestModel.getTripStatus() != null
					&& tripStatusRequestModel.getTripStatus().equals("ONGOING")) {
				CurrentDataDao currentDataDao = homepageRepository.getCurrentData(tripDetailsDao.getDeviceId());
				homepageRepository.saveTripData(tripDetailsDao, tripStatusRequestModel.getTripStatus(), currentDataDao);
			} else if (tripStatusRequestModel.getTripStatus() != null
					&& tripStatusRequestModel.getTripStatus().equals("COMPLETED")) {
				CurrentDataDao currentDataDao = homepageRepository.getCurrentData(tripDetailsDao.getDeviceId());
				homepageRepository.updateTripData(tripDetailsDao, tripStatusRequestModel.getTripStatus(),
						currentDataDao);
			}

			tripStatusRequestModel.setVehicleId(tripDetailsDao.getVehicleId());
			pushTripDataToMqtt(tripStatusRequestModel);

			status = "Trip data has been saved.";
			return status;
		} catch (EvServiceException e) {
			throw new EvServiceException(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(EvLoggerConstants.EXCEPTION, e.getMessage());
			e.printStackTrace();
			throw new EvServiceException(e.getMessage());
		}
	}

	private void pushTripDataToMqtt(@Valid TripStatusRequestModel tripStatusRequestModel) {
		try {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("tripId", tripStatusRequestModel.getTripId());
			jsonObject.put("driverId", tripStatusRequestModel.getDriverId());
			jsonObject.put("tripStatus", tripStatusRequestModel.getTripStatus());
			jsonObject.put("vehicleId", tripStatusRequestModel.getVehicleId());

			publishSubscriber.sendData(jsonObject.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<TripLogsDao> getTripLogs(TripLogRequestModel tripLogRequestModel) throws EvServiceException {
		List<TripLogsDao> tripLogs = null;
		try {
			if (tripLogRequestModel.getDriverId() == null)
				throw new EvServiceException("Driver not registered");

			TripUtil.getStartAndEndTimeForTripLogs(tripLogRequestModel);
			if (tripLogRequestModel.getFromTime() != null && !tripLogRequestModel.getFromTime().isEmpty()
					&& tripLogRequestModel.getToTime() != null && !tripLogRequestModel.getToTime().isEmpty()) {
				tripLogs = tripManagementRepository.getTripLogs(tripLogRequestModel);
				if (tripLogs != null && !tripLogs.isEmpty()) {
					int numOfTripsCompleted = tripLogs.size();
					tripLogs.forEach(tp -> {
						tp.setNumOfTripsCompleted(numOfTripsCompleted);
					});
				}
			}

			if (tripLogs == null || tripLogs.isEmpty()) {
				tripLogs = new ArrayList<>();
				tripLogs.add(new TripLogsDao());
			}

			return tripLogs;
		} catch (EvServiceException e) {
			throw new EvServiceException(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(EvLoggerConstants.EXCEPTION, e.getMessage());
			e.printStackTrace();
			throw new EvServiceException(e.getMessage());
		}
	}

	@Override
	public TripSummaryDao getTripSummary(Integer driverId) throws EvServiceException {
		try {
			if (driverId == null)
				throw new EvServiceException("Driver not registered");
			String checkedInDuration = "";

			AttendanceData attendanceData = attendanceDataRepository.findTodayAttendanceByDriverId(driverId);
			if (attendanceData != null && attendanceData.getStartTime() != null) {
				long milliSecondsInHours = DateTimeUtil.getDifferenceBetweenTwoDatesInSeconds(
						attendanceData.getStartTime(), DateTimeUtil.getCurrentDateInISTTimezone());

				checkedInDuration = DateTimeUtil.parseText(new Date(milliSecondsInHours), "HH:mm.ss");
				checkedInDuration = !checkedInDuration.isEmpty() ? checkedInDuration + " Hrs" : "0 Hrs";
			}

			return homepageRepository.getTripsKpiDetails(driverId, checkedInDuration);
		} catch (EvServiceException e) {
			throw new EvServiceException(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(EvLoggerConstants.EXCEPTION, e.getMessage());
			e.printStackTrace();
			throw new EvServiceException(e.getMessage());
		}
	}

}
