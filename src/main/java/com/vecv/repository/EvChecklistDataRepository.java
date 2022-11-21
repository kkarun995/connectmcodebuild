package com.vecv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vecv.entity.ChecklistData;

public interface EvChecklistDataRepository extends JpaRepository<ChecklistData, Integer> {

	@Query(value = "SELECT * FROM checklist_data WHERE id =:id", nativeQuery = true)
	ChecklistData findByDriverId(@Param("id") Integer driverId);

	@Query(value = "SELECT * FROM checklist_data WHERE tripid =:id", nativeQuery = true)
	List<ChecklistData> findByTripId(@Param("id") Integer id);
}
