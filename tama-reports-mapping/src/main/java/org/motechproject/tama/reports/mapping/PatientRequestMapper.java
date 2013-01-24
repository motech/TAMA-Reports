package org.motechproject.tama.reports.mapping;

import org.motechproject.tama.reports.contract.PatientRequest;
import org.motechproject.tama.reports.domain.Patient;

public class PatientRequestMapper {

    private PatientRequest request;

    public PatientRequestMapper(PatientRequest request) {
        this.request = request;
    }

    public Patient map() {
        Patient patient = new Patient();
        patient.setPatientId(request.getPatientId());
        patient.setBestCallTime(request.getBestCallTime());
        patient.setIvrLanguage(request.getIvrLanguage());
        patient.setReceiveAppointmentReminder(request.getReceiveAppointmentReminder());
        patient.setReceiveOTCAdvice(request.getReceiveOTCAdvice());
        patient.setCallPreference(request.getCallPreference());
        patient.setClinic(request.getClinic());
        patient.setDateOfBirth(request.getDateOfBirth());
        patient.setGender(request.getGender());
        patient.setIvrPassCode(request.getIvrPassCode());
        patient.setTravelTimeToClinic(request.getTravelTimeToClinic());
        return patient;
    }
}
