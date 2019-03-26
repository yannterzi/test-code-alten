package com.meriakri.expedia.service;

import org.apache.commons.validator.routines.checkdigit.LuhnCheckDigit;
import org.springframework.stereotype.Component;

@Component
public  class CreditCardNumberLuhnCheckDigitValidationServiceImpl implements CreditCardNumberValidationService {
    @Override
    public boolean validate(String value) {	
	if(!LuhnCheckDigit.LUHN_CHECK_DIGIT.isValid(value)) {
	    throw new IllegalArgumentException("Credit card must have valid number");
	}
	return true;
    }
    
}
