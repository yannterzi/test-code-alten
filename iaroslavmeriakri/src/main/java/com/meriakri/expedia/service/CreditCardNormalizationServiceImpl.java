package com.meriakri.expedia.service;

import static com.meriakri.expedia.service.Strings.REMOVE_SPACE;

import org.springframework.stereotype.Component;

import com.google.common.base.Preconditions;
import com.meriakri.expedia.model.CreditCard;
@Component
public class CreditCardNormalizationServiceImpl implements CreditCardNormalizationService {
    
    @Override
    public CreditCard normalize(CreditCard creditCard) {
	CreditCard card =new CreditCard();
	card.setExpiration(Preconditions.checkNotNull(creditCard.getExpiration(),"Credit card must have expiration date"));
	String string = Preconditions.checkNotNull(creditCard.getNumber(),"Credit card must have number");
	string=REMOVE_SPACE(string);
	Preconditions.checkArgument(string.length()==16, "Credit card must have %s characters", 16);
	card.setNumber(string);
	return card;
    }
    
}
