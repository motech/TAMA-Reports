package org.motechproject.tama.reports.domain.builder;


import org.joda.time.DateTime;
import org.motechproject.tama.reports.domain.PatientEvent;

public class PatientEventBuilder {

    public static PatientEvent validEvent() {
        PatientEvent event = new PatientEvent();
        event.setPatientDocumentId("patientDocumentId");
        event.setEventName("eventName");
        event.setDateTime(DateTime.now().toDate());
        event.setPerformedBy("performer");
        return event;
    }
}
