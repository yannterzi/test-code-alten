package com.expedia.main.services;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * @author Sachin
 *
 *Read Inventory JSON file 
 */
@Component
public class ReadFlightInventoryFile {
	private static final Logger logger = LogManager.getLogger(GetFlights.class);
	
	@Value("${expedia.inventoryFileName}")
	private String flightInventoryFileName;

	public String getInventoryJsonArray() {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		JSONArray array = null;
		try {
			Object obj = parser.parse(new FileReader(flightInventoryFileName));
			jsonObject = (JSONObject) obj;
			array = (JSONArray) jsonObject.get("flights");

		} catch (FileNotFoundException e) {
			
			logger.error(e.getMessage());
		} catch (IOException e) {
			
			logger.error(e.getMessage());
		} catch (ParseException e) {
	
			logger.error(e);
		}

		return array.toString();

	}
}
