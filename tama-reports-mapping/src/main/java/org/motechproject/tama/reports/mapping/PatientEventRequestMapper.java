package org.motechproject.tama.reports.mapping;


import org.motechproject.tama.reports.contract.PatientEventRequest;
import org.motechproject.tama.reports.domain.PatientEvent;

public class PatientEventRequestMapper {

    private PatientEventRequest request;

    public PatientEventRequestMapper(PatientEventRequest request) {
        this.request = request;
    }

    public PatientEvent map() {
        PatientEvent patientEvent = new PatientEvent();
        patientEvent.setPatientDocumentId(request.getPatientDocumentId());
        patientEvent.setEventName(request.getEventName());
        patientEvent.setDateTime(request.getDateTime());
        patientEvent.setNewValue(request.getNewValue());
        patientEvent.setPerformedBy(request.getPerformedBy());
        return patientEvent;
    }
}
