package com.expedia.main.services;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.expedia.main.model.FlightDetailModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Sachin
 *
 */


@Component
public class GetFlights {
	private static final Logger logger = LogManager.getLogger(GetFlights.class);
	
	@Autowired
	private ReadFlightInventoryFile getjson;
	
	@Autowired
	private GetFlightTime time;
	private int getDepartureposition;
	
	
	
	public ArrayList<FlightDetailModel> getAvailableFlights(String departure) throws ParseException {
		ArrayList<FlightDetailModel> getFlights = new ArrayList<FlightDetailModel>();
		ArrayList<String> listDeparture=new ArrayList<String>();
		
		//Map Inventory JSON to model class 
		ObjectMapper mapper=new ObjectMapper()
   			 .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
   	
   	try {
		List<FlightDetailModel> listFlights = mapper.readValue(getjson.getInventoryJsonArray(), new TypeReference<List<FlightDetailModel>>(){});
		for (FlightDetailModel reader : listFlights) {
			listDeparture.add(reader.getDeparture());
		
		}
		
		//Iterate Index position to get next Five hours Flights
		List<Integer> getPositions=time.getFlightTime(departure, listDeparture);
		Iterator<Integer> it=getPositions.iterator();
		listDeparture.clear();
		while(it.hasNext())
		{
			getDepartureposition=(Integer)it.next();
			getFlights.add(new FlightDetailModel(listFlights.get(getDepartureposition).getFlight(),listFlights.get(getDepartureposition).getDeparture()));
		}
	} catch (IOException e) {
		logger.error("GetFlight ",e);
	}
		
		return getFlights;
	}

}
