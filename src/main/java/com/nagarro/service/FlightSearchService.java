package com.nagarro.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.FlightDao;
import com.nagarro.dto.Flight;
import com.nagarro.utilities.DateParser;

/**
 * FlightSearch class searches flights according to user's input.
 * 
 * @author sahilmehta02
 *
 */
@Service
public class FlightSearchService {

	@Autowired
	private FlightDao flightdao;

	/**
	 * This method takes in arguments from the controller method and passes it to
	 * the dao layer to get the list of matching flights.
	 * 
	 * @param arrivalLocation
	 * @param departLocation
	 * @param date
	 * @param flightClass
	 * @return List of matching flights.
	 */
	public List<Flight> getSearchResult(String arrivalLocation, String departLocation, String date,
			String flightClass) {
		List<Flight> searchResult;

		Date flightDate = DateParser.getDate(date);

		searchResult = flightdao.getFlights(arrivalLocation, departLocation, flightDate, flightClass);

		return searchResult;
	}

}
