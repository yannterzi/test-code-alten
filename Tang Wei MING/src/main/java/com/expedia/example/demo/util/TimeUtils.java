package com.expedia.example.demo.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils {

	public static LocalTime toLocalTime(String timeStr) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mma");

		return LocalTime.parse(timeStr, formatter);
	}
	
	public static int getMinutesFromStartOfDay(LocalTime time) {
		
		if(time==null) {
			return 0;
		}
		
		return time.getHour() * 60 + time.getMinute();
	}
	
	public static int getMinutesFromStartOfDay(String timeStr) {
		LocalTime time = toLocalTime(timeStr);
		return getMinutesFromStartOfDay(time);
	}
}
