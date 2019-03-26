package com.meriakri.expedia.service;

import static com.meriakri.expedia.service.Strings.REMOVE_SPACE;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.google.common.collect.Sets;
import com.google.gson.Gson;

@Component
public class CreditCardNumberBlackListValidationServiceImpl implements CreditCardNumberValidationService {
    @Value("${blacklist.file}")
    private String blacklists;
    private Gson gson = new Gson();
    private static Set<String> blacklist = Sets.newHashSet();
    
    private static final class Bl {
	List<String> blacklist;
    }
    
    @PostConstruct
    private void load() {
	ClassPathResource classPathResource = new ClassPathResource(blacklists);
	try {
	    Bl bl = gson.fromJson(new InputStreamReader(classPathResource.getInputStream()), Bl.class);
	    bl.blacklist.forEach(e -> blacklist.add(REMOVE_SPACE(e)));
	} catch (Exception e) {
	    
	    e.printStackTrace();
	}
    };
    
    @Override
    public boolean validate(String value) {
	if(blacklist.contains(value)) {
	    throw new IllegalArgumentException("Credit card number is blacklisted");
	}
	return true;
    }
    
}
