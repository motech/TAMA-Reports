package org.motechproject.tama.reports.contract;

import lombok.Data;
import org.motechproject.tama.reports.domain.Patient;

@Data
public class PatientRequest {

    private String patientId;

    public Patient patient() {
        Patient patient = new Patient();
        patient.setPatientId(patientId);
        return patient;
    }
}
