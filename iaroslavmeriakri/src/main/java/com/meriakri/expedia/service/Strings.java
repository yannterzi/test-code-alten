package com.meriakri.expedia.service;

import java.util.regex.Pattern;

public class Strings {
    private static final Pattern PATTERN_SPACE=Pattern.compile("\\s+");
    private static final String  EMPTY="";
    public static final String REMOVE_SPACE(String string) {
	return PATTERN_SPACE.matcher(string).replaceAll(EMPTY);
    }
}
