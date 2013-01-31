package org.motechproject.tama.reports.web.excel;


import org.motechproject.tama.reports.domain.export.ReportParameters;

import java.util.HashMap;

import static org.apache.commons.lang.StringUtils.isNotBlank;

public class PatientEventParameters implements ReportParameters {

    public static String CLINIC_NAME = "clinic_name";
    public static String EVENT_NAME = "status";
    public static String PATIENT_ID = "patient_id";
    public static String START_DATE = "from_date";
    public static String END_DATE = "end_date";

    private HashMap parameters;

    public PatientEventParameters() {
        parameters = new HashMap();
        parameters.put(PATIENT_ID, "%");
        parameters.put(CLINIC_NAME, "%");
        parameters.put(EVENT_NAME, "%");
    }

    public PatientEventParameters setStartDate(String startDate) {
        if (null != startDate) {
            parameters.put(START_DATE, startDate);
        }
        return this;
    }

    public PatientEventParameters setEndDate(String endDate) {
        if (null != endDate) {
            parameters.put(END_DATE, endDate);
        }
        return this;
    }

    public PatientEventParameters setEventName(String eventName) {
        if (isNotBlank(eventName)) {
            parameters.put(EVENT_NAME, "%" + eventName + "%");
        }
        return this;
    }

    public PatientEventParameters setClinicName(String clinicName) {
        if (isNotBlank(clinicName)) {
            parameters.put(CLINIC_NAME, "%" + clinicName + "%");
        }
        return this;
    }

    public PatientEventParameters setPatientId(String patientId) {
        if (isNotBlank(patientId)) {
            parameters.put(PATIENT_ID, patientId);
        }
        return this;
    }

    public HashMap parameters() {
        return parameters;
    }
}
