	package com.nagarro.daoImp;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.dao.Dao;
import com.nagarro.dao.FlightDao;
import com.nagarro.dto.Flight;

public class FlightDaoImp implements FlightDao {

	final static Logger LOG = Logger.getLogger(FlightDaoImp.class);

	@Autowired
	private Dao dao;

	/**
	 * This method adds a flight object to the Flight table in database.
	 */
	public void addFlight(Flight flight) {
		LOG.info("Adding new flight : " + flight.getFlightId());

		dao.begin();

		dao.getSession().save(flight);

		dao.commit();
		dao.close();

		LOG.info(flight.getFlightId() + " flight added successfully.");
	}

	/**
	 * This method searches for flights that match the method parameters i.e. the
	 * user input. predicate is an array of all the restriction that are used to
	 * filter the flights according to user input.
	 */
	public List<Flight> getFlights(String arrivalLocation, String departLocation, Date flightDate, String flightClass) {
		LOG.info("Searching for flights according to user's input.");

		dao.begin();

		CriteriaBuilder criteriaBuilder = dao.getSession().getCriteriaBuilder();
		CriteriaQuery<Flight> criteriaQuery = criteriaBuilder.createQuery(Flight.class);
		Root<Flight> root = criteriaQuery.from(Flight.class);

		Predicate[] predicates = new Predicate[4];

		predicates[0] = criteriaBuilder.equal(root.get("departLocation"), departLocation);
		predicates[1] = criteriaBuilder.equal(root.get("arrivalLocation"), arrivalLocation);

		Path<Date> flightDatePath = root.get("flightDate");
		predicates[2] = criteriaBuilder.greaterThanOrEqualTo(flightDatePath, flightDate);

		ParameterExpression<String> p = criteriaBuilder.parameter(String.class, "flightClass");
		predicates[3] = criteriaBuilder.like(root.<String>get("flightClass"), "%" + flightClass + "%");

		criteriaQuery.select(root).where(predicates);
		
		Query<Flight> query = dao.getSession().createQuery(criteriaQuery);
		List<Flight> searchResult = query.getResultList();

		dao.commit();
		dao.close();

		return searchResult;
	}

	/**
	 * This method fetches distinct toAirportCodes i.e. Arrival Location.
	 * 
	 * @return List of distinct Arrival Locations
	 */
	public List<String> getArrivalLocations() {
		LOG.info("Retrieving distinct arrival locations.");

		List<String> arrivalLocations;

		dao.begin();
		CriteriaBuilder criteriaBuilder = dao.getSession().getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
		Root<Flight> root = criteriaQuery.from(Flight.class);
		criteriaQuery.multiselect(root.get("arrivalLocation")).distinct(true);

		arrivalLocations = dao.getSession().createQuery(criteriaQuery).getResultList();

		return arrivalLocations;
	}

	/**
	 * This method fetches distinct fromAirportCodes i.e. Departure Location.
	 * 
	 * @return List of distinct Departure locations.
	 */
	public List<String> getDepartureLocations() {
		LOG.info("Retrieving distinct departure locations.");

		List<String> departLocations;

		dao.begin();
		CriteriaBuilder criteriaBuilder = dao.getSession().getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
		Root<Flight> root = criteriaQuery.from(Flight.class);
		criteriaQuery.multiselect(root.get("departLocation")).distinct(true);

		departLocations = dao.getSession().createQuery(criteriaQuery).getResultList();

		return departLocations;
	}

}
