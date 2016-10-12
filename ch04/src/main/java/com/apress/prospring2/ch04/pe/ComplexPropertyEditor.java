package com.apress.prospring2.ch04.pe;

import java.beans.PropertyEditorSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author janm
 */
public class ComplexPropertyEditor extends PropertyEditorSupport {
    private static final String MINUS_SIGN = "-";
    private static final String COMPLEX_UNIT = "j";
    private static final Pattern COMPLEX_PATTERN =
        Pattern.compile("([+\\-])?([0-9.]+)([j]?)", Pattern.CASE_INSENSITIVE);

    public void setAsText(String s) throws IllegalArgumentException {
        Matcher matcher = COMPLEX_PATTERN.matcher(s);
        Double re = null;
        Double im = null;
        while (matcher.find()) {
            if (COMPLEX_UNIT.equalsIgnoreCase(matcher.group(3))) {
                im = getValue(matcher);
            } else {
                re = getValue(matcher);
            }
        }
        if (re == null && im == null) {
            throw new IllegalArgumentException(
                "Cannot convert value " + s + " to " + Complex.class.getName());
        } else {
            setValue(new Complex(re, im));
        }
    }

    private double getValue(Matcher matcher) {
        double d;
        d = Double.parseDouble(matcher.group(2));
        if (MINUS_SIGN.equals(matcher.group(1))) d = -d;
        return d;
    }
}
