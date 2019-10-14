package com.nagarro.service;

import java.util.Comparator;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.nagarro.dto.Flight;

/**
 * FlightComparator class generates Comparator according to user's output
 * preference.
 * 
 * @author sahilmehta02
 *
 */

@Service
public class FlightComparatorService {

	final static Logger LOG = Logger.getLogger(FlightComparatorService.class);

	/**
	 * This method creates and returns a Comparator that sorts the flights by fare.
	 * 
	 * @return Comparator class that sort by fare.
	 */
	public Comparator<Flight> getFlightComparatorbyFare() {
		LOG.info("Creating Comparator to by sort by Fare.");

		return (flight1, flight2) -> {
			return Double.compare(flight1.getFare(), flight2.getFare());
		};

	}

	/**
	 * This method creates and returns a Comparator that sorts the flights by fare
	 * and flight duration.
	 * 
	 * @return Comparator class that sort by fare and flight duration.
	 */
	public Comparator<Flight> getFlightComparatorbyFareDuration() {
		LOG.info("Creating Comparator to by sort by Fare & Flight Duration.");

		return (flight1, flight2) -> {
			int sortLevel1 = Double.compare(flight1.getFare(), flight2.getFare());
			if (sortLevel1 == 0) {
				int sortLevel2 = Double.compare(flight1.getFlightDuration(), flight2.getFlightDuration());
				return sortLevel2;
			}
			return sortLevel1;
		};
		
	}
}
