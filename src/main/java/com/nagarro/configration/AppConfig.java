package com.nagarro.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.nagarro.dao.Dao;
import com.nagarro.dao.FlightDao;
import com.nagarro.dao.FlightFileDao;
import com.nagarro.dao.UserDao;
import com.nagarro.daoImp.DaoImp;
import com.nagarro.daoImp.FlightDaoImp;
import com.nagarro.daoImp.FlightFileDaoImp;
import com.nagarro.daoImp.UserDaoImp;
import com.nagarro.service.AirportCodeLoaderService;
import com.nagarro.service.FlightComparatorService;
import com.nagarro.service.FlightLoaderService;
import com.nagarro.service.FlightSearchService;
import com.nagarro.service.OutputPreferanceService;
import com.nagarro.service.UserService;;

@Configuration
@EnableScheduling
public class AppConfig {

	@Bean
	public Dao getDao() {
		return new DaoImp();
	}

	@Bean
	public UserDao getUserDao() {
		return new UserDaoImp();
	}

	@Bean
	public FlightDao getFlightDao() {
		return new FlightDaoImp();
	}

	@Bean
	public FlightLoaderService getFlightLoader() {
		return new FlightLoaderService();
	}
	
	@Bean
	public FlightSearchService getFlightSearch() {
		return new FlightSearchService();
	}

	@Bean
	public FlightFileDao getFlightFileDao() {
		return new FlightFileDaoImp();
	}

	@Bean
	public AirportCodeLoaderService getAirportCodeLoader() {
		return new AirportCodeLoaderService();
	}
	
	@Bean
	public OutputPreferanceService getOutputPreferance() {
		return new OutputPreferanceService();
	}
	
	@Bean
	public FlightComparatorService getFlightComparator() {
		return new FlightComparatorService();
	}
	
	@Bean
	public UserService getUserService() {
		return new UserService();
	}

}
