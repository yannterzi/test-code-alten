package com.meriakri.expedia;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExpediaAssigment18ApplicationTests {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("MM/yy");
	@Test
	public void contextLoads() {
	}
//	@Test
//	public void testDate() {
//	   
//	  
//		CharSequence value = "05/19";
//		
//		YearMonth yearMonth = YearMonth.parse(value, DATE_TIME_FORMATTER);
//		
//		LocalDate now = LocalDate.now();
//		for (int i = 0; i < 100; i++) {
//		    
//		YearMonth from = YearMonth.from(now);
//		System.out.println(now +":"+from+":"+yearMonth+":"+yearMonth.isAfter(from));
//		now=now.plusDays(1);
//		}
//		
//	   
//	    
//	}
	

}
