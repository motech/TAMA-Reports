package org.motechproject.tama.reports.web.excel;

import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang.StringUtils.isBlank;

public class ReportParameters {

    private Map parameters;

    public ReportParameters() {
        parameters = new HashMap();
    }

    public void exactMatchParameter(String name, String value, boolean optional) {
        if (optional) {
            parameters.put(name, (isBlank(value) ? "%" : value));
        } else {
            parameters.put(name, value);
        }
    }

    public void subStringMatchParameter(String name, String value, boolean optional) {
        String subStringMatchCriteria = "%" + value + "%";
        if (optional) {
            parameters.put(name, (isBlank(value) ? "%" : subStringMatchCriteria));
        } else {
            parameters.put(name, subStringMatchCriteria);
        }
    }

    public Map getParameters() {
        return parameters;
    }
}
