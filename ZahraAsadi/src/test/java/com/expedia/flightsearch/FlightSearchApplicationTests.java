package com.expedia.flightsearch;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {FlightSearchApplication.class})
@ComponentScan(basePackages = "com.expedia.flightsearch")
public class FlightSearchApplicationTests {
	@Test
	public void contextLoads() {
	}

}
