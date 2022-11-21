package com.vecv.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vecv.core.EvLoggerConstants;
import com.vecv.core.exception.EvServiceException;
import com.vecv.dao.CurrentDataDao;
import com.vecv.dao.RouteDetailsDao;
import com.vecv.dao.StoppageDetails;
import com.vecv.dao.TripDetailsDao;
import com.vecv.dao.VehicleLiveDetailsDao;
import com.vecv.entity.AttendanceData;
import com.vecv.repository.EvAttendanceDataRepository;
import com.vecv.repository.HomepageRepository;
import com.vecv.repository.RouteDetailsRepository;
import com.vecv.service.EvRouteService;
import com.vecv.service.util.DateTimeUtil;

@Service
public class EvRouteServiceImpl implements EvRouteService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EvRouteServiceImpl.class);

	@Autowired
	private RouteDetailsRepository routeDetailsRepository;
	@Autowired
	private EvAttendanceDataRepository attendanceDataRepository;
	@Autowired
	private HomepageRepository homepageRepository;

	@Override
	public RouteDetailsDao getRouteDetails(Integer driverId, Integer tripId) throws EvServiceException {
		try {
			if (driverId == null)
				throw new EvServiceException("Driver not registered");

			RouteDetailsDao routeDetailsDao = routeDetailsRepository.getRouteDetails(tripId, driverId);
			if (routeDetailsDao != null) {
				List<StoppageDetails> routeStoppageList = routeDetailsRepository.getRouteStoppageDetails(
						routeDetailsDao.getRouteId(), routeDetailsDao.getRouteName(), routeDetailsDao.getStartTime());
				if (routeStoppageList != null && !routeStoppageList.isEmpty()) {
					routeDetailsDao.setStoppageList(routeStoppageList);
				} else {
					List<StoppageDetails> stoppageList = routeDetailsDao.getStoppageList();
					stoppageList = new ArrayList<>();
					stoppageList.add(new StoppageDetails("", "", "", "", ""));
					stoppageList.add(new StoppageDetails("", "", "", "", ""));
					stoppageList.add(new StoppageDetails("", "", "", "", ""));
					routeDetailsDao.setStoppageList(stoppageList);
				}
			}

			return routeDetailsDao;
		} catch (EvServiceException e) {
			throw new EvServiceException(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(EvLoggerConstants.EXCEPTION, e.getMessage());
			e.printStackTrace();
			throw new EvServiceException(e.getMessage());
		}
	}

	@Override
	public VehicleLiveDetailsDao getVehicleLiveDetails(Integer driverId, Integer tripId, Integer vehicleId)
			throws EvServiceException {
		try {
			if (driverId == null)
				throw new EvServiceException("Driver not registered");

			String checkedInDuration = "";
			AttendanceData attendanceData = attendanceDataRepository.findTodayAttendanceByDriverId(driverId);
			if (attendanceData != null && attendanceData.getStartTime() != null) {
//				checkedInDuration = DateTimeUtil.formatElapsedTimeInHoursMinuteSeconds(
//						DateTimeUtil.getDifferenceBetweenTwoDatesInSeconds(attendanceData.getStartTime(), new Date()));

				checkedInDuration = DateTimeUtil.formatElapsedTimeInHoursMinuteSeconds(
						DateTimeUtil.getDifferenceBetweenTwoDatesInSeconds(attendanceData.getStartTime(),
								DateTimeUtil.getCurrentDateInISTTimezone()));
			}
			VehicleLiveDetailsDao vehicleLiveDetailsDao = new VehicleLiveDetailsDao(driverId, vehicleId, tripId, null,
					"", "", 0, 0, 0, 100d, "", checkedInDuration);

//			TripDetailsDao tripDetailsDao = homepageRepository.tripDetails(tripId, driverId);
			List<TripDetailsDao> tripDetailsDaoList = homepageRepository.getAllTripsDetails(driverId);

			if (tripDetailsDaoList != null && !tripDetailsDaoList.isEmpty()) {
				Optional<TripDetailsDao> tripDetailsDaoOpt = tripDetailsDaoList.stream()
						.filter(tp -> tp.getTripId().equals(tripId)).findFirst();
				if (tripDetailsDaoOpt.isPresent()) {
					TripDetailsDao tripDetailsDao = tripDetailsDaoOpt.get();

//				TripDetailsDao tripDetailsDao = tripDetailsDaoList.get(0);

					vehicleLiveDetailsDao.setRouteId(vehicleId);
					vehicleLiveDetailsDao.setRouteName(tripDetailsDao.getRouteName());

					CurrentDataDao currentDataDao = homepageRepository.getCurrentData(tripDetailsDao.getDeviceId());
					if (currentDataDao != null) {
						vehicleLiveDetailsDao.setLatitude(currentDataDao.getLatitude());
						vehicleLiveDetailsDao.setLongitude(currentDataDao.getLongitude());
						vehicleLiveDetailsDao.setDistance(tripDetailsDao.getTotalDistance());
						vehicleLiveDetailsDao.setDistanceCovered(0);
						vehicleLiveDetailsDao.setDistanceLeft(0);
						vehicleLiveDetailsDao.setSoc(currentDataDao.getSoc());
						vehicleLiveDetailsDao.setLastStoppageReached(currentDataDao.getLocation());

					}
				}
			}

//			return new VehicleLiveDetailsDao(driverId, vehicleId, tripId, 1, "", "", 0, 0, 0, 100d, "",
//					checkedInDuration);
			return vehicleLiveDetailsDao;
		} catch (EvServiceException e) {
			throw new EvServiceException(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(EvLoggerConstants.EXCEPTION, e.getMessage());
			e.printStackTrace();
			throw new EvServiceException(e.getMessage());
		}
	}
}
