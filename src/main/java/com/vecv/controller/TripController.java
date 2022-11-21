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
import com.vecv.model.EvResponse;
import com.vecv.model.EvResponseEntity;
import com.vecv.model.EvStatus;
import com.vecv.model.trip.TripLogRequestModel;
import com.vecv.model.trip.TripStatusRequestModel;
import com.vecv.service.EvTripService;

@Validated
@RequestMapping("/trip")
@RestController
public class TripController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TripController.class);

	@Autowired
	private EvTripService tripService;

	@GetMapping("/upcoming")
	public EvResponseEntity<EvResponse> upcomingTrip(
			@Valid @RequestParam(value = "userId", required = true) Integer userId) {
		EvResponse evResponse = new EvResponse();
		try {
			evResponse.setResponseData(tripService.upcomingTrip(userId));
			evResponse.setStatusInfo("Upcoming trip details has been retrieved successfully");
			return new EvResponseEntity<>(evResponse, HttpStatus.OK);
		} catch (EvServiceException e) {
			evResponse = getExceptionResponseObject(e);
			return new EvResponseEntity<>(evResponse, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/homepage")
	public EvResponseEntity<EvResponse> getScoreDetails(
			@Valid @RequestParam(value = "driverId", required = true) Integer driverId) {
		EvResponse evResponse = new EvResponse();
		try {
			evResponse.setResponseData(tripService.getHomePageDetails(driverId));
			evResponse.setStatusInfo("Upcoming trip details has been retrieved successfully");
			return new EvResponseEntity<>(evResponse, HttpStatus.OK);
		} catch (EvServiceException e) {
			evResponse = getExceptionResponseObject(e);
			return new EvResponseEntity<>(evResponse, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/allTrips")
	public EvResponseEntity<EvResponse> getAllTrips(
			@Valid @RequestParam(value = "driverId", required = true) Integer driverId) {
		EvResponse evResponse = new EvResponse();
		try {
			evResponse.setResponseData(tripService.getAllTrips(driverId));
			return new EvResponseEntity<>(evResponse, HttpStatus.OK);
		} catch (EvServiceException e) {
			evResponse = getExceptionResponseObject(e);
			return new EvResponseEntity<>(evResponse, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PostMapping("/tripLog")
	public EvResponseEntity<EvResponse> getTripLogs(@Valid @RequestBody TripLogRequestModel tripLogRequestModel) {
		EvResponse evResponse = new EvResponse();
		try {
			evResponse.setResponseData(tripService.getTripLogs(tripLogRequestModel));
			evResponse.setStatusInfo("Trip logs have been retrieved successfully");
			return new EvResponseEntity<>(evResponse, HttpStatus.OK);
		} catch (EvServiceException e) {
			evResponse = getExceptionResponseObject(e);
			return new EvResponseEntity<>(evResponse, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PostMapping("/tripStatus")
	public EvResponseEntity<EvResponse> updateTripStatus(
			@Valid @RequestBody TripStatusRequestModel tripStatusRequestModel) {
		EvResponse evResponse = new EvResponse();
		try {
			evResponse.setResponseData(tripService.updateTripStatus(tripStatusRequestModel));
			evResponse.setStatusInfo("Upcoming trip details has been retrieved successfully");
			return new EvResponseEntity<>(evResponse, HttpStatus.OK);
		} catch (EvServiceException e) {
			evResponse = getExceptionResponseObject(e);
			return new EvResponseEntity<>(evResponse, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/tripSummary")
	public EvResponseEntity<EvResponse> getTripSummary(
			@Valid @RequestParam(value = "driverId", required = true) Integer driverId) {
		LOGGER.info("Started retrieving trip summary for driver Id: {}", driverId);
		EvResponse evResponse = new EvResponse();
		try {
			evResponse.setResponseData(tripService.getTripSummary(driverId));
			evResponse.setStatusInfo("Trip summary has been retrieved successfully");
			LOGGER.info("Completed retrieving trip summary for driver Id: {}", driverId);
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
