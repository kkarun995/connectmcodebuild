package com.vecv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vecv.entity.UserDetails;

public interface EvUserRepository extends JpaRepository<UserDetails, Integer> {

	@Query(value = "SELECT * FROM user_details WHERE phoneNumber=:phoneNumber LIMIT 1", nativeQuery = true)
	UserDetails findByPhoneNumber(@Param("phoneNumber") String phoneNumber);

	@Query(value = "SELECT * FROM user_details WHERE driverid=:driverid", nativeQuery = true)
	UserDetails findByDriverId(@Param("driverid") Integer id);

}
