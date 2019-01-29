package com.expedia.example.demo;

import java.time.LocalTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expedia.example.demo.model.Flight;
import com.expedia.example.demo.service.FlightService;
import com.expedia.example.demo.util.TimeUtils;

@Controller
@RestController
public class FlightController {

	@Autowired
	private FlightService flightService;

	@RequestMapping("/flights")
	public List<Flight> search(@RequestParam(value = "departTime") String searchTimeStr) throws Exception {
		
		LocalTime searchTime = TimeUtils.toLocalTime(searchTimeStr);
		
		return flightService.searchFlight(searchTime);
		
	}
}
