package com.vecv.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vecv.dao.TripLogsDao;
import com.vecv.model.trip.TripLogRequestModel;
import com.vecv.service.util.DateTimeUtil;

@Repository
public class TripManagementRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(TripManagementRepository.class);

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public List<TripLogsDao> getTripLogsOld(TripLogRequestModel tripLogRequestModel) {
		String query = "SELECT * FROM trip_data WHERE driverid =:driverId AND status = 'COMPLETED'"
				+ " AND TO_CHAR(date, 'YYYY-MM-DD') >=:fromTime AND TO_CHAR(date, 'YYYY-MM-DD') <=:toTime"
				+ " ORDER BY date;";

		MapSqlParameterSource params = new MapSqlParameterSource("driverId", tripLogRequestModel.getDriverId());
		params.addValue("fromTime", tripLogRequestModel.getFromTime());
		params.addValue("toTime", tripLogRequestModel.getToTime());
		return jdbcTemplate.query(query, params, new RowMapper<TripLogsDao>() {

			@Override
			public TripLogsDao mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new TripLogsDao(rs.getInt("driverid"), rs.getInt("vehicleid"), rs.getString("regno"),
						rs.getInt("routeid"), rs.getString("routename"), 0, rs.getDouble("startsoc"),
						rs.getDouble("endsoc"), rs.getDouble("startodo"), rs.getDouble("endodo"),
						DateTimeUtil.getCheckInDuration(rs.getTimestamp("starttime"), rs.getTimestamp("endtime")),
						rs.getString("status"), "");
			}
		});
	}

	public List<TripLogsDao> getTripLogs(TripLogRequestModel tripLogRequestModel) {
//		String query = "SELECT * FROM trip_data WHERE driverid =:driverId AND status = 'COMPLETED'"
//				+ " AND TO_CHAR(date, 'YYYY-MM-DD') >=:fromTime AND TO_CHAR(date, 'YYYY-MM-DD') <=:toTime"
//				+ " ORDER BY date";

		String query = "SELECT tk.driverid, tk.vehicleid,vd.reg_no, rd.id AS routeid, rd.routename,"
				+ " tk.startsoc, tk.endsoc, tk.startodo, tk.endodo, tk.starttime, tk.endtime, tk.tripstatus,"
				+ " tk.starttime FROM trip_kpi_data tk"
				+ " JOIN trip_details td ON td.driverid = tk.driverid AND tk.vehicleid = td.vehicleid"
				+ " JOIN vehicle_details_master vd ON vd.id = tk.vehicleid"
				+ " JOIN route_data_details rd ON rd.id = td.routeid"
				+ " WHERE tk.driverid =:driverId AND tk.tripstatus = 'COMPLETED'"
				+ " AND TO_CHAR(tk.starttime, 'YYYY-MM-DD') >=:fromTime AND TO_CHAR(tk.starttime, 'YYYY-MM-DD') <=:toTime"
				+ " ORDER BY tk.starttime";

		MapSqlParameterSource params = new MapSqlParameterSource("driverId", tripLogRequestModel.getDriverId());
		params.addValue("fromTime", tripLogRequestModel.getFromTime());
		params.addValue("toTime", tripLogRequestModel.getToTime());

		return jdbcTemplate.query(query, params, new RowMapper<TripLogsDao>() {

			@Override
			public TripLogsDao mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new TripLogsDao(rs.getInt("driverid"), rs.getInt("vehicleid"), rs.getString("reg_no"),
						rs.getInt("routeid"), rs.getString("routename"), 0, rs.getDouble("startsoc"),
						rs.getDouble("endsoc"), rs.getDouble("startodo"), rs.getDouble("endodo"),
						DateTimeUtil.getCheckInDuration(rs.getTimestamp("starttime"), rs.getTimestamp("endtime")),
						rs.getString("tripstatus"),
						DateTimeUtil.parseText(rs.getTimestamp("starttime"), "yyyy-MM-dd HH:mm:ss"));
			}
		});
	}

}
