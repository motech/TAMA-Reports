package org.motechproject.tama.reports.web.excel;


public class ClinicianSMSLogParameters extends AbstractReportParameters {

    public static String CLINIC_NAME = "CLINIC_NAME";
    public static String CLINICIAN_NAME = "CLINICIAN_NAME";
    public static String START_DATE = "START_DATE";
    public static String END_DATE = "END_DATE";

    public ClinicianSMSLogParameters setStartDate(String startDate) {
        exactMatchParameter(START_DATE, startDate, false);
        return this;
    }

    public ClinicianSMSLogParameters setEndDate(String endDate) {
        exactMatchParameter(END_DATE, endDate, false);
        return this;
    }

    public ClinicianSMSLogParameters setClinicName(String clinicName) {
        subStringMatchParameter(CLINIC_NAME, clinicName, true);
        return this;
    }

    public ClinicianSMSLogParameters setClinicianName(String clinicianName) {
        exactMatchParameter(CLINICIAN_NAME, clinicianName, true);
        return this;
    }
}
