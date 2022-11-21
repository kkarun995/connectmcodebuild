package com.vecv.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vecv.core.exception.EvServiceException;
import com.vecv.dao.ComplaintDetailsDao;
import com.vecv.model.EvResponse;
import com.vecv.model.EvResponseEntity;
import com.vecv.model.EvStatus;
import com.vecv.model.driver.ReportingTimeModel;
import com.vecv.service.EvDriverService;

@Validated
@RequestMapping("/driver")
@RestController
public class DriverController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DriverController.class);

	@Autowired
	private EvDriverService driverService;

	@PostMapping("/submitComplaint")
	public EvResponseEntity<EvResponse> submitComplaintDetails(
			@Valid @RequestBody ComplaintDetailsDao complaintDetailsDao) {
		EvResponse evResponse = new EvResponse();
		try {
			LOGGER.info("Started submitting complaint for driverId: {}", complaintDetailsDao.getDriverId());
			evResponse.setStatusInfo(driverService.submitComplaintDetails(complaintDetailsDao));
			LOGGER.info("Completed submitting complaint for driverId: {}", complaintDetailsDao.getDriverId());
			return new EvResponseEntity<>(evResponse, HttpStatus.OK);
		} catch (EvServiceException e) {
			evResponse = getExceptionResponseObject(e);
			return new EvResponseEntity<>(evResponse, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PostMapping("/reportTime")
	public EvResponseEntity<EvResponse> saveReportingTime(@Valid @RequestBody ReportingTimeModel reportingTimeModel) {
		EvResponse evResponse = new EvResponse();
		try {
			LOGGER.info("Started saving reporting time for driverId: {}", reportingTimeModel.getDriverId());
			evResponse.setStatusInfo(driverService.saveReportingTime(reportingTimeModel));
			LOGGER.info("Completed saving reporting time for driverId: {}", reportingTimeModel.getDriverId());
			return new EvResponseEntity<>(evResponse, HttpStatus.OK);
		} catch (EvServiceException e) {
			evResponse = getExceptionResponseObject(e);
			return new EvResponseEntity<>(evResponse, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/leaveInfo")
	public EvResponseEntity<EvResponse> getDriverLeaveInfo(
			@Valid @RequestParam(name = "driverId", required = true) Integer driverId) {
		EvResponse evResponse = new EvResponse();
		try {
			LOGGER.info("Started getting leave info for driverId: {}", driverId);
			evResponse.setResponseData(driverService.getLeaveInfo(driverId));
			evResponse.setStatusInfo("Successfully retrieved the leave info");
			LOGGER.info("Completed getting leave info for driverId: {}", driverId);
			return new EvResponseEntity<>(evResponse, HttpStatus.OK);
		} catch (EvServiceException e) {
			evResponse = getExceptionResponseObject(e);
			return new EvResponseEntity<>(evResponse, HttpStatus.EXPECTATION_FAILED);
		}
	}

	/**
	 * this method returns the response of the Exception thrown by the service
	 * 
	 * @param e
	 * @return
	 */
	private EvResponse getExceptionResponseObject(EvServiceException e) {
		LOGGER.error("Exception : {}", e.getMessage());
		LOGGER.error(e.getMessage(), e);
		EvResponse evResponse = new EvResponse();
		EvStatus.setErrorStatusReponse(evResponse, e.getMessage());
		return evResponse;
	}
}
