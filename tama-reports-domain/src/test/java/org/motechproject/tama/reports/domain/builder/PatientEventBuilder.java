package org.motechproject.tama.reports.domain.builder;


import org.motechproject.tama.reports.domain.PatientEvent;
import org.motechproject.util.DateUtil;

public class PatientEventBuilder {

    public static PatientEvent validEvent() {
        PatientEvent event = new PatientEvent();
        event.setPatientDocumentId("patientDocumentId");
        event.setEventName("eventName");
        event.setDateTime(DateUtil.now().toDate());
        event.setPerformedBy("performer");
        return event;
    }
}
