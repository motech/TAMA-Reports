package org.motechproject.tama.reports.contract.builder;


import org.joda.time.LocalDate;
import org.motechproject.tama.reports.contract.PatientRequest;

public class PatientRequestBuilder {

    public static PatientRequest validRequest() {
        PatientRequest request = new PatientRequest();
        request.setBestCallTime("10:10:00");
        request.setPatientDocumentId("patientDocId");
        request.setCallPreference("DPR");
        request.setIvrLanguage("en");
        request.setReceiveAppointmentReminder(true);
        request.setReceiveOTCAdvice(true);
        request.setClinicId("clinicId");
        request.setDateOfBirth(LocalDate.now().toDate());
        request.setGender("m");
        request.setIvrPassCode("1234");
        request.setPatientId("patientId");
        request.setTravelTimeToClinic("travelTime");
        return request;
    }
}
