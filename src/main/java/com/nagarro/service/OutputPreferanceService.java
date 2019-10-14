package com.nagarro.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dto.Flight;

/**
 * OutputPreferance class sorts the search result according to the user's
 * preference.
 * 
 * @author sahilmehta02
 *
 */
@Service
public class OutputPreferanceService {

	final static Logger LOG = Logger.getLogger(OutputPreferanceService.class);

	@Autowired
	private FlightComparatorService flightComparator;

	/**
	 * Sorts flights collection by user's output preference after retrieving
	 * appropriate comparator from FlightComparator class.
	 * 
	 * @param searchResult List of Flights matching user's input.
	 * @param sortBy       user's output preference.
	 */
	public void sortFlights(List<Flight> searchResult, int sortBy) {
		LOG.info("Sorting search result according to output preference.");

		Comparator<Flight> comparator;

		if (sortBy == 1) {
			comparator = flightComparator.getFlightComparatorbyFare();
			Collections.sort(searchResult, comparator);
		} else {
			comparator = flightComparator.getFlightComparatorbyFareDuration();
			Collections.sort(searchResult, comparator);
		}

	}
}
