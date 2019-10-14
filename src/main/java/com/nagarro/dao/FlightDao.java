package com.nagarro.dao;

import java.util.Date;
import java.util.List;

import com.nagarro.dto.Flight;

public interface FlightDao {

	public void addFlight(Flight flight);

	public List<Flight> getFlights(String arrivalLocation, String departLocation, Date flightDate, String flightClass);
	
	public List getArrivalLocations();
	
	public List getDepartureLocations();
}
