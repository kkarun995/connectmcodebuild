package com.vecv.service;

import com.vecv.core.exception.EvServiceException;
import com.vecv.dao.RouteDetailsDao;
import com.vecv.dao.VehicleLiveDetailsDao;

public interface EvRouteService {

	public RouteDetailsDao getRouteDetails(Integer driverId, Integer tripId) throws EvServiceException;

	public VehicleLiveDetailsDao getVehicleLiveDetails(Integer driverId, Integer tripId, Integer vehicleId) throws EvServiceException;
}
