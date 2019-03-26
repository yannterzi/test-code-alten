package com.meriakri.expedia.service;

import org.springframework.stereotype.Component;

@Component
public class CreditCardNumberValidationServiceImpl implements CreditCardNumberValidationService {
    
    @Override
    public boolean validate(String value) {
	char[] charArray = value.toCharArray();
	if (charArray[0] == '4')
	    return true;
	if (charArray[0] == '5' && charArray[1] >= '1' && charArray[1] <= '5')
	    return true;
	throw new IllegalArgumentException("Only Visa and MasterCard are accepted");	
    }
    
}
