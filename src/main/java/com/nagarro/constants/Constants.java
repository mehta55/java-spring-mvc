package com.nagarro.constants;

import java.text.SimpleDateFormat;

public class Constants {

	public static final String DATEFORMAT = "yyyy-MM-dd";
	public static final String FOLDERPATH = "C:\\Users\\sahilmehta02\\Documents\\Adv JAVA\\Assignment Links\\Assignment Links";
	

	public static SimpleDateFormat getDateFormatter() {
		return new SimpleDateFormat(DATEFORMAT);
	}

}
