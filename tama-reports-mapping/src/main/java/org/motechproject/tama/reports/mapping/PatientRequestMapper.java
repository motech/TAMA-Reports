package org.motechproject.tama.reports.mapping;

import org.apache.commons.lang.StringUtils;
import org.motechproject.tama.reports.contract.PatientRequest;
import org.motechproject.tama.reports.domain.Patient;

import java.sql.Time;

public class PatientRequestMapper implements Mapper<Patient> {

    private PatientRequest request;

    public PatientRequestMapper(PatientRequest request) {
        this.request = request;
    }

    @Override
    public Patient map() {
        Patient patient = new Patient();
        patient.setPatientId(request.getPatientId());
        patient.setPatientDocumentId(request.getPatientDocumentId());
        setBestCallTime(patient);
        patient.setIvrLanguage(request.getIvrLanguage());
        patient.setReceiveAppointmentReminder(request.getReceiveAppointmentReminder());
        patient.setReceiveOTCAdvice(request.getReceiveOTCAdvice());
        patient.setCallPreference(request.getCallPreference());
        patient.setClinicId(request.getClinicId());
        patient.setDateOfBirth(request.getDateOfBirth());
        patient.setRegisteredOn(request.getRegisteredOn());
        patient.setGender(request.getGender());
        patient.setIvrPassCode(request.getIvrPassCode());
        patient.setStatus(request.getStatus());
        patient.setTravelTimeToClinic(request.getTravelTimeToClinic());
        patient.setNotes(request.getNotes());
        return patient;
    }

    private void setBestCallTime(Patient patient) {
        if (StringUtils.isNotBlank(request.getBestCallTime())) {
            patient.setBestCallTime(Time.valueOf(request.getBestCallTime()));
        }
    }
}
