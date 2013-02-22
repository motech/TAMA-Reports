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
        Patient patient = new RequestMapper<PatientRequest, Patient>().map(request, Patient.class, new String[]{"bestCallTime"});
        setBestCallTime(patient);
        return patient;
    }

    private void setBestCallTime(Patient patient) {
        if (StringUtils.isNotBlank(request.getBestCallTime())) {
            patient.setBestCallTime(Time.valueOf(request.getBestCallTime()));
        }
    }
}
