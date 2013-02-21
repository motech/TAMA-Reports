package org.motechproject.tama.reports.mapping;

import org.motechproject.tama.reports.contract.ClinicianRequest;
import org.motechproject.tama.reports.domain.Clinician;

public class ClinicianRequestMapper implements Mapper<Clinician> {

    private ClinicianRequest clinicianRequest;

    public ClinicianRequestMapper(ClinicianRequest clinicianRequest) {
        this.clinicianRequest = clinicianRequest;
    }

    @Override
    public Clinician map() {
        Clinician clinician = new Clinician();
        clinician.setClinicianId(clinicianRequest.getClinicianId());
        clinician.setClinicId(clinicianRequest.getClinicId());
        clinician.setContactNumber(clinicianRequest.getContactNumber());
        clinician.setAlternateNumber(clinicianRequest.getAlternateNumber());
        clinician.setRole(clinicianRequest.getRole());
        clinician.setUserName(clinicianRequest.getUserName());
        clinician.setName(clinicianRequest.getName());
        return clinician;
    }
}
