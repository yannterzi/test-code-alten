package com.meriakri.expedia.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.meriakri.expedia.model.CreditCard;

@Component
public class CreditCardValidationServiceImpl implements ValidationService<CreditCard> {
    
    private final Set<CreditCardExpirationValidationService> setCCExp;
    private final Set<CreditCardNumberValidationService> setCCNumber;
    
    @Autowired
    public CreditCardValidationServiceImpl(Set<CreditCardExpirationValidationService> setCCExp, Set<CreditCardNumberValidationService> setCCNumber) {
	this.setCCExp = setCCExp;
	this.setCCNumber = setCCNumber;
	
    }
    
    @Override
    public boolean validate(CreditCard creditCard) {
	return 
		setCCNumber.stream().allMatch(v -> v.validate(creditCard.getNumber())) 
		&& 
		setCCExp.stream().allMatch(v -> v.validate(creditCard.getExpiration()))
		;
    }
    
}
