package com.vecv.service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.vecv.core.exception.EvServiceException;
import com.vecv.model.auth.UserLoginRequestModel;
import com.vecv.model.user.AttendanceLogModel;
import com.vecv.model.user.AttendanceModel;
import com.vecv.model.user.ChecklistModel;
import com.vecv.model.user.UserAttendanceModel;
import com.vecv.model.user.UserChecklistModel;
import com.vecv.model.user.UserProfileModel;

public interface EvUserService {

	public Map<String, Object> userLogin(UserLoginRequestModel loginRequestModel) throws EvServiceException;

	public Map<String, Integer> generateOtp(String phoneNumber) throws EvServiceException;

	public UserProfileModel getUserProfile(@Valid String phoneNumber) throws EvServiceException;

	public String markAttendance(Integer userId, @Valid AttendanceModel attendanceModel) throws EvServiceException;

	public UserAttendanceModel getAttendanceList(Integer userId) throws EvServiceException;

	public String saveChecklist(Integer userId, List<ChecklistModel> checklistModelList) throws EvServiceException;

	public UserChecklistModel getChecklist(Integer userId) throws EvServiceException;

	public List<AttendanceLogModel> getAttendanceLogs(Integer driverId) throws EvServiceException;

}
