package org.motechproject.tama.reports.web.excel;


public class PatientEventParameters extends SearchByPatientAndClinicOverDateRange {

    public PatientEventParameters setEventName(String eventName) {
        super.exactMatchParameter("STATUS", eventName, true);
        return this;
    }
}
