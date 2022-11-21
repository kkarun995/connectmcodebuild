package com.vecv.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vecv.dao.AlertDetailsDao;
import com.vecv.dao.CurrentDataDao;
import com.vecv.dao.TripDetailsDao;
import com.vecv.dao.TripMonitorDetailsDao;
import com.vecv.dao.TripSummaryDao;
import com.vecv.dao.UpcomingTripDao;
import com.vecv.dao.VehicleHomepageDao;
import com.vecv.entity.TripDetails;
import com.vecv.entity.VehicleDetails;
import com.vecv.model.user.AttendanceLogModel;
import com.vecv.service.util.DateTimeUtil;

@Repository
public class HomepageRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public TripDetails findUpcomingTripByDriverId(Integer driverId) {
		String query = "SELECT * FROM trip_details WHERE driverid =:driverId"
				+ " AND to_char(starttime::time,'HH24:MI') > to_char(:currentTime::time,'HH24:MI') LIMIT 1";

		MapSqlParameterSource params = new MapSqlParameterSource("driverId", driverId);
		params.addValue("currentTime", DateTimeUtil.getCurrentTimeInISTTimezone());

		return jdbcTemplate.query(query, params, new ResultSetExtractor<TripDetails>() {

			@Override
			public TripDetails extractData(ResultSet rs) throws SQLException, DataAccessException {
				TripDetails tripDetails = new TripDetails();
				while (rs.next()) {
					tripDetails = new TripDetails();
					tripDetails.setId(rs.getInt("id"));
					tripDetails.setVehicleId(rs.getInt("vehicleid"));
					tripDetails.setCheckedIn(rs.getBoolean("checkedin"));
					tripDetails.setStartLocation(rs.getString("startlocation"));
					tripDetails.setEndLocation(rs.getString("endlocation"));
					tripDetails.setStartTime(rs.getDate("starttime"));
					tripDetails.setEndTime(rs.getDate("endtime"));
				}
				return tripDetails;
			}
		});
	}

	public UpcomingTripDao findUpcomingTrip(Integer driverId) {
		String query = "SELECT td.id, td.vehicleid, td.checkedin, td.startlocation, td.endlocation,"
				+ " td.starttime, td.endtime, rd.id AS routeid, rd.routename FROM trip_details td"
				+ " JOIN route_data_details rd ON rd.id = td.routeid"
				+ " WHERE td.driverid =:driverId AND to_char(td.starttime::time,'HH24:MI') > to_char(:currentTime::time,'HH24:MI')"
				+ " LIMIT 1";

		MapSqlParameterSource params = new MapSqlParameterSource("driverId", driverId);
		params.addValue("currentTime", DateTimeUtil.getCurrentTimeInISTTimezone());

		return jdbcTemplate.query(query, params, new ResultSetExtractor<UpcomingTripDao>() {
			@Override
			public UpcomingTripDao extractData(ResultSet rs) throws SQLException, DataAccessException {
				UpcomingTripDao tripDetails = null;
				while (rs.next()) {
					tripDetails = new UpcomingTripDao();
					tripDetails.setId(rs.getInt("id"));
					tripDetails.setVehicleId(rs.getInt("vehicleid"));
					tripDetails.setCheckedIn(rs.getBoolean("checkedin"));
					tripDetails.setStartLocation(rs.getString("startlocation"));
					tripDetails.setEndLocation(rs.getString("endlocation"));
					tripDetails.setStartTime(rs.getTimestamp("starttime"));
					tripDetails.setEndTime(rs.getTimestamp("endtime"));
					tripDetails.setRouteId(rs.getInt("routeid"));
					tripDetails.setRouteName(rs.getString("routename"));
				}
				return tripDetails;
			}
		});
	}

	public VehicleDetails findByVehicleId(Integer vehicleId) {
		String query = "SELECT * FROM vehicle_details_master WHERE id =:vehicleId";

		MapSqlParameterSource params = new MapSqlParameterSource("vehicleId", vehicleId);
		return jdbcTemplate.query(query, params, new ResultSetExtractor<VehicleDetails>() {

			@Override
			public VehicleDetails extractData(ResultSet rs) throws SQLException, DataAccessException {
				VehicleDetails vehicleDetails = new VehicleDetails();
				while (rs.next()) {
					vehicleDetails = new VehicleDetails();
					vehicleDetails.setId(rs.getInt("id"));
					vehicleDetails.setVehicleId(rs.getString("vehicle_id"));
					vehicleDetails.setMake(rs.getString("make"));
					vehicleDetails.setModel(rs.getString("model"));
					vehicleDetails.setRegNo(rs.getString("reg_no"));
					vehicleDetails.setVin(rs.getString("vin"));
				}
				return vehicleDetails;
			}
		});
	}

	public AlertDetailsDao getScoreDetails(int driverId) {
		String query = "SELECT * FROM alert_details WHERE driverid =:driverId LIMIT 1";

		MapSqlParameterSource params = new MapSqlParameterSource("driverId", driverId);
		return jdbcTemplate.query(query, params, new ResultSetExtractor<AlertDetailsDao>() {

			@Override
			public AlertDetailsDao extractData(ResultSet rs) throws SQLException, DataAccessException {
				AlertDetailsDao alertDetailsDao = new AlertDetailsDao();
				while (rs.next()) {
					alertDetailsDao = new AlertDetailsDao(rs.getInt("id"), rs.getString("name"), rs.getInt("score"),
							rs.getInt("harsh_acceleration"), rs.getInt("harsh_breaking"), rs.getInt("over_speeding"),
							rs.getInt("vehicleid"), rs.getInt("driverid"));
				}
				return alertDetailsDao;
			}
		});
	}

	public VehicleHomepageDao getVehicleDetails(int driverId) {
		String query = "SELECT tp.id, tp.driverid, tp.vehicleid, vh.reg_no , tp.starttime, tp.endtime FROM trip_details tp"
				+ "	JOIN vehicle_details_master vh ON vh.id = tp.vehicleid	WHERE tp.driverid =:driverId"
				+ " AND to_char(tp.endtime::time,'HH24:MI') > to_char(:currentTime::time,'HH24:MI')"
				+ "	ORDER BY tp.starttime LIMIT 1";

		MapSqlParameterSource params = new MapSqlParameterSource("driverId", driverId);
		params.addValue("currentTime", DateTimeUtil.getCurrentTimeInISTTimezone());

		return jdbcTemplate.query(query, params, new ResultSetExtractor<VehicleHomepageDao>() {

			@Override
			public VehicleHomepageDao extractData(ResultSet rs) throws SQLException, DataAccessException {
				VehicleHomepageDao vehicleHomepageDao = new VehicleHomepageDao();
				while (rs.next()) {
					vehicleHomepageDao = new VehicleHomepageDao(driverId, rs.getInt("vehicleid"),
							rs.getString("reg_no"), DateTimeUtil.parseText(rs.getTimestamp("starttime"), "hh:mm aa"),
							DateTimeUtil.parseText(rs.getTimestamp("endtime"), "hh:mm aa"));
				}
				return vehicleHomepageDao;
			}
		});
	}

	public TripMonitorDetailsDao getTripMonitor(int driverId) {
		return new TripMonitorDetailsDao(getTripsCount(driverId, "COMPLETED"), getTripsCount(driverId, "ON_TIME"),
				getTripsCount(driverId, "DELAYED"));
	}

	public double getTripsCount(Integer driverId, String status) {
		String query = "SELECT COUNT(1) AS count FROM trip_kpi_data WHERE driverid =:driverId AND tripstatus =:tripstatus";

		MapSqlParameterSource params = new MapSqlParameterSource("tripstatus", status);
		params.addValue("driverId", driverId);
		return jdbcTemplate.query(query, params, new ResultSetExtractor<Double>() {

			@Override
			public Double extractData(ResultSet rs) throws SQLException, DataAccessException {
				double tripCount = 0;
				while (rs.next()) {
					tripCount = rs.getInt("count");
				}
				return tripCount;
			}
		});
	}

	public TripSummaryDao getTripsKpiDetails(Integer driverId, String checkedInDuration) {
		String query = "SELECT min(startodo) AS startodo, max(endodo) AS endodo, sum(totalkm) AS totalkm,"
				+ " max(startsoc) AS startsoc, min(endsoc) AS endsoc, sum(totalsoc) AS totalsoc, avg(maxspeed) AS avgspeed,"
				+ " sum(totaltime::interval) AS totaltime FROM trip_kpi_data WHERE driverid =:driverId"
				+ "  AND DATE(starttime) = CURRENT_DATE";

		MapSqlParameterSource params = new MapSqlParameterSource("driverId", driverId);
		return jdbcTemplate.query(query, params, new ResultSetExtractor<TripSummaryDao>() {

			@Override
			public TripSummaryDao extractData(ResultSet rs) throws SQLException, DataAccessException {
				TripSummaryDao tripSummaryDao = new TripSummaryDao();
				while (rs.next()) {
					tripSummaryDao = new TripSummaryDao(driverId, rs.getDouble("startodo"), rs.getDouble("endodo"),
							rs.getDouble("totalkm"), rs.getDouble("startsoc"), rs.getDouble("endsoc"),
							rs.getDouble("totalsoc"), rs.getDouble("avgspeed"),
							rs.getString("totaltime") != null ? rs.getString("totaltime") + " Hrs" : "0 Hrs",
							checkedInDuration);
				}
				return tripSummaryDao;
			}
		});
	}

	public List<TripDetailsDao> getAllTrips(@Valid Integer driverId) {
		String query = "SELECT td.id AS tripid, td.driverid, td.routeid, td.vehicleid,"
				+ " rd.routename, rd.distance, vd.reg_no, td.starttime, td.endtime, ts.status, vd.imei FROM trip_details td"
				+ " JOIN route_data_details rd ON rd.id = td.routeid"
				+ " JOIN vehicle_details_master vd ON vd.id = td.vehicleid"
				+ " LEFT JOIN trip_status ts ON td.driverid = ts.driverid AND td.id = ts.tripid"
				+ " AND ts.date =CURRENT_DATE WHERE td.driverid =:driverId"
				+ " AND to_char(td.starttime::time,'HH24:MI') > to_char(:currentTime::time,'HH24:MI')"
				+ "  ORDER BY DATE(td.starttime)";

		MapSqlParameterSource params = new MapSqlParameterSource("driverId", driverId);
		params.addValue("currentTime", DateTimeUtil.getCurrentTimeInISTTimezone());

		return jdbcTemplate.query(query, params, new RowMapper<TripDetailsDao>() {

			@Override
			public TripDetailsDao mapRow(ResultSet rs, int rowNum) throws SQLException {
				TripDetailsDao tripDetailsDao = new TripDetailsDao(rs.getInt("tripid"), rs.getInt("driverid"),
						rs.getInt("vehicleid"), rs.getString("reg_no"), rs.getInt("routeid"), rs.getString("routename"),
						rs.getDouble("distance"),
						DateTimeUtil.formatDate(DateTimeUtil.parseTextWithTodayDate(rs.getString("starttime")),
								"dd/MM/yy hh:mm a"),
						100d, "", 0d, rs.getString("status") != null ? rs.getString("status") : "UPCOMING",
						rs.getString("imei"));

				tripDetailsDao.setEndTime(DateTimeUtil
						.formatDate(DateTimeUtil.parseTextWithTodayDate(rs.getString("endtime")), "dd/MM/yy hh:mm a"));
				return tripDetailsDao;
			}
		});
	}

	public List<TripDetailsDao> getAllTripsDetails(@Valid Integer driverId) {
		String query = "SELECT ts.tripid, td.driverid, td.routeid, td.vehicleid, td.startsoc, td.startodo,"
				+ " rd.routename, rd.distance, vd.reg_no, tdd.starttime, ts.status, vd.imei FROM trip_data td"
				+ " JOIN trip_status ts ON td.driverid = ts.driverid AND td.tripid = ts.tripid"
				+ " AND ts.date = td.date JOIN trip_details tdd ON tdd.id = ts.tripid"
				+ " JOIN route_data_details rd ON rd.id = td.routeid"
				+ " JOIN vehicle_details_master vd ON vd.id = td.vehicleid WHERE td.driverid =:driverId"
//				+ " AND DATE(tdd.starttime) = CURRENT_DATE"
				+ " ORDER BY DATE(tdd.starttime) DESC";

		MapSqlParameterSource params = new MapSqlParameterSource("driverId", driverId);
		return jdbcTemplate.query(query, params, new RowMapper<TripDetailsDao>() {

			@Override
			public TripDetailsDao mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new TripDetailsDao(rs.getInt("tripid"), rs.getInt("driverid"), rs.getInt("vehicleid"),
						rs.getString("reg_no"), rs.getInt("routeid"), rs.getString("routename"),
						rs.getDouble("distance"), rs.getString("starttime"), rs.getDouble("startsoc"), "",
						rs.getDouble("startodo"), rs.getString("status"), rs.getString("imei"));
			}
		});
	}

	public TripDetailsDao tripDetails(Integer tripId, Integer driverId) {
		String query = "SELECT td.id, td.driverid, dd.name AS drivername, td.vehicleid,"
				+ " td.routeid, rd.routename, rd.noofstop, rd.distance, vd.imei, vd.reg_no FROM trip_details td"
				+ " JOIN vehicle_details_master vd ON vd.id = td.vehicleid"
				+ " JOIN route_data_details rd ON rd.id = td.routeid JOIN driver_details dd ON td.driverid = dd.id"
				+ " WHERE td.driverid =:driverId AND td.id =:tripId";

		MapSqlParameterSource params = new MapSqlParameterSource("driverId", driverId);
		params.addValue("tripId", tripId);

		return jdbcTemplate.query(query, params, new ResultSetExtractor<TripDetailsDao>() {
			@Override
			public TripDetailsDao extractData(ResultSet rs) throws SQLException, DataAccessException {
				TripDetailsDao tripDetailsDao = null;
				while (rs.next()) {
					tripDetailsDao = new TripDetailsDao();
					tripDetailsDao.setTripId(rs.getInt("id"));
					tripDetailsDao.setDriverId(rs.getInt("driverid"));
					tripDetailsDao.setDriverName(rs.getString("drivername"));
					tripDetailsDao.setVehicleId(rs.getInt("vehicleid"));
					tripDetailsDao.setVehicleRegNo(rs.getString("reg_no"));
					tripDetailsDao.setRouteId(rs.getInt("routeid"));
					tripDetailsDao.setRouteName(rs.getString("routename"));
					tripDetailsDao.setNumOfStops(rs.getInt("noofstop"));
					tripDetailsDao.setTotalDistance(rs.getDouble("distance"));
					tripDetailsDao.setDeviceId(rs.getString("imei"));
				}
				return tripDetailsDao;
			}
		});
	}

	public boolean getTripStatus(Integer tripId, Integer driverId) {
		String query = "SELECT id FROM trip_status WHERE driverid =:driverId AND tripid =:tripId";

		MapSqlParameterSource params = new MapSqlParameterSource("driverId", driverId);
		params.addValue("tripId", tripId);
		return jdbcTemplate.query(query, params, new ResultSetExtractor<Boolean>() {

			@Override
			public Boolean extractData(ResultSet rs) throws SQLException, DataAccessException {
				boolean tripStatusExist = false;
				while (rs.next()) {
					tripStatusExist = true;
				}
				return tripStatusExist;
			}
		});

	}

	public int updateTripStatus(TripDetailsDao tripDetailsDao, String tripStatus) {
		String query = "UPDATE trip_status SET status =:status, date = CURRENT_DATE WHERE tripid =:tripId AND driverid =:driverId";

		MapSqlParameterSource params = new MapSqlParameterSource("driverId", tripDetailsDao.getDriverId());
		params.addValue("tripId", tripDetailsDao.getTripId());
		params.addValue("status", tripStatus);

		return jdbcTemplate.update(query, params);
	}

	public int insertTripStatus(TripDetailsDao tripDetailsDao, String tripStatus) {
		String query = "INSERT INTO trip_status(tripid, driverid, vehicleid, status, date, tripid_tmp)"
				+ " VALUES(:tripId, :driverId, :vehicleId, :status, CURRENT_DATE, :tripid_tmp)";

		MapSqlParameterSource params = new MapSqlParameterSource("driverId", tripDetailsDao.getDriverId());
		params.addValue("tripId", tripDetailsDao.getTripId());
		params.addValue("vehicleId", tripDetailsDao.getVehicleId());
		params.addValue("status", tripStatus);
		params.addValue("tripid_tmp",
				tripDetailsDao.getTripId() + "_" + DateTimeUtil.parseText(new Date(), "yyyy/MM/dd"));

		return jdbcTemplate.update(query, params);
	}

	public int saveTripData(TripDetailsDao tripDetailsDao, String tripStatus, CurrentDataDao currentDataDao) {
		String query = "INSERT INTO trip_data(tripid, routeid, driverid, vehicleid, status, date, starttime, startodo, startsoc,"
				+ " drivername, regno, routename, numofstops, distance)"
				+ " VALUES(:tripId, :routeId, :driverId, :vehicleId, :status, CURRENT_DATE, NOW(), :startodo, :startsoc,"
				+ "	:drivername, :regno, :routename, :numOfStops, :distance)";

		MapSqlParameterSource params = new MapSqlParameterSource("driverId", tripDetailsDao.getDriverId());
		params.addValue("tripId", tripDetailsDao.getTripId());
		params.addValue("routeId", tripDetailsDao.getRouteId());
		params.addValue("vehicleId", tripDetailsDao.getVehicleId());
		params.addValue("status", tripStatus);
		params.addValue("startodo", currentDataDao != null ? currentDataDao.getOdometer() : 0d);
		params.addValue("startsoc", currentDataDao != null ? currentDataDao.getSoc() : 100);

		params.addValue("drivername", tripDetailsDao.getDriverName());
		params.addValue("regno", tripDetailsDao.getVehicleRegNo());
		params.addValue("routename", tripDetailsDao.getRouteName());
		params.addValue("numOfStops", tripDetailsDao.getNumOfStops());
		params.addValue("distance", tripDetailsDao.getTotalDistance());

		return jdbcTemplate.update(query, params);
	}

	public int updateTripData(TripDetailsDao tripDetailsDao, String tripStatus, CurrentDataDao currentDataDao) {
		String query = "UPDATE trip_data SET status =:status, endsoc=:endsoc, endodo=:endodo, endtime = NOW()"
				+ " WHERE tripid =:tripId AND driverid =:driverId"
				+ " AND routeid =:routeId AND vehicleid =:vehicleId AND status ='ONGOING' AND date = CURRENT_DATE";

		MapSqlParameterSource params = new MapSqlParameterSource("driverId", tripDetailsDao.getDriverId());
		params.addValue("tripId", tripDetailsDao.getTripId());
		params.addValue("routeId", tripDetailsDao.getRouteId());
		params.addValue("vehicleId", tripDetailsDao.getVehicleId());
		params.addValue("status", tripStatus);
		params.addValue("endodo", currentDataDao != null ? currentDataDao.getOdometer() : 0d);
		params.addValue("endsoc", currentDataDao != null ? currentDataDao.getSoc() : 0d);

		return jdbcTemplate.update(query, params);
	}

	public Map<String, Boolean> getAttendanceLogs(Integer driverId, Map<String, Boolean> attendanceLogs) {
		String query = "select * from attandance_data WHERE driverid =:driverId ORDER BY date";

		MapSqlParameterSource params = new MapSqlParameterSource("driverId", driverId);
		return jdbcTemplate.query(query, params, new ResultSetExtractor<Map<String, Boolean>>() {

			@Override
			public Map<String, Boolean> extractData(ResultSet rs) throws SQLException, DataAccessException {
				Map<String, AttendanceLogModel> logs = new HashMap<>();
				if (rs.next()) {
					String date = DateTimeUtil.parseText(rs.getDate("date"), "yyyy-MM-dd");
					if (attendanceLogs.containsKey(date)) {
						attendanceLogs.put(date, true);
						logs.put(date, new AttendanceLogModel(date, true));
					} else {
						logs.put(date, new AttendanceLogModel(date, false));
					}

				}
				return attendanceLogs;
			}
		});
	}

	public Map<String, CurrentDataDao> getCurrentData(List<String> deviceIds) {
		String query = "select * from ev_current_data WHERE deviceid IN (:deviceIds)";

		MapSqlParameterSource params = new MapSqlParameterSource("deviceIds", deviceIds);
		return jdbcTemplate.query(query, params, new ResultSetExtractor<Map<String, CurrentDataDao>>() {

			@Override
			public Map<String, CurrentDataDao> extractData(ResultSet rs) throws SQLException, DataAccessException {
				Map<String, CurrentDataDao> map = new HashMap<>();
				if (rs.next()) {
					map.put(rs.getString("deviceid"),
							new CurrentDataDao(rs.getString("deviceid"), rs.getString("lattitude"),
									rs.getString("longitude"), rs.getDouble("odometer"), rs.getDouble("soc"),
									rs.getString("location")));
				}
				return map;
			}
		});
	}

	public CurrentDataDao getCurrentData(String deviceId) {
		String query = "select * from ev_current_data WHERE deviceid =:deviceId";

		MapSqlParameterSource params = new MapSqlParameterSource("deviceId", deviceId);
		return jdbcTemplate.query(query, params, new ResultSetExtractor<CurrentDataDao>() {

			@Override
			public CurrentDataDao extractData(ResultSet rs) throws SQLException, DataAccessException {
				CurrentDataDao currentDataDao = new CurrentDataDao();
				if (rs.next()) {
					currentDataDao = new CurrentDataDao(rs.getString("deviceid"), rs.getString("lattitude"),
							rs.getString("longitude"), rs.getDouble("odometer"), rs.getDouble("soc"),
							rs.getString("location"));
				}
				return currentDataDao;
			}
		});
	}

	public List<TripDetailsDao> getAllUpcomingTrips(@Valid Integer driverId, List<Integer> ongoingTripIds) {
		String query = "SELECT td.id AS tripid, td.driverid, td.routeid, td.vehicleid,"
				+ " rd.routename, rd.distance, vd.reg_no, td.starttime, td.endtime, ts.status, vd.imei FROM trip_details td"
				+ " JOIN route_data_details rd ON rd.id = td.routeid"
				+ " JOIN vehicle_details_master vd ON vd.id = td.vehicleid"
				+ " LEFT JOIN trip_status ts ON td.driverid = ts.driverid AND td.id = ts.tripid"
				+ " AND ts.date =CURRENT_DATE AND ts.status = 'UPCOMING' WHERE td.driverid =:driverId"
				+ " AND to_char(td.starttime::time,'HH24:MI') > to_char(:currentTime::time,'HH24:MI')";

		if (ongoingTripIds != null && !ongoingTripIds.isEmpty()) {
			query += " AND td.id NOT IN (:ongoingTripIds)";
		}
		query += "  ORDER BY DATE(td.starttime)";

		MapSqlParameterSource params = new MapSqlParameterSource("driverId", driverId);
		params.addValue("ongoingTripIds", ongoingTripIds);
		params.addValue("currentTime", DateTimeUtil.getCurrentTimeInISTTimezone());

		return jdbcTemplate.query(query, params, new RowMapper<TripDetailsDao>() {

			@Override
			public TripDetailsDao mapRow(ResultSet rs, int rowNum) throws SQLException {
				TripDetailsDao tripDetailsDao = new TripDetailsDao(rs.getInt("tripid"), rs.getInt("driverid"),
						rs.getInt("vehicleid"), rs.getString("reg_no"), rs.getInt("routeid"), rs.getString("routename"),
						rs.getDouble("distance"),
						DateTimeUtil.formatDate(DateTimeUtil.parseTextWithTodayDate(rs.getString("starttime")),
								"dd/MM/yy hh:mm a"),
						100d, "", 0d, rs.getString("status") != null ? rs.getString("status") : "UPCOMING",
						rs.getString("imei"));

				tripDetailsDao.setEndTime(DateTimeUtil
						.formatDate(DateTimeUtil.parseTextWithTodayDate(rs.getString("endtime")), "dd/MM/yy hh:mm a"));
				return tripDetailsDao;
			}
		});
	}

	public List<TripDetailsDao> getAllOngoingTrips(Integer driverId) {
		String query = "SELECT td.id AS tripid, td.driverid, td.routeid, td.vehicleid,"
				+ " rd.routename, rd.distance, vd.reg_no, td.starttime, td.endtime, ts.status, vd.imei FROM trip_details td"
				+ " JOIN route_data_details rd ON rd.id = td.routeid"
				+ " JOIN vehicle_details_master vd ON vd.id = td.vehicleid"
				+ " JOIN trip_status ts ON td.driverid = ts.driverid AND td.id = ts.tripid"
				+ " AND ts.date =CURRENT_DATE AND ts.status = 'ONGOING' WHERE td.driverid =:driverId"
				+ " AND to_char(td.endtime::time,'HH24:MI') > to_char(:currentTime::time,'HH24:MI')"
				+ "  ORDER BY DATE(td.endtime)";

		MapSqlParameterSource params = new MapSqlParameterSource("driverId", driverId);
		params.addValue("currentTime", DateTimeUtil.getCurrentTimeInISTTimezone());

		return jdbcTemplate.query(query, params, new RowMapper<TripDetailsDao>() {

			@Override
			public TripDetailsDao mapRow(ResultSet rs, int rowNum) throws SQLException {
				TripDetailsDao tripDetailsDao = new TripDetailsDao(rs.getInt("tripid"), rs.getInt("driverid"),
						rs.getInt("vehicleid"), rs.getString("reg_no"), rs.getInt("routeid"), rs.getString("routename"),
						rs.getDouble("distance"),
						DateTimeUtil.formatDate(DateTimeUtil.parseTextWithTodayDate(rs.getString("starttime")),
								"dd/MM/yy hh:mm a"),
						100d, "", 0d, rs.getString("status"), rs.getString("imei"));

				tripDetailsDao.setEndTime(DateTimeUtil
						.formatDate(DateTimeUtil.parseTextWithTodayDate(rs.getString("endtime")), "dd/MM/yy hh:mm a"));
				return tripDetailsDao;
			}
		});
	}

}
