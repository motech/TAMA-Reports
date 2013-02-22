package org.motechproject.tama.reports.mapping;

import org.motechproject.tama.reports.contract.ClinicianRequest;
import org.motechproject.tama.reports.domain.Clinician;

public class ClinicianMapper extends RequestMapper<ClinicianRequest, Clinician> {

    private ClinicianRequest request;

    public ClinicianMapper(ClinicianRequest request) {
        this.request = request;
    }

    public Clinician map() {
        Clinician clinician = new RequestMapper<ClinicianRequest, Clinician>().map(request, Clinician.class);
        clinician.setType("C");
        return clinician;
    }
}
