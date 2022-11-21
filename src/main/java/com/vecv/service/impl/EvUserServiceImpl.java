package com.vecv.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vecv.core.EvConstants.LOGIN_TYPE;
import com.vecv.core.EvConstants.ROLE_TYPE;
import com.vecv.core.EvLoggerConstants;
import com.vecv.core.exception.EvServiceException;
import com.vecv.dao.CurrentDataDao;
import com.vecv.dao.TripDetailsDao;
import com.vecv.entity.AttendanceData;
import com.vecv.entity.ChecklistData;
import com.vecv.entity.ChecklistDetails;
import com.vecv.entity.DriverDetails;
import com.vecv.entity.TripDetails;
import com.vecv.entity.UserDetails;
import com.vecv.entity.VehicleDetails;
import com.vecv.model.auth.UserLoginRequestModel;
import com.vecv.model.driver.ReportingTimeModel;
import com.vecv.model.user.AttendanceLogModel;
import com.vecv.model.user.AttendanceModel;
import com.vecv.model.user.ChecklistModel;
import com.vecv.model.user.UserAttendanceModel;
import com.vecv.model.user.UserChecklistModel;
import com.vecv.model.user.UserProfileModel;
import com.vecv.repository.EvAttendanceDataRepository;
import com.vecv.repository.EvChecklistDataRepository;
import com.vecv.repository.EvChecklistDetailsRepository;
import com.vecv.repository.EvDriverDetailsRepository;
import com.vecv.repository.EvTripDetailsRepository;
import com.vecv.repository.EvUserRepository;
import com.vecv.repository.EvVehicleDetailsRepository;
import com.vecv.repository.HomepageRepository;
import com.vecv.service.EvDriverService;
import com.vecv.service.EvUserService;
import com.vecv.service.util.DateTimeUtil;
import com.vecv.service.util.UserUtil;

@Service
public class EvUserServiceImpl implements EvUserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EvUserServiceImpl.class);
	private static final Integer DEFAULT_OTP = 1234;

	@Autowired
	private EvUserRepository userRepository;
	@Autowired
	private EvDriverDetailsRepository driverDetailsRepository;
	@Autowired
	private EvAttendanceDataRepository attendanceDataRepository;
	@Autowired
	private EvTripDetailsRepository tripDetailsRepository;
	@Autowired
	private EvVehicleDetailsRepository vehicleDetailsRepository;
	@Autowired
	private EvChecklistDetailsRepository checklistDetailsRepository;
	@Autowired
	private EvChecklistDataRepository checklistDataRepository;
	@Autowired
	private HomepageRepository homepageRepository;
	@Autowired
	private EvDriverService driverService;

	@Override
	public Map<String, Object> userLogin(UserLoginRequestModel loginRequestModel) throws EvServiceException {
		boolean status = false;
		LOGGER.info("Started logging in: {}", loginRequestModel);
		try {
			if (loginRequestModel.getPhoneNumber() == null)
				throw new EvServiceException("Phone number not found");

			UserDetails userDetails = userRepository.findByPhoneNumber(loginRequestModel.getPhoneNumber());
			if (userDetails == null)
				throw new EvServiceException("User does not found");

			if (loginRequestModel.getLoginType().equals(LOGIN_TYPE.WITH_PASSWORD.name())) {
				LOGGER.info("Match password");
				status = UserUtil.matchPassword(loginRequestModel.getPassword(), userDetails.getPassword());
			} else if (loginRequestModel.getLoginType().equals(LOGIN_TYPE.WITH_OTP.name())) {
				LOGGER.info("Match OTP");
				status = UserUtil.matchOtp(loginRequestModel.getOtp(), userDetails.getOtp());
			}

			if (status)
				LOGGER.info("Logged in successfully");
			else
				throw new EvServiceException("Failed to login. Please check password/OTP.");

			DriverDetails driverDetails = driverDetailsRepository.findByDriverId(userDetails.getDriverId());
			if (driverDetails == null)
				throw new EvServiceException("Driver not found");

			Map<String, Object> result = new HashMap<>();
			result.put("status", status);
//			result.put("user_name", "Kulwinder Singh");
//			result.put("user_name", userDetails.getUserName());
			result.put("user_name", driverDetails.getName() != null ? driverDetails.getName() : "");

			return result;
		} catch (EvServiceException e) {
			throw new EvServiceException(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(EvLoggerConstants.EXCEPTION, e.getMessage());
			e.printStackTrace();
			throw new EvServiceException(e.getMessage());
		}
	}

	@Override
	public Map<String, Integer> generateOtp(String phoneNumber) throws EvServiceException {
		Integer otp = null;
		try {
			if (phoneNumber == null)
				throw new EvServiceException("Phone number not found");

			UserDetails userDetails = userRepository.findByPhoneNumber(phoneNumber);
			if (userDetails == null)
				throw new EvServiceException("User does not found");

//			otp = Integer.parseInt(GenerateRandomStringUtil.generateRandomStringInteger(4));
			otp = DEFAULT_OTP;

			UserDetails userDetailsCopy = userDetails;
			userDetailsCopy.setOtp(otp);
			userRepository.save(userDetailsCopy);
			LOGGER.info("OTP has been saved to DB");

			Map<String, Integer> result = new HashMap<>();
			result.put("otp", otp);

			return result;
		} catch (EvServiceException e) {
			throw new EvServiceException(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(EvLoggerConstants.EXCEPTION, e.getMessage());
			e.printStackTrace();
			throw new EvServiceException(e.getMessage());
		}
	}

	@Override
	public UserProfileModel getUserProfile(@Valid String phoneNumber) throws EvServiceException {
		LOGGER.info("Started getting user profile for phone number: {}", phoneNumber);
		try {
			if (phoneNumber == null)
				throw new EvServiceException("Phone number not found");

			UserDetails userDetails = userRepository.findByPhoneNumber(phoneNumber);
			if (userDetails == null)
				throw new EvServiceException("User does not found");

			DriverDetails driverDetails = driverDetailsRepository.findByDriverId(userDetails.getDriverId());

			AttendanceData attendanceData = attendanceDataRepository
					.findTodayAttendanceByDriverId(userDetails.getDriverId());

			ReportingTimeModel reportingTimeModel = driverService.getReportingTime(userDetails.getDriverId());

			LOGGER.info("user found: {}", userDetails);
//			return UserUtil.getDefaultUserProfileModel(phoneNumber);
			return UserUtil.getUserProfileModel(userDetails, driverDetails, attendanceData, reportingTimeModel);
		} catch (EvServiceException e) {
			throw new EvServiceException(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(EvLoggerConstants.EXCEPTION, e.getMessage());
			e.printStackTrace();
			throw new EvServiceException(e.getMessage());
		}
	}

	@Override
	public String markAttendance(Integer driverId, @Valid AttendanceModel attendanceModel) throws EvServiceException {
		LOGGER.info("Started marking user attendance for driverId id: {}", driverId);
		try {
			if (driverId == null)
				throw new EvServiceException("User not found");

			DriverDetails driverDetails = driverDetailsRepository.findByDriverId(driverId);
			if (driverDetails == null)
				throw new EvServiceException("Driver not found");

			AttendanceData attendanceData = attendanceDataRepository.findTodayAttendanceByDriverId(driverId);
			if (attendanceData == null) {
				LOGGER.info("It is checking in");
				String day = DateTimeUtil.getCurrentDayName();

				attendanceData = new AttendanceData();
				attendanceData.setDriverId(driverId);
				attendanceData.setDate(new Date());
				attendanceData.setDay(day);
				attendanceData.setStartLocation(attendanceModel.getCheckedInLocation());
				attendanceData.setStartTime(new Date());
				attendanceData.setCheckedin(true);
				attendanceData.setLatitude(attendanceModel.getLatitude());
				attendanceData.setLongitude(attendanceModel.getLongitude());

				attendanceDataRepository.save(attendanceData);
			} else if (attendanceData.getStartTime() != null && attendanceData.getEndTime() == null) {
				LOGGER.info("It is checking out");

				AttendanceData attendanceDataCopy = attendanceData;
				attendanceDataCopy.setEndLocation(attendanceModel.getCheckedOutLocation());
				attendanceDataCopy.setEndTime(new Date());
				attendanceDataCopy.setUpdatedTimestamp(new Date());
				attendanceDataCopy.setCheckedin(true);
				attendanceDataCopy.setLatitude(attendanceModel.getLatitude());
				attendanceDataCopy.setLongitude(attendanceModel.getLongitude());

				attendanceDataRepository.save(attendanceData);
			} else {
				LOGGER.error("Today's attendance is already done");
				return "Today's attendance is already done";
			}

			LOGGER.info("Attendance has been noted and saved.");
			return "Attendance has been marked.";
		} catch (EvServiceException e) {
			throw new EvServiceException(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(EvLoggerConstants.EXCEPTION, e.getMessage());
			e.printStackTrace();
			throw new EvServiceException(e.getMessage());
		}
	}

	@Override
	public UserAttendanceModel getAttendanceList(Integer driverId) throws EvServiceException {
		LOGGER.info("Started getting user attendance list for user id: {}", driverId);
		try {
			if (driverId == null)
				throw new EvServiceException("User not found");

			DriverDetails driverDetails = driverDetailsRepository.findByDriverId(driverId);
			if (driverDetails == null)
				throw new EvServiceException("Driver not found");

			UserAttendanceModel userAttendanceModel = new UserAttendanceModel();
			userAttendanceModel.setUserId(driverDetails.getId());
			userAttendanceModel.setUserName(driverDetails.getName());
			userAttendanceModel.setRole(ROLE_TYPE.PILOT.name());

			List<AttendanceData> attendanceDataList = attendanceDataRepository.findAllAttendanceByDriverId(driverId);
			if (attendanceDataList == null || attendanceDataList.isEmpty()) {
				List<AttendanceModel> list = new ArrayList<>();
				list.add(new AttendanceModel());
				userAttendanceModel.setAttendanceList(list);
			} else {
				userAttendanceModel.setAttendanceList(UserUtil.getAttendanceList(driverDetails, attendanceDataList));
			}
			LOGGER.info("Attendance has been retrieved");

			return userAttendanceModel;
		} catch (EvServiceException e) {
			throw new EvServiceException(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(EvLoggerConstants.EXCEPTION, e.getMessage());
			e.printStackTrace();
			throw new EvServiceException(e.getMessage());
		}
	}

	@Override
	public String saveChecklist(Integer driverId, List<ChecklistModel> checklistModelList) throws EvServiceException {
		LOGGER.info("Started saving checklist for driver id: {}", driverId);
		try {
			if (driverId == null)
				throw new EvServiceException("User not found");
			DriverDetails driverDetails = driverDetailsRepository.findByDriverId(driverId);
			if (driverDetails == null)
				throw new EvServiceException("Driver not found");

			UserDetails userDetails = userRepository.findByDriverId(driverId);

//			AttendanceData attendanceData = attendanceDataRepository.findTodayAttendanceByDriverId(driverId);
//			if (attendanceData != null && attendanceData.getCheckedin() != null
//					&& attendanceData.getCheckedin().booleanValue()) {
//				throw new EvServiceException("It is already checked in");
//			}
			if (checklistModelList != null && !checklistModelList.isEmpty()) {
				List<ChecklistData> checklistDataList = new ArrayList<>();
				List<TripDetails> tripDetailsList = new ArrayList<>();
				checklistModelList.forEach(checklistModel -> {
					if (!checklistModel.isStatus()) {
						ChecklistData checklistData = new ChecklistData();
						checklistData.setChecklistName(checklistModel.getName());
						checklistData.setDate(new Date());
						checklistData.setDescription(checklistModel.getDescription());
						checklistData.setDriverId(driverId);
						checklistData.setStatus(false);

						TripDetails tripDetails = tripDetailsRepository.findUpcomingTripByDriverId(driverId);
						if (tripDetails != null) {
							checklistData.setTripId(tripDetails.getId());
							checklistData.setVehicleId(tripDetails.getVehicleId());

							TripDetails tripDetailsCopy = tripDetails;
							tripDetailsCopy.setCheckedIn(true);
							tripDetailsCopy.setUpdatedTimestamp(new Date());
							tripDetailsList.add(tripDetailsCopy);
						}
						if (userDetails != null)
							checklistData.setUserId(userDetails.getId());

						checklistData.setCreatedTimestamp(new Date());
						checklistData.setUpdatedTimestamp(new Date());

						checklistDataList.add(checklistData);
					}
				});
				checklistDataRepository.saveAll(checklistDataList);
				if (!tripDetailsList.isEmpty()) {
					tripDetailsRepository.saveAll(tripDetailsList);
				}

//				attendanceData.setCheckedin(true);
//				attendanceData.setUpdatedTimestamp(new Date());
//				attendanceDataRepository.save(attendanceData);
			}

			return "";
		} catch (EvServiceException e) {
			throw new EvServiceException(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(EvLoggerConstants.EXCEPTION, e.getMessage());
			e.printStackTrace();
			throw new EvServiceException(e.getMessage());
		}
	}

	@Override
	public UserChecklistModel getChecklist(Integer driverId) throws EvServiceException {
		LOGGER.info("Started getting user checklist for driverId id: {}", driverId);
		UserChecklistModel userChecklistModel = new UserChecklistModel();
		try {
			if (driverId == null)
				throw new EvServiceException("User not found");
			DriverDetails driverDetails = driverDetailsRepository.findByDriverId(driverId);
			if (driverDetails == null)
				throw new EvServiceException("Driver not found");

			UserDetails userDetails = userRepository.findByDriverId(driverDetails.getId());
			if (userDetails != null)
				userChecklistModel.setUserId(userDetails.getId());

			userChecklistModel.setDriverId(driverDetails.getId());
			userChecklistModel.setUserName(driverDetails.getName());
			userChecklistModel.setStartOdometer(0d);
			userChecklistModel.setEndOdometer("");

			List<ChecklistDetails> checklistDetails = checklistDetailsRepository.findAll();
			userChecklistModel.setChecklist(UserUtil.getChecklist(checklistDetails));

			TripDetails tripDetails = tripDetailsRepository.findUpcomingTripByDriverId(driverId);
			if (tripDetails != null) {
				VehicleDetails vehicleDetails = vehicleDetailsRepository.findByVehicleId(tripDetails.getVehicleId());
				if (vehicleDetails != null)
					userChecklistModel.setVehicleNumber(vehicleDetails.getRegNo());

				List<ChecklistData> checklistDataList = checklistDataRepository.findByTripId(tripDetails.getId());
				if (checklistDataList != null && !checklistDataList.isEmpty()) {
					userChecklistModel.setChecklist(UserUtil.getChecklist(checklistDetails, checklistDataList));
				}
			}

			Double odometer = null;
			List<TripDetailsDao> allTrips = homepageRepository.getAllTrips(driverDetails.getId());
			if (allTrips != null && !allTrips.isEmpty()) {
				CurrentDataDao currentData = homepageRepository.getCurrentData(allTrips.get(0).getDeviceId());
				if (currentData != null) {
					odometer = currentData.getOdometer();
					userChecklistModel.setStartOdometer(odometer);
				}
			}

			LOGGER.info("User's checklist have been retrieved");
			return userChecklistModel;
		} catch (EvServiceException e) {
			throw new EvServiceException(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(EvLoggerConstants.EXCEPTION, e.getMessage());
			e.printStackTrace();
			throw new EvServiceException(e.getMessage());
		}
	}

	@Override
	public List<AttendanceLogModel> getAttendanceLogs(Integer driverId) throws EvServiceException {
		LOGGER.info("Started getting attendance logs for driverId id: {}", driverId);
		try {
			if (driverId == null)
				throw new EvServiceException("User not found");
			DriverDetails driverDetails = driverDetailsRepository.findByDriverId(driverId);
			if (driverDetails == null)
				throw new EvServiceException("Driver not found");

			Map<String, Boolean> attendanceLogs = UserUtil.getAttendanceLogsMonthlyTillCurrentDate();
			Map<String, Boolean> logs = homepageRepository.getAttendanceLogs(driverId, attendanceLogs);

			Map<String, Boolean> map = new TreeMap<>(logs);
			List<AttendanceLogModel> logList = new ArrayList<>();
			map.forEach((date, status) -> {
				logList.add(new AttendanceLogModel(date, status));
			});

//			return logs.values().stream().collect(Collectors.toList());
//			attendanceLogs.stre

//			List<AttendanceLogModel> attendanceLogList = homepageRepository.getAttendanceLogs(driverId);

			return logList;
		} catch (EvServiceException e) {
			throw new EvServiceException(e.getMessage());
		} catch (Exception e) {
			LOGGER.error(EvLoggerConstants.EXCEPTION, e.getMessage());
			e.printStackTrace();
			throw new EvServiceException(e.getMessage());
		}
	}

}
