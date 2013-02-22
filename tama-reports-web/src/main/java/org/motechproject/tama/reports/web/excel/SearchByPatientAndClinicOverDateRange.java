package org.motechproject.tama.reports.web.excel;


public class SearchByPatientAndClinicOverDateRange extends AbstractReportParameters {

    public static String CLINIC_NAME = "CLINIC_NAME";
    public static String PATIENT_ID = "PATIENT_ID";
    public static String START_DATE = "START_DATE";
    public static String END_DATE = "END_DATE";

    public SearchByPatientAndClinicOverDateRange setStartDate(String startDate) {
        exactMatchParameter(START_DATE, startDate, false);
        return this;
    }

    public SearchByPatientAndClinicOverDateRange setEndDate(String endDate) {
        exactMatchParameter(END_DATE, endDate, false);
        return this;
    }

    public SearchByPatientAndClinicOverDateRange setClinicName(String clinicName) {
        subStringMatchParameter(CLINIC_NAME, clinicName, true);
        return this;
    }

    public SearchByPatientAndClinicOverDateRange setPatientId(String patientId) {
        exactMatchParameter(PATIENT_ID, patientId, true);
        return this;
    }
}
