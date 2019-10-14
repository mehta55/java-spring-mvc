package com.nagarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.FlightDao;

/**
 * This class is used to fetch distinct arrival and departure locations using
 * FlightDao that will be populated in the drop down in the search screen.
 * 
 * @author sahilmehta02
 *
 */
@Service
public class AirportCodeLoaderService {

	@Autowired
	private FlightDao flightdao;

	/**
	 * This method fetches distinct fromAirportCodes i.e. Departure Location.
	 * 
	 * @return List of distinct Departure locations.
	 */
	public List<String> getFromAirportCodes() {
		List<String> fromAirportCodes;

		fromAirportCodes = flightdao.getDepartureLocations();

		return fromAirportCodes;
	}

	/**
	 * This method fetches distinct toAirportCodes i.e. Arrival Location.
	 * 
	 * @return List of distinct Arrival Locations
	 */
	public List<String> getToAirportCodes() {
		List<String> toAirportCodes;

		toAirportCodes = flightdao.getArrivalLocations();

		return toAirportCodes;
	}
}
