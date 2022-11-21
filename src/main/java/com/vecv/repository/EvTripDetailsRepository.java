package com.vecv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vecv.entity.TripDetails;

public interface EvTripDetailsRepository extends JpaRepository<TripDetails, Integer> {

	@Query(value = "SELECT * FROM trip_details WHERE driverid =:id AND starttime > now()"
			+ " AND checkedin IS NOT TRUE LIMIT 1", nativeQuery = true)
//	@Query(value = "SELECT * FROM trip_details WHERE driverid =:id AND to_char(starttime::time,'HH24:MI') > to_char(now()::time,'HH24:MI')"
//			+ " LIMIT 1", nativeQuery = true)
	TripDetails findUpcomingTripByDriverId(@Param("id") Integer driverId);

}
