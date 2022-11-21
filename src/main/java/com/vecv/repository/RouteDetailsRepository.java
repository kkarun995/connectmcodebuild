package com.vecv.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vecv.core.EvConstants.TRIP_STATUS;
import com.vecv.core.exception.EvServiceException;
import com.vecv.dao.RouteDetailsDao;
import com.vecv.dao.StoppageDetails;
import com.vecv.service.util.DateTimeUtil;

@Repository
public class RouteDetailsRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(RouteDetailsRepository.class);

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public RouteDetailsDao getRouteDetails(Integer tripId, Integer driverId) throws EvServiceException {
		String query = "SELECT td.driverid, td.vehicleid, td.id AS tripid, rd.id,rd.routename, rd.noofstop, rd.distance,"
				+ " td.starttime, td.endtime, ts.status FROM route_data_details rd"
				+ " JOIN trip_details td ON td.routeid = rd.id"
				+ " LEFT JOIN trip_status ts ON ts.tripid = td.id AND date = CURRENT_DATE"
				+ " WHERE td.driverid =:driverId AND td.id =:tripId";
		try {
			MapSqlParameterSource params = new MapSqlParameterSource("driverId", driverId);
			params.addValue("tripId", tripId);

			return jdbcTemplate.query(query, params, new ResultSetExtractor<RouteDetailsDao>() {
				@Override
				public RouteDetailsDao extractData(ResultSet rs) throws SQLException, DataAccessException {
					RouteDetailsDao routeDetailsDao = null;
					if (rs.next()) {
						routeDetailsDao = new RouteDetailsDao();
						routeDetailsDao.setDriverId(rs.getInt("driverid"));
						routeDetailsDao.setVehicleId(rs.getInt("vehicleid"));
						routeDetailsDao.setTripId(rs.getInt("tripid"));
						routeDetailsDao.setRouteId(rs.getInt("id"));
						routeDetailsDao.setRouteName(rs.getString("routename"));
						routeDetailsDao.setTripStatus(
								rs.getString("status") != null ? rs.getString("status") : TRIP_STATUS.UPCOMING.name());
						routeDetailsDao.setNumOfStops(rs.getInt("noofstop"));
						routeDetailsDao.setTotalDistance(rs.getDouble("distance"));
						routeDetailsDao.setEstimatedTimeToDestination(getEstimatedTime(rs));
						routeDetailsDao.setStartTime(
								DateTimeUtil.parseText(rs.getTimestamp("starttime"), "yyyy-MM-dd HH:mm:ss"));
						routeDetailsDao
								.setEndTime(DateTimeUtil.parseText(rs.getTimestamp("endtime"), "yyyy-MM-dd HH:mm:ss"));
					}
					return routeDetailsDao;
				}

				private String getEstimatedTime(ResultSet rs) {
					String estimatedTime = "";
					try {
						estimatedTime = DateTimeUtil.formatElapsedTime(
								DateTimeUtil.getDifferenceBetweenTwoDatesInSeconds(rs.getTimestamp("starttime"),
										rs.getTimestamp("endtime")));
					} catch (SQLException e) {
						e.printStackTrace();
					}
					return estimatedTime;
				}
			});
		} catch (DataAccessException e) {
			LOGGER.error("DataAccessException: {}", e.getMessage());
			e.printStackTrace();
			throw new EvServiceException("Failed to save complaint details");
		}
	}

	public List<StoppageDetails> getRouteStoppageDetails(Integer routeId, String routeName, String startTime)
			throws EvServiceException {
		String query = "SELECT * FROM route_stop_details WHERE routeid =:routeId ORDER BY id";
		try {
			MapSqlParameterSource params = new MapSqlParameterSource("routeId", routeId);
			return jdbcTemplate.query(query, params, new RowMapper<StoppageDetails>() {
				LocalDateTime startDateTime = null;

				@Override
				public StoppageDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
					return new StoppageDetails(routeName, rs.getInt("stopnumber"),
							getStoppageTime(rs.getInt("duration")), rs.getString("stoplocation"),
							rs.getString("stoplatitude"), rs.getString("stoplongitude"));
				}

				private String getStoppageTime(int duration) {
					String stoppageTime = "";
					try {
						if (duration > 0) {
							if (startDateTime == null) {
//								currentDateTime = LocalDateTime.now();
								startDateTime = DateTimeUtil.parseTextWithDefaultDateTimeFormat(startTime);
							} else {
								startDateTime = startDateTime.plusMinutes(duration);
							}
							stoppageTime = DateTimeUtil.formatDate(startDateTime, "hh:mm a");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					return stoppageTime;
				}
			});
		} catch (DataAccessException e) {
			LOGGER.error("DataAccessException: {}", e.getMessage());
			e.printStackTrace();
			throw new EvServiceException("Failed to save complaint details");
		}
	}

}
