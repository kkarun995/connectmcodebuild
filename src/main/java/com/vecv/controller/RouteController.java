package com.vecv.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vecv.core.exception.EvServiceException;
import com.vecv.model.EvResponse;
import com.vecv.model.EvResponseEntity;
import com.vecv.model.EvStatus;
import com.vecv.service.EvRouteService;

@Validated
@RequestMapping("/route")
@RestController
public class RouteController {
	private static final Logger LOGGER = LoggerFactory.getLogger(RouteController.class);

	@Autowired
	private EvRouteService routeService;

	@GetMapping("/routeDetails")
	public EvResponseEntity<EvResponse> getRouteDetails(
			@RequestParam(value = "driverId", required = true) Integer driverId,
			@RequestParam(value = "tripId", required = true) Integer tripId) {
		EvResponse evResponse = new EvResponse();
		try {
			evResponse.setResponseData(routeService.getRouteDetails(driverId, tripId));
			return new EvResponseEntity<>(evResponse, HttpStatus.OK);
		} catch (EvServiceException e) {
			evResponse = getExceptionResponseObject(e);
			return new EvResponseEntity<>(evResponse, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/vehicleLiveTrack")
	public EvResponseEntity<EvResponse> getVehicleLiveDetails(
			@RequestParam(value = "driverId", required = true) Integer driverId,
			@RequestParam(value = "tripId", required = true) Integer tripId,
			@RequestParam(value = "vehicleId", required = true) Integer vehicleId) {
		EvResponse evResponse = new EvResponse();
		try {
			evResponse.setResponseData(routeService.getVehicleLiveDetails(driverId, tripId, vehicleId));
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
