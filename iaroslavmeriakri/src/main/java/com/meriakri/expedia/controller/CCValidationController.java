package com.meriakri.expedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meriakri.expedia.model.CreditCard;
import com.meriakri.expedia.service.CreditCardNormalizationService;
import com.meriakri.expedia.service.ValidationService;

@RestController
@RequestMapping("/v1/validation/")
public class CCValidationController {
    @Autowired
    private ValidationService<CreditCard> validationService;
    @Autowired
    private CreditCardNormalizationService creditCardNormalizationService; 
    
    // CREATE
    @PostMapping(value = "/creditCard")
    public boolean validationCC(@RequestBody CreditCard creditCard) {
	CreditCard normalized = creditCardNormalizationService.normalize(creditCard);
	return validationService.validate(normalized);
    }
}
