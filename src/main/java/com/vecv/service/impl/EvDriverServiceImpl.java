package com.vecv.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vecv.core.EvLoggerConstants;
import com.vecv.core.exception.EvServiceException;
import com.vecv.dao.ComplaintDetailsDao;
import com.vecv.dao.TripDetailsDao;
import com.vecv.model.driver.ReportingTimeModel;
import com.vecv.repository.DriverRepository;
import com.vecv.repository.HelpPageRepository;
import com.vecv.repository.HomepageRepository;
import com.vecv.service.EvDriverService;

@Service
public class EvDriverServiceImpl implements EvDriverService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EvDriverServiceImpl.class);

	@Autowired
	private HelpPageRepository helpPageRepository;
	@Autowired
	private DriverRepository driverRepository;
	@Autowired
	private HomepageRepository homepageRepository;

	@Override
	public String submitComplaintDetails(@Valid ComplaintDetailsDao complaintDetailsDao) throws EvServiceException {
		String status = null;
		try {
			if (complaintDetailsDao.getDriverId() == null)
				throw new EvServiceException("Driver not registered");

			int saveStatus = helpPageRepository.saveComplaintDetails(complaintDetailsDao);
			if (saveStatus > 0)
				status = "Complaint has been submitted successfully";

			return status;
		} catch (EvServiceException e) {
			throw new EvServiceException(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(EvLoggerConstants.EXCEPTION, e.getMessage());
			e.printStackTrace();
			throw new EvServiceException(e.getMessage());
		}
	}

	@Override
	public String saveReportingTime(ReportingTimeModel reportingTimeModel) throws EvServiceException {
		String status = null;
		try {
			if (reportingTimeModel.getDriverId() == null)
				throw new EvServiceException("Driver not registered");

			int saveStatus = driverRepository.saveReportingTime(reportingTimeModel);
			if (saveStatus > 0)
				status = "Reporting time has been saved successfully";

			return status;
		} catch (EvServiceException e) {
			throw new EvServiceException(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(EvLoggerConstants.EXCEPTION, e.getMessage());
			e.printStackTrace();
			throw new EvServiceException(e.getMessage());
		}
	}

	@Override
	public ReportingTimeModel getReportingTime(Integer driverId) throws EvServiceException {
		ReportingTimeModel reportingTimeModel = new ReportingTimeModel();
		try {
			if (driverId == null)
				throw new EvServiceException("Driver not registered");

			reportingTimeModel = driverRepository.getReportingTime(driverId);

			return reportingTimeModel;
		} catch (EvServiceException e) {
			throw new EvServiceException(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(EvLoggerConstants.EXCEPTION, e.getMessage());
			e.printStackTrace();
			throw new EvServiceException(e.getMessage());
		}
	}

	@Override
	public Map<String, Object> getLeaveInfo(Integer driverId) throws EvServiceException {
		try {
			if (driverId == null)
				throw new EvServiceException("Driver not registered");

			Map<String, Object> leaveInfo = new HashMap<>();
			// Default values
			leaveInfo.put("driverId", driverId);
			leaveInfo.put("onLeave", false);

			List<TripDetailsDao> allTrips = homepageRepository.getAllTrips(driverId);
			if (allTrips == null || allTrips.isEmpty()) {
				leaveInfo.put("onLeave", true);
			}

			return leaveInfo;
		} catch (EvServiceException e) {
			throw new EvServiceException(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(EvLoggerConstants.EXCEPTION, e.getMessage());
			e.printStackTrace();
			throw new EvServiceException(e.getMessage());
		}
	}

}
