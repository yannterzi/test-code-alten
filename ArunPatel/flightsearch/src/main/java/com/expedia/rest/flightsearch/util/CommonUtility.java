package com.expedia.rest.flightsearch.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.expedia.rest.flightsearch.exception.InvalidSearchCriteriaException;

/**
 * The CommonUtility is  utility class which provide the functionality which is used across the application
 *
 * @author Arun Patel
 * @version 1.0
 * @since 2019-01-22
 */

public class CommonUtility {

	
	/**
	 * convert24Time method is used to convert the 12 format to 24 hour format.
	 * 
	 * @param time it represents the 12 hour format time
	 * @return It will return the 24 hour format time.
	 * @exception It will throw InvalidSearchCriteriaException if the time is not in proper format
	 */
	public static String convert24Time(String time) {
		try {
			return LocalTime.parse(time, DateTimeFormatter.ofPattern("h:mma", Locale.US))
					.format(DateTimeFormatter.ofPattern("HH:mm"));	
		}catch(Exception e) {
			throw new InvalidSearchCriteriaException("Invalid Search Criteria", "Provide Request Parameter Time in hh:mmAM/PM format");
		}
		
	}

	/**
	 * formatTime method is used to format the 12 hour format time.
	 * 
	 * @param time it represents the 12 hour format time
	 * @return It will return the 12 hour format time in proper format.
	 * @exception It will throw InvalidSearchCriteriaException if the time is not in proper format
	 */
	
	public static String formatTime(String time) {		
		StringBuffer sb = new StringBuffer();
		try {
			time = time.toUpperCase();
			if (time.contains("PM") || time.contains("AM")) {
				if (time.contains(":")) {
					sb.append(String.format("%02d", Integer.parseInt(time.split(":")[0])));
					sb.append(":");
					if (time.contains("PM")) {
						sb.append(String.format("%02d",
								Integer.parseInt(time.substring(time.indexOf(":") + 1, time.indexOf("PM")))));
						sb.append("PM");
					} else {
						sb.append(String.format("%02d",
								Integer.parseInt(time.substring(time.indexOf(":") + 1, time.indexOf("AM")))));
						sb.append("AM");
					}
				} else {
					if (time.contains("PM")) {
						sb.append(String.format("%02d", Integer.parseInt(time.substring(0, time.indexOf("PM")))));
						sb.append(":00");
						sb.append("PM");
					} else {
						sb.append(String.format("%02d", Integer.parseInt(time.substring(0, time.indexOf("AM")))));
						sb.append(":00");
						sb.append("AM");
					}
				}
			}
			return sb.toString();
		} catch (Exception e) {
			throw new InvalidSearchCriteriaException("Invalid Search Criteria", "Provide Request Parameter Time in hh:mmAM/PM format");
		}

	}

}
