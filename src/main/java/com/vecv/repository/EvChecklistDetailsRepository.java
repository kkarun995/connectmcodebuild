package com.vecv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vecv.entity.ChecklistDetails;
import com.vecv.entity.DriverDetails;

public interface EvChecklistDetailsRepository extends JpaRepository<ChecklistDetails, Integer> {

	@Query(value = "SELECT * FROM driver_details WHERE id =:id", nativeQuery = true)
	DriverDetails findByDriverId(@Param("id") Integer driverId);

	@Query(value = "SELECT * FROM checklist_details WHERE id =:id", nativeQuery = true)
	ChecklistDetails findByChecklistDetailsId(@Param("id") Integer checklistId);
}
