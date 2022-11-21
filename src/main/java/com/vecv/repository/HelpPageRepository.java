package com.vecv.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vecv.core.exception.EvServiceException;
import com.vecv.dao.ComplaintDetailsDao;

@Repository
public class HelpPageRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(HelpPageRepository.class);

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public int saveComplaintDetails(ComplaintDetailsDao complaintDetailsDao) throws EvServiceException {
		String query = "INSERT INTO complaint_details(driverid, vehicleid, phone_number, alt_phone_number, location, description, date)"
				+ " VALUES(:driverId, :vehicleId, :phoneNumber, :altPhoneNumber, :location, :description, CURRENT_DATE)";
		try {
			MapSqlParameterSource params = new MapSqlParameterSource("driverId", complaintDetailsDao.getDriverId());
			params.addValue("vehicleId", complaintDetailsDao.getVehicleId());
			params.addValue("phoneNumber", complaintDetailsDao.getPhoneNumber());
			params.addValue("altPhoneNumber", complaintDetailsDao.getAlternatePhoneNumber());
			params.addValue("location", complaintDetailsDao.getLocation());
			params.addValue("description", complaintDetailsDao.getDescription());

			return jdbcTemplate.update(query, params);
		} catch (DataAccessException e) {
			LOGGER.error("DataAccessException: {}", e.getMessage());
			e.printStackTrace();
			throw new EvServiceException("Failed to save complaint details");
		}
	}

}
