package com.vecv.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vecv.core.exception.EvServiceException;
import com.vecv.model.driver.ReportingTimeModel;
import com.vecv.service.util.DateTimeUtil;

@Repository
public class DriverRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(DriverRepository.class);

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public int saveReportingTime(ReportingTimeModel reportingTimeModel) throws EvServiceException {
		String query = "INSERT INTO driver_report_time(driverid, location, latitude, longitude, reportingtime)"
				+ " VALUES(:driverId, :location, :latitude, :longitude, NOW())";
		try {
			MapSqlParameterSource params = new MapSqlParameterSource("driverId", reportingTimeModel.getDriverId());
			params.addValue("location", reportingTimeModel.getLocation());
			params.addValue("latitude", reportingTimeModel.getLatitude());
			params.addValue("longitude", reportingTimeModel.getLongitude());

			return jdbcTemplate.update(query, params);
		} catch (DataAccessException e) {
			LOGGER.error("DataAccessException: {}", e.getMessage());
			e.printStackTrace();
			throw new EvServiceException("Failed to save complaint details");
		}
	}

	public ReportingTimeModel getReportingTime(Integer driverId) {
		String query = "SELECT * FROM driver_report_time WHERE driverid =:driverId AND DATE(reportingtime) = CURRENT_DATE"
				+ "  ORDER BY reportingtime DESC LIMIT 1";

		MapSqlParameterSource params = new MapSqlParameterSource("driverId", driverId);
		return jdbcTemplate.query(query, params, new ResultSetExtractor<ReportingTimeModel>() {

			@Override
			public ReportingTimeModel extractData(ResultSet rs) throws SQLException, DataAccessException {
				ReportingTimeModel reportingTimeModel = null;
				while (rs.next()) {
					reportingTimeModel = new ReportingTimeModel(rs.getInt("driverid"),
							DateTimeUtil.parseText(rs.getTimestamp("reportingtime"), "yyyy-MM-dd HH:mm:ss"),
							rs.getString("location"), rs.getString("latitude"), rs.getString("longitude"));
				}
				return reportingTimeModel;
			}
		});
	}

}
