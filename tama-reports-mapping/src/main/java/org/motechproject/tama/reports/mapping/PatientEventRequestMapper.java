package org.motechproject.tama.reports.mapping;


import org.motechproject.tama.reports.contract.PatientEventRequest;
import org.motechproject.tama.reports.domain.PatientEvent;

import static org.apache.commons.lang.StringUtils.isNotBlank;

public class PatientEventRequestMapper {

    private PatientEventRequest request;

    public PatientEventRequestMapper(PatientEventRequest request) {
        this.request = request;
    }

    public PatientEvent map() {
        PatientEvent patientEvent = new PatientEvent();
        patientEvent.setPatientDocumentId(request.getPatientDocumentId());
        patientEvent.setEventName(nonEmptyStringValue(request.getEventName()));
        patientEvent.setDateTime(request.getDateTime());
        patientEvent.setNewValue(nonEmptyStringValue(request.getNewValue()));
        patientEvent.setPerformedBy(nonEmptyStringValue(request.getPerformedBy()));
        return patientEvent;
    }

    private String nonEmptyStringValue(String value) {
        return isNotBlank(value) ? value : "";
    }
}
