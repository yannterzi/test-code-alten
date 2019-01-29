package com.expedia.example.demo.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expedia.example.demo.model.Flight;
import com.expedia.example.demo.repository.FlightRepository;
import com.expedia.example.demo.util.TimeUtils;

@Service
public class FlightService {

	@Autowired
	FlightRepository repository;
	
	/**
	 *  We think the flight does not have date info, only have time,
	 *  so it implies every day.So we decide the time range to check, 
	 *  the range could partly fall into previous day or the next day.
	 *  This method will handle these situation.
	 *   
	 * @param time
	 * @return
	 */
	public List<Flight> searchFlight(LocalTime time) {
		
		int minute = TimeUtils.getMinutesFromStartOfDay(time);
		
		int startTimeInMinute = minute-300;
		int endTimeInMinute = minute+300;
		
		if(startTimeInMinute>=0 && endTimeInMinute<FlightRepository.ONE_DAY_IN_MINUTES) {
			
			return repository.getFlights(startTimeInMinute, endTimeInMinute);
			
		} else if(startTimeInMinute<0) {
			
			List<Flight> flights = repository.getFlights(0, endTimeInMinute);
			
			flights.addAll(repository.getFlights(FlightRepository.ONE_DAY_IN_MINUTES-1+startTimeInMinute, FlightRepository.ONE_DAY_IN_MINUTES-1));
			
			return flights;
			
		} else  {
			
			// here, it means endTimeInMinute>=FlightRepository.ONE_DAY_IN_MINUTES
			
			List<Flight> flights = repository.getFlights(startTimeInMinute, FlightRepository.ONE_DAY_IN_MINUTES-1);
			
			flights.addAll(repository.getFlights(0, endTimeInMinute-FlightRepository.ONE_DAY_IN_MINUTES));
			
			return flights;
		}
		
	}

}
