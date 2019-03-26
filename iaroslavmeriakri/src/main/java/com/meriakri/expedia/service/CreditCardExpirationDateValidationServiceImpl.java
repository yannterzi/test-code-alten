package com.meriakri.expedia.service;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public  class CreditCardExpirationDateValidationServiceImpl implements CreditCardExpirationValidationService {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("MM/yy");
    @Override
    public boolean validate(String value) {
	YearMonth yearMonth = YearMonth.parse(value, DATE_TIME_FORMATTER);
	if(YearMonth.now().isAfter(yearMonth)) {
	    throw new IllegalArgumentException("Credit card must have valid expiration date");
	}
	return true;
    }
    
}
