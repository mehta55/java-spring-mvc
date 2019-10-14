package com.nagarro.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.nagarro.constants.Constants;


public class DateParser {

	final static Logger LOG = Logger.getLogger(DateParser.class);
	
	private static SimpleDateFormat formatter;

	public static Date getDate(String stringDate) {
		LOG.info("Parsing String date " + stringDate +"to Date Object.");
		
		Date date = null;

		try {
			formatter = Constants.getDateFormatter();
			date = formatter.parse(stringDate);
		} catch (ParseException parseException) {
			LOG.error("Exception occured while parsing String date " + stringDate +"to Date Object.");
		}

		LOG.info("Parsed String date " + stringDate +"to Date Object successfully.");
		return date;
	}
}
