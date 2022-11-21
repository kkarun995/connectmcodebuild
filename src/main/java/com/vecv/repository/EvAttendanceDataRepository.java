package com.vecv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vecv.entity.AttendanceData;

public interface EvAttendanceDataRepository extends JpaRepository<AttendanceData, Integer> {

	@Query(value = "SELECT * FROM attandance_data WHERE driverid =:driverId ORDER BY starttime ", nativeQuery = true)
	List<AttendanceData> findAllAttendanceByDriverId(@Param("driverId") Integer driverId);

	@Query(value = "SELECT * FROM attandance_data WHERE driverid =:driverId LIMIT 1", nativeQuery = true)
	AttendanceData findLatestAttendanceByDriverId(@Param("driverId") Integer driverId);

	@Query(value = "SELECT * FROM attandance_data WHERE driverid =:driverId AND date = CURRENT_DATE LIMIT 1", nativeQuery = true)
	AttendanceData findTodayAttendanceByDriverId(@Param("driverId") Integer driverId);

//	@Query(value = "INSERT INTO attandance_data(driverid, date, day, starttime, startlocation)"
//			+ " VALUES (:driverId, NOW(), :day, NOW(), :checkedInLocation)")
//	void saveCheckedInRecord(@Param("driverId") Integer driverId, @Param("checkedInLocation") String checkedInLocation,
//			@Param("day") String day);
//
//	@Query(value = "UPDATE attandance_data SET endtime =NOW(), endlocation =:checkedOutLocation WHERE id =:attendanceDataId")
//	void saveCheckedOutRecord(@Param("attendanceDataId") Integer attendanceDataId,
//			@Param("checkedOutLocation") String checkedInLocation);

}
