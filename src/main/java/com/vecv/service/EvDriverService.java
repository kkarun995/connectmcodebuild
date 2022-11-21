package com.vecv.service;

import java.util.Map;

import javax.validation.Valid;

import com.vecv.core.exception.EvServiceException;
import com.vecv.dao.ComplaintDetailsDao;
import com.vecv.model.driver.ReportingTimeModel;

public interface EvDriverService {

	String submitComplaintDetails(@Valid ComplaintDetailsDao complaintDetailsDao) throws EvServiceException;

	String saveReportingTime(ReportingTimeModel reportingTimeModel) throws EvServiceException;

	ReportingTimeModel getReportingTime(Integer driverId) throws EvServiceException;

	Map<String, Object> getLeaveInfo(Integer driverId) throws EvServiceException;

}
