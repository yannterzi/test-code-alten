package com.expedia.example.demo.repository;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.expedia.example.demo.model.Flight;
import com.expedia.example.demo.model.Flights;
import com.fasterxml.jackson.databind.ObjectMapper;


@Repository
public class FlightRepository {

	public final static int ONE_DAY_IN_MINUTES = 1440;

	// key is the number of minutes from start of the day
	// for example, 7:30am,, key is 7*60+40=460

	// since in json file , the depart time only has time, no date,
	// I regard its meanning as flight scheduled everyday same time.

	private final TreeMap<Integer, List<Flight>> flights;

	private ObjectMapper mapper = new ObjectMapper();

	public FlightRepository() throws Exception {
		
		String content = loadRepositoryFile();
		
		Flights flightsInRepository = mapper.readValue(content, Flights.class);
		
		flights = flightsInRepository.getFlights().stream().collect(Collectors.groupingBy(Flight::minutesFromStartOfTheDay, TreeMap::new, Collectors.toList()));
		
	}

	/**
	 * 
	 * @param startMinutes
	 *            inclusive
	 * @param endMinutes
	 *            inclusive
	 * @return flights in range
	 */
	public List<Flight> getFlights(int startMinute, int endMinute) {

		if (startMinute < 0) {
			throw new IllegalArgumentException("start time out of range");
		}

		if (endMinute > ONE_DAY_IN_MINUTES-1) {
			throw new IllegalArgumentException("end time out of range");
		}

		SortedMap<Integer, List<Flight>> foundFlights = flights.subMap(startMinute, endMinute + 1);
		if (foundFlights == null || foundFlights.isEmpty()) {
			return new ArrayList<Flight>();
		}

		return foundFlights.values().stream().flatMap(flights->flights.stream()).collect(Collectors.toList());

	}
	
	private String loadRepositoryFile() throws IOException, URISyntaxException{
		try {
			return loadExternalFile("repositoryFile");
		} catch(Exception  ex) {
			return loadFile("/flights.json");
		}
		
	}
	
	private String loadExternalFile(String propName) throws IOException, URISyntaxException {

		String filePathName = System.getProperty(propName);
		
		Path path = Paths.get(filePathName);
		
		return new String(Files.readAllBytes(path));
	}

	private String loadFile(String resourceName) throws IOException, URISyntaxException {

		Path path = Paths.get(FlightRepository.class.getResource(resourceName).toURI());

		return new String(Files.readAllBytes(path));
	}
	
}
