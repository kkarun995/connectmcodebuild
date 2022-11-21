package com.vecv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vecv.entity.TripData;

public interface EvTripDataRepository extends JpaRepository<TripData, Integer> {

}
