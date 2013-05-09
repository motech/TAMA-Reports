package org.motechproject.tama.reports.contract;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PatientRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String patientId;
    private String patientDocumentId;
    private Date dateOfBirth;
    private String gender;
    private String clinicId;
    private String travelTimeToClinic;
    private String ivrPassCode;
    private String ivrLanguage;
    private String callPreference;
    private String bestCallTime;
    private String dayOfWeeklyCall;
    private Boolean receiveOTCAdvice;
    private Boolean receiveAppointmentReminder;
    private Date registeredOn;
    private String status;
    private String notes;
    private Boolean complete;

}
