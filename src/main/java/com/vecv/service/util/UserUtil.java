package com.vecv.service.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.vecv.core.EvConstants.ROLE_TYPE;
import com.vecv.core.EvConstants.USER_GENDER;
import com.vecv.entity.AttendanceData;
import com.vecv.entity.ChecklistData;
import com.vecv.entity.ChecklistDetails;
import com.vecv.entity.DriverDetails;
import com.vecv.entity.UserDetails;
import com.vecv.model.driver.ReportingTimeModel;
import com.vecv.model.user.AttendanceLogModel;
import com.vecv.model.user.AttendanceModel;
import com.vecv.model.user.ChecklistModel;
import com.vecv.model.user.FrontChecklistModel;
import com.vecv.model.user.InsideChecklistModel;
import com.vecv.model.user.RearChecklistModel;
import com.vecv.model.user.UserProfileModel;

public class UserUtil {

	private UserUtil() {
	}

	public static boolean matchPassword(String password, String existingPassword) {
		boolean status = false;
		if (existingPassword.equals(password))
			status = true;

		return status;
	}

	public static boolean matchOtp(Integer receivedOtp, Integer defaultOtp) {
		boolean status = false;
		if (receivedOtp.equals(defaultOtp))
			status = true;

		return status;
	}

	public static UserProfileModel getUserProfileModel(UserDetails userDetails) {
		UserProfileModel userProfileModel = new UserProfileModel();
		userProfileModel.setUserId(userDetails.getId());
		userProfileModel.setUserName(userDetails.getUserName());
		userProfileModel.setPhoneNumber(userDetails.getPhoneNumber());
		userProfileModel.setRole(userDetails.getRole());
		userProfileModel.setGender(userDetails.getGender());
		userProfileModel.setDesignation("");
//		userProfileModel.setAnniversaryDate(DateTimeUtil.  userDetails.getAnniversaryDate());
//		userProfileModel.setDateOfBirth(userDetails.getDob());

		return userProfileModel;
	}

	public static UserProfileModel getUserProfileModel(UserDetails userDetails, DriverDetails driverDetails,
			AttendanceData attendanceData, ReportingTimeModel reportingTimeModel) {
		UserProfileModel userProfileModel = new UserProfileModel();
		userProfileModel.setUserId(driverDetails.getId());
		userProfileModel.setUserName(driverDetails.getName());
		userProfileModel.setPhoneNumber(userDetails.getPhoneNumber());
		userProfileModel.setRole(userDetails.getRole());
		userProfileModel.setGender(userDetails.getGender());
		userProfileModel.setDesignation("");
		userProfileModel.setAnniversaryDate(DateTimeUtil.parseText(driverDetails.getAnniversaryDate(), "yyyy-MM-dd"));
		userProfileModel.setDateOfBirth(DateTimeUtil.parseText(driverDetails.getDob(), "yyyy-MM-dd"));

		if (attendanceData != null) {
			userProfileModel.setCheckedInStatus(true);
			if (attendanceData.getStartTime() != null)
				userProfileModel
						.setCheckedInTime(DateTimeUtil.parseText(attendanceData.getStartTime(), "yyyy-MM-dd HH:mm:ss"));
		}
		if (reportingTimeModel != null) {
			userProfileModel.setIsReported(true);
		}
		userProfileModel.setTagId(driverDetails.getTagId());

		return userProfileModel;
	}

	public static UserProfileModel getDefaultUserProfileModel(String phoneNumber) {
		// Default Profile for testing
		UserProfileModel userProfileModel = new UserProfileModel();
		userProfileModel.setUserId(1);
		userProfileModel.setUserName("Kulwinder Singh");
		userProfileModel.setPhoneNumber(phoneNumber);
		userProfileModel.setRole(ROLE_TYPE.PILOT.name());
		userProfileModel.setGender(USER_GENDER.MALE.getGender());
		userProfileModel.setDesignation("");
		userProfileModel.setAnniversaryDate("20-05-2010");
		userProfileModel.setDateOfBirth("01-03-1990");

		return userProfileModel;
	}

	public static String getDefaultAttendance(AttendanceModel attendanceModel) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void saveAttendance(DriverDetails driverDetails, @Valid AttendanceModel attendanceModel) {
		AttendanceData attendanceData = new AttendanceData();
		attendanceData.setDriverId(null);
		attendanceData.setStartLocation(null);
		attendanceData.setEndLocation(null);
		attendanceData.setStartTime(null);
		attendanceData.setEndTime(null);
		attendanceData.setDate(null);
		attendanceData.setDay(null);

	}

	public static List<AttendanceModel> getDefaultAttendanceModelList(Integer userId) {
		List<AttendanceModel> userAttendanceList = new ArrayList<>();

//		1, "Kulwinder Singh", ROLE_TYPE.PILOT.name()

		userAttendanceList.add(new AttendanceModel("10 Sep, 2022 10:15 PM", "11 Sep, 2022 11:30 AM", "Surat, Gujrat",
				"Mumbai, Maharashtra",
				AttendanceModel.getCheckInDuration("10 Sep, 2022 10:15 PM", "11 Sep, 2022 11:30 AM")));

		userAttendanceList.add(new AttendanceModel("27 Aug, 2022 07:15 AM", "30 Aug, 2022 08:30 PM",
				"Karol Bagh, Delhi", "Bangalore, Karnataka",
				AttendanceModel.getCheckInDuration("27 Aug, 2022 07:15 AM", "30 Aug, 2022 08:30 PM")));

		return userAttendanceList;
	}

	public static List<AttendanceModel> getAttendanceList(DriverDetails driverDetails,
			List<AttendanceData> attendanceList) {
		List<AttendanceModel> userAttendanceList = new ArrayList<>();
		if (attendanceList != null && !attendanceList.isEmpty()) {
			attendanceList.forEach(att -> {
				userAttendanceList.add(new AttendanceModel(
						DateTimeUtil.parseText(att.getStartTime(), "dd MMM, yyyy hh:mm aa"),
						att.getEndTime() != null ? DateTimeUtil.parseText(att.getEndTime(), "dd MMM, yyyy hh:mm aa")
								: "",
						att.getStartLocation(), att.getEndLocation(),
						AttendanceModel.getCheckInDuration(att.getStartTime(), att.getEndTime()), att.getLatitude(),
						att.getLongitude()));
			});
		}
		return userAttendanceList;
	}

	public static InsideChecklistModel getDefaultInsideChecklist() {
		InsideChecklistModel insideChecklistModel = new InsideChecklistModel();
		insideChecklistModel.setAcFunctioning(new ChecklistModel(1, true, ""));
		insideChecklistModel.setSoc(new ChecklistModel(2, true, ""));
		insideChecklistModel.setBatteryTemperatureOk(new ChecklistModel(3, true, ""));
		insideChecklistModel.setFireExtinguisher(new ChecklistModel(4, true, ""));
		insideChecklistModel.setHammer(new ChecklistModel(5, true, ""));
		insideChecklistModel.setBusCleanlinessInside(new ChecklistModel(6, true, ""));
		insideChecklistModel.setBusCleanlinessOutside(new ChecklistModel(7, true, ""));
		insideChecklistModel.setRearViewMirror(new ChecklistModel(8, true, ""));
		insideChecklistModel.setFdssLock(new ChecklistModel(9, true, ""));

		return insideChecklistModel;
	}

	public static FrontChecklistModel getDefaultFrontChecklist() {
		FrontChecklistModel frontChecklistModel = new FrontChecklistModel();
		frontChecklistModel.setWiperBladesFunctioning(new ChecklistModel(1, true, ""));
		frontChecklistModel.setIndicatorsFunctioning(new ChecklistModel(2, true, ""));
		frontChecklistModel.setHeadlampFunctioning(new ChecklistModel(3, true, ""));
		frontChecklistModel.setFogLamp(new ChecklistModel(4, true, ""));
		frontChecklistModel.setNumberPlate(new ChecklistModel(5, true, ""));
		frontChecklistModel.setRouteBoardDisplay(new ChecklistModel(6, true, ""));
		frontChecklistModel.setTyrePressureOk(new ChecklistModel(7, true, ""));

		return frontChecklistModel;
	}

	public static RearChecklistModel getDefaultRearChecklist() {
		RearChecklistModel rearChecklistModel = new RearChecklistModel();
		rearChecklistModel.setTailLampFunctioning(new ChecklistModel(1, true, ""));
		rearChecklistModel.setNumberPlate(new ChecklistModel(2, true, ""));
		rearChecklistModel.setRouteBoardDisplay(new ChecklistModel(3, true, ""));
		rearChecklistModel.setTyrePressureOk(new ChecklistModel(4, true, ""));

		return rearChecklistModel;
	}

	public static InsideChecklistModel getInsideChecklist(ChecklistDetails checklistDetails,
			ChecklistData checklistData) {
		InsideChecklistModel insideChecklistModel = getDefaultInsideChecklist();

		if (checklistData != null && checklistDetails != null) {
//			switch (checklistDetails.getName()) {
			switch (checklistData.getChecklistName()) {
			case "AC_FUNCTIONING":
				insideChecklistModel.setAcFunctioning(new ChecklistModel(checklistData.getId(),
						checklistData.getStatus(), checklistData.getDescription()));
				break;
			case "SOC":
				insideChecklistModel.setSoc(new ChecklistModel(checklistData.getId(), checklistData.getStatus(),
						checklistData.getDescription()));
				break;
			case "BATTERY_TEMP_OK":
				insideChecklistModel.setBatteryTemperatureOk(new ChecklistModel(checklistData.getId(),
						checklistData.getStatus(), checklistData.getDescription()));
				break;
			case "FIRE_EXT":
				insideChecklistModel.setAcFunctioning(new ChecklistModel(checklistData.getId(),
						checklistData.getStatus(), checklistData.getDescription()));
				break;
			case "HAMMER":
				insideChecklistModel.setHammer(new ChecklistModel(checklistData.getId(), checklistData.getStatus(),
						checklistData.getDescription()));
				break;
			case "BUS_CLEAN_INSIDE":
				insideChecklistModel.setBusCleanlinessInside(new ChecklistModel(checklistData.getId(),
						checklistData.getStatus(), checklistData.getDescription()));
				break;
			case "BUS_CLEAN_OUTSIDE":
				insideChecklistModel.setBusCleanlinessOutside(new ChecklistModel(checklistData.getId(),
						checklistData.getStatus(), checklistData.getDescription()));
				break;
			case "REAR_VIEW_MIRROR":
				insideChecklistModel.setRearViewMirror(new ChecklistModel(checklistData.getId(),
						checklistData.getStatus(), checklistData.getDescription()));
				break;
			case "FDSS_LOCK":
				insideChecklistModel.setFdssLock(new ChecklistModel(checklistData.getId(), checklistData.getStatus(),
						checklistData.getDescription()));
				break;
			default:
				break;
			}
		}

		return insideChecklistModel;
	}

	public static FrontChecklistModel getFrontChecklist(ChecklistDetails checklistDetails,
			ChecklistData checklistData) {
		FrontChecklistModel frontChecklistModel = getDefaultFrontChecklist();

		if (checklistData != null && checklistDetails != null) {
//			switch (checklistDetails.getName()) {
			switch (checklistData.getChecklistName()) {
			case "WIPER_BLADES":
				frontChecklistModel.setWiperBladesFunctioning(new ChecklistModel(checklistData.getId(),
						checklistData.getStatus(), checklistData.getDescription()));
				break;
			case "INDICATORS":
				frontChecklistModel.setIndicatorsFunctioning(new ChecklistModel(checklistData.getId(),
						checklistData.getStatus(), checklistData.getDescription()));
				break;
			case "HEAD_LAMP":
				frontChecklistModel.setHeadlampFunctioning(new ChecklistModel(checklistData.getId(),
						checklistData.getStatus(), checklistData.getDescription()));
				break;
			case "FOG_LAMP":
				frontChecklistModel.setFogLamp(new ChecklistModel(checklistData.getId(), checklistData.getStatus(),
						checklistData.getDescription()));
				break;
			case "NUMBER_PLATE":
				frontChecklistModel.setNumberPlate(new ChecklistModel(checklistData.getId(), checklistData.getStatus(),
						checklistData.getDescription()));
				break;
			case "ROUTE_BOARD_DISPLAY":
				frontChecklistModel.setRouteBoardDisplay(new ChecklistModel(checklistData.getId(),
						checklistData.getStatus(), checklistData.getDescription()));
				break;
			case "TYRE_PRESSURE":
				frontChecklistModel.setTyrePressureOk(new ChecklistModel(checklistData.getId(),
						checklistData.getStatus(), checklistData.getDescription()));
				break;
			default:
				break;
			}
		}

//		frontChecklistModel.setWiperBladesFunctioning(new ChecklistModel(1, true, ""));
//		frontChecklistModel.setIndicatorsFunctioning(new ChecklistModel(2, true, ""));
//		frontChecklistModel.setHeadlampFunctioning(new ChecklistModel(3, true, ""));
//		frontChecklistModel.setFogLamp(new ChecklistModel(4, true, ""));
//		frontChecklistModel.setNumberPlate(new ChecklistModel(5, true, ""));
//		frontChecklistModel.setRouteBoardDisplay(new ChecklistModel(6, true, ""));
//		frontChecklistModel.setTyrePressureOk(new ChecklistModel(7, true, ""));

		return frontChecklistModel;
	}

	public static RearChecklistModel getRearChecklist(ChecklistDetails checklistDetails, ChecklistData checklistData) {
		RearChecklistModel rearChecklistModel = getDefaultRearChecklist();

		if (checklistData != null && checklistDetails != null) {
//			switch (checklistDetails.getName()) {
			switch (checklistData.getChecklistName()) {
			case "TAIL_LAMP":
				rearChecklistModel.setTailLampFunctioning(new ChecklistModel(checklistData.getId(),
						checklistData.getStatus(), checklistData.getDescription()));
				break;
			case "NUMBER_PLATE":
				rearChecklistModel.setNumberPlate(new ChecklistModel(checklistData.getId(), checklistData.getStatus(),
						checklistData.getDescription()));
				break;
			case "ROUTE_BOARD":
				rearChecklistModel.setRouteBoardDisplay(new ChecklistModel(checklistData.getId(),
						checklistData.getStatus(), checklistData.getDescription()));
				break;
			case "TYRE_PRESSURE":
				rearChecklistModel.setTyrePressureOk(new ChecklistModel(checklistData.getId(),
						checklistData.getStatus(), checklistData.getDescription()));
				break;
			default:
				break;
			}
		}

//		rearChecklistModel.setTailLampFunctioning(new ChecklistModel(1, true, ""));
//		rearChecklistModel.setNumberPlate(new ChecklistModel(2, true, ""));
//		rearChecklistModel.setRouteBoardDisplay(new ChecklistModel(3, true, ""));
//		rearChecklistModel.setTyrePressureOk(new ChecklistModel(4, true, ""));

		return rearChecklistModel;
	}

	public static List<ChecklistModel> getChecklist(List<ChecklistDetails> checklistDetails) {
		List<ChecklistModel> checkListModelList = new ArrayList<>();

		if (checklistDetails != null && !checklistDetails.isEmpty()) {
			checklistDetails.forEach(cl -> {
				checkListModelList
						.add(new ChecklistModel(cl.getId(), cl.getName(), cl.getType(), true, cl.getDescription()));
			});
		}
		return checkListModelList;
	}

	public static List<ChecklistModel> getChecklist(List<ChecklistDetails> checklistDetails,
			List<ChecklistData> checklistDataList) {
		List<ChecklistModel> checkListModelList = new ArrayList<>();

		if (checklistDetails != null && !checklistDetails.isEmpty()) {
			checklistDetails.forEach(cl -> {
				ChecklistModel checklistModel = new ChecklistModel(cl.getId(), cl.getName(), cl.getType(), true,
						cl.getDescription());
				if (checklistDataList != null && !checklistDataList.isEmpty()) {
					checklistDataList.forEach(checklistData -> {
						if (checklistData.getChecklistName() != null
								&& checklistData.getChecklistName().equals(checklistModel.getName())) {
							checklistModel.setStatus(checklistData.getStatus());
							checklistModel.setDescription(checklistData.getDescription());
							checkListModelList.add(checklistModel);
						} else {
							checkListModelList.add(checklistModel);
						}
					});
				} else {
					checkListModelList.add(checklistModel);
				}
//				checkListModelList
//						.add(new ChecklistModel(cl.getId(), cl.getName(), cl.getType(), true, cl.getDescription()));
			});
		}
		return checkListModelList;
	}

	public static Map<String, Boolean> getAttendanceLogsMonthlyTillCurrentDate() {
		List<AttendanceLogModel> logList = new ArrayList<>();
		Map<String, Boolean> logs = new HashMap<>();

		int dayOfMonth = LocalDateTime.now().getDayOfMonth();
		for (int i = 1; i <= dayOfMonth; i++) {
			logs.put(LocalDate.now().withDayOfMonth(i).toString(), false);
		}
		return logs;
	}

}
