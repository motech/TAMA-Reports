package org.motechproject.tama.reports.web.excel;


import org.motechproject.tama.reports.domain.export.ReportParameters;

import java.util.HashMap;
import java.util.Map;

public class ClinicianParameters implements ReportParameters {

    @Override
    public Map parameters() {
        return new HashMap();
    }
}
