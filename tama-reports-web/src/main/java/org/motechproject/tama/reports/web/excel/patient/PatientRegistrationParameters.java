package org.motechproject.tama.reports.web.excel.patient;


import java.util.HashMap;

import static org.apache.commons.lang.StringUtils.isNotBlank;

public class PatientRegistrationParameters {

    public static String CLINIC_NAME = "CLINIC_NAME";
    public static String PATIENT_ID = "PATIENT_ID";
    public static String START_DATE = "START_DATE";
    public static String END_DATE = "END_DATE";

    private HashMap parameters;

    public PatientRegistrationParameters() {
        parameters = new HashMap();
        parameters.put(PATIENT_ID, "%");
        parameters.put(CLINIC_NAME, "%");
    }

    public PatientRegistrationParameters setStartDate(String startDate) {
        if (null != startDate) {
            parameters.put(START_DATE, startDate);
        }
        return this;
    }

    public PatientRegistrationParameters setEndDate(String endDate) {
        if (null != endDate) {
            parameters.put(END_DATE, endDate);
        }
        return this;
    }

    public PatientRegistrationParameters setClinicName(String clinicName) {
        if (isNotBlank(clinicName)) {
            parameters.put(CLINIC_NAME, "%" + clinicName + "%");
        }
        return this;
    }

    public PatientRegistrationParameters setPatientId(String patientId) {
        if (isNotBlank(patientId)) {
            parameters.put(PATIENT_ID, patientId);
        }
        return this;
    }

    public HashMap parameters() {
        return parameters;
    }
}
