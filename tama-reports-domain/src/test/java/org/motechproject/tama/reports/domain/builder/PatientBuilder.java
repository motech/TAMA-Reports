package org.motechproject.tama.reports.domain.builder;

import org.joda.time.LocalDate;
import org.motechproject.tama.reports.domain.Patient;

import java.sql.Time;

public class PatientBuilder {

    public static Patient validPatient() {
        Patient patient = new Patient();
        patient.setBestCallTime(Time.valueOf("10:10:00"));
        patient.setPatientDocumentId("patientDocId");
        patient.setCallPreference("DPR");
        patient.setIvrLanguage("en");
        patient.setReceiveAppointmentReminder(true);
        patient.setReceiveOTCAdvice(true);
        patient.setClinicId("clinicId");
        patient.setDateOfBirth(LocalDate.now().toDate());
        patient.setGender("M");
        patient.setIvrPassCode("1234");
        patient.setPatientId("patientId");
        patient.setTravelTimeToClinic("travelTime");
        return patient;
    }
}
