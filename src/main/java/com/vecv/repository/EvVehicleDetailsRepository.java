package com.vecv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vecv.entity.VehicleDetails;

public interface EvVehicleDetailsRepository extends JpaRepository<VehicleDetails, Integer> {

	@Query(value = "SELECT * FROM vehicle_details_master WHERE id =:id", nativeQuery = true)
	VehicleDetails findByVehicleId(@Param("id") Integer vehicleId);
}
