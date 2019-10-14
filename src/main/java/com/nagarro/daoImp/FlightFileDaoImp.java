package com.nagarro.daoImp;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.dao.Dao;
import com.nagarro.dao.FlightFileDao;
import com.nagarro.dto.FlightFile;

public class FlightFileDaoImp implements FlightFileDao {

	final static Logger LOG = Logger.getLogger(FlightFileDaoImp.class);

	@Autowired
	Dao dao;

	public List<FlightFile> getAllFlightFiles() {
		LOG.info("Retrieving all FlightFile object of read files.");

		dao.begin();

		Criteria criteria = dao.getSession().createCriteria(FlightFile.class);
		List<FlightFile> flightFiles = (List<FlightFile>) criteria.list();

		dao.commit();
		dao.close();

		LOG.info("Retrieved all FlightFile objects of read files successfully.");
		return flightFiles;
	}

	public FlightFile getFlightFile(String fileName) {
		LOG.info("Retrieving FlightFile object of : " + fileName);

		dao.begin();

		FlightFile flightFile = (FlightFile) dao.getSession().get(FlightFile.class, fileName);

		dao.commit();
		dao.close();
		
		LOG.info("Retrieved FlightFile object of " + fileName + " successfully.");
		return flightFile;
	}

	public void updateFlightFile(FlightFile flightFile) {
		LOG.info("Updating FlightFile object of " + flightFile.getFileName());
		
		dao.begin();

		dao.getSession().update(flightFile);

		dao.commit();
		dao.close();
		
		LOG.info("Updated FlightFile object of " + flightFile.getFileName() + " successfully.");
	}

	public void addFlightFile(FlightFile newFlightFile) {
		LOG.info("Adding FlightFile object of " + newFlightFile.getFileName());
		
		dao.begin();

		dao.getSession().save(newFlightFile);

		dao.commit();
		dao.close();

		LOG.info("Added FlightFile object of " + newFlightFile.getFileName() + " successfully.");
	}

}
