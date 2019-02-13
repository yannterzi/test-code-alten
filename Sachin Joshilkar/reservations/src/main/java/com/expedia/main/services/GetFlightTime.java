package com.expedia.main.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class GetFlightTime {
	private static final Logger logger = LogManager.getLogger(GetFlightTime.class);
	public List<Integer> getFlightTime(String time, ArrayList<String> inventoryDates) throws ParseException {
       // add spacing in Departure hours and am/pm
		int timeLength = time.length();
		char toCheckSpacePosition = time.charAt(timeLength - 3);

		if (!(toCheckSpacePosition == ' '))
			time = time.substring(0, timeLength - 2) + " " + time.substring(timeLength - 2, timeLength);

		return getDeparturePositionsWithinFiveHours(time, inventoryDates);

	}

	//get index positions of next five hours flight from Inventory JSON 
	private List<Integer> getDeparturePositionsWithinFiveHours(String time, ArrayList<String> inventoryDates) {
		ArrayList<Integer> newDates = new ArrayList<Integer>();

		try {
			DateFormat inputFormat = new SimpleDateFormat("hh:mm a");
			Date dt = inputFormat.parse(time);
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date(dt.getTime()));
			cal.add(Calendar.HOUR_OF_DAY, 5);
			cal.getTime();

			SimpleDateFormat parser = new SimpleDateFormat("hh:mm a");
			Date ten = parser.parse(time);

			Iterator<String> it = inventoryDates.iterator();
			int i = 0;
			while (it.hasNext()) {
				String listDate = it.next().toString();

				String trimdate = listDate.substring(0, listDate.length() - 2) + " "
						+ listDate.substring(listDate.length() - 2, listDate.length());

				Date userDate = parser.parse(trimdate);
				if (userDate.after(ten) && userDate.before(cal.getTime())) {
					newDates.add(i);
					System.out.println("Trim Dates " + newDates);
				}
				i++;
			}

		} catch (ParseException e) {
			
			logger.error(e);
		}
		return newDates;

	}

}
