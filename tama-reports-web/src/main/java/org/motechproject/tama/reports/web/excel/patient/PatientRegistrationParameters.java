package org.motechproject.tama.reports.web.excel.patient;


import java.util.HashMap;

import static org.apache.commons.lang.StringUtils.isNotBlank;

public class PatientRegistrationParameters {

    public static String CLINIC_NAME = "CLINIC_NAME";
    public static String PATIENT_ID = "PATIENT_ID";

    private HashMap parameters;

    public PatientRegistrationParameters() {
        parameters = new HashMap();
        parameters.put(PATIENT_ID, "%");
        parameters.put(CLINIC_NAME, "%");
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
