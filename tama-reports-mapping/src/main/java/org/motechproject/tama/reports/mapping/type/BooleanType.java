package org.motechproject.tama.reports.mapping.type;

public class BooleanType {

    public static final String TRUE_VALUE = "Y";
    public static final String FALSE_VALUE = "N";

    public static String valueOf(boolean value) {
        return (value) ? TRUE_VALUE : FALSE_VALUE;
    }
}
