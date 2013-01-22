package org.motechproject.tama.reports.contract;

import lombok.Data;

import java.util.Date;

@Data
public class PatientRequest {

    private String patientId;
    private Date dateOfBirth;
    private String gender;
    private String clinicId;
    private String travelTimeToClinic;
    private String ivrPassCode;
    private String ivrLanguage;
    private String callPreference;
    private String bestCallTime;
    private Boolean receiveOTCAdvice;
    private Boolean receiveAppointmentReminder;

}
