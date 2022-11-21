package com.vecv.controller;

import java.util.List;

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
import com.vecv.model.auth.UserLoginRequestModel;
import com.vecv.model.user.AttendanceModel;
import com.vecv.model.user.ChecklistModel;
import com.vecv.service.EvUserService;

@Validated
@RequestMapping("/user")
@RestController
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private EvUserService userService;

	@PostMapping
	public EvResponseEntity<EvResponse> userLogin(@Valid @RequestBody UserLoginRequestModel loginRequestModel) {
		EvResponse evResponse = new EvResponse();
		try {
			evResponse.setResponseData(userService.userLogin(loginRequestModel));
			evResponse.setStatusInfo("User has been logged in successfully");
			return new EvResponseEntity<>(evResponse, HttpStatus.OK);
		} catch (EvServiceException e) {
			evResponse = getExceptionResponseObject(e);
			return new EvResponseEntity<>(evResponse, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/generateOtp")
	public EvResponseEntity<EvResponse> generateOtp(
			@Valid @RequestParam(value = "phoneNumber", required = true) String phoneNumber) {
		EvResponse evResponse = new EvResponse();
		try {
			evResponse.setResponseData(userService.generateOtp(phoneNumber));
			evResponse.setStatusInfo("User's OTP has been generated successfully");
			return new EvResponseEntity<>(evResponse, HttpStatus.OK);
		} catch (EvServiceException e) {
			evResponse = getExceptionResponseObject(e);
			return new EvResponseEntity<>(evResponse, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping
	public EvResponseEntity<EvResponse> getUserProfile(
			@Valid @RequestParam(value = "phoneNumber", required = true) String phoneNumber) {
		EvResponse evResponse = new EvResponse();
		try {
			evResponse.setResponseData(userService.getUserProfile(phoneNumber));
			evResponse.setStatusInfo("User profile has been retrieved successfully");
			return new EvResponseEntity<>(evResponse, HttpStatus.OK);
		} catch (EvServiceException e) {
			evResponse = getExceptionResponseObject(e);
			return new EvResponseEntity<>(evResponse, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PostMapping("/attendance")
	public EvResponseEntity<EvResponse> markAttendance(@RequestParam(value = "userId", required = true) Integer userId,
			@Valid @RequestBody AttendanceModel attendanceModel) {
		EvResponse evResponse = new EvResponse();
		try {
			evResponse.setStatusInfo(userService.markAttendance(userId, attendanceModel));
			return new EvResponseEntity<>(evResponse, HttpStatus.OK);
		} catch (EvServiceException e) {
			evResponse = getExceptionResponseObject(e);
			return new EvResponseEntity<>(evResponse, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/attendance")
	public EvResponseEntity<EvResponse> getAttendanceList(
			@RequestParam(value = "userId", required = true) Integer userId) {
		EvResponse evResponse = new EvResponse();
		try {
			evResponse.setResponseData(userService.getAttendanceList(userId));
			evResponse.setStatusInfo("User attendance have been retrieved successfully");
			return new EvResponseEntity<>(evResponse, HttpStatus.OK);
		} catch (EvServiceException e) {
			evResponse = getExceptionResponseObject(e);
			return new EvResponseEntity<>(evResponse, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/attendanceLog")
	public EvResponseEntity<EvResponse> getAttendanceLogs(
			@RequestParam(value = "driverId", required = true) Integer driverId) {
		EvResponse evResponse = new EvResponse();
		try {
			LOGGER.info("Started getting attendance logs for driverId id: {}", driverId);
			evResponse.setResponseData(userService.getAttendanceLogs(driverId));
			evResponse.setStatusInfo("Attendance logs have been retrieved successfully");

			LOGGER.info("Completed getting attendance logs for driverId id: {}", driverId);
			return new EvResponseEntity<>(evResponse, HttpStatus.OK);
		} catch (EvServiceException e) {
			evResponse = getExceptionResponseObject(e);
			return new EvResponseEntity<>(evResponse, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PostMapping("/checklist")
	public EvResponseEntity<EvResponse> saveChecklist(@RequestParam(value = "userId", required = true) Integer userId,
			@Valid @RequestBody List<ChecklistModel> checklistModelList) {
		EvResponse evResponse = new EvResponse();
		try {
			evResponse.setStatusInfo(userService.saveChecklist(userId, checklistModelList));
			return new EvResponseEntity<>(evResponse, HttpStatus.OK);
		} catch (EvServiceException e) {
			evResponse = getExceptionResponseObject(e);
			return new EvResponseEntity<>(evResponse, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/checklist")
	public EvResponseEntity<EvResponse> getChecklist(@RequestParam(value = "userId", required = true) Integer userId) {
		EvResponse evResponse = new EvResponse();
		try {
			evResponse.setResponseData(userService.getChecklist(userId));
			evResponse.setStatusInfo("Checklist has been retrieved successfully");
			return new EvResponseEntity<>(evResponse, HttpStatus.OK);
		} catch (EvServiceException e) {
			evResponse = getExceptionResponseObject(e);
			return new EvResponseEntity<>(evResponse, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/serviceStatus")
	public String getServiceStatus() {
		LOGGER.info("Running VECV Service...");
		return "Running VECV Service...";
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
