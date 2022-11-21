package com.vecv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vecv.entity.DriverDetails;

public interface EvDriverDetailsRepository extends JpaRepository<DriverDetails, Integer> {

	@Query(value = "SELECT * FROM driver_details WHERE id =:id", nativeQuery = true)
	DriverDetails findByDriverId(@Param("id") Integer driverId);
}
