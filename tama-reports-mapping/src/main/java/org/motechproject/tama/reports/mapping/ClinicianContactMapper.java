package org.motechproject.tama.reports.mapping;

import org.motechproject.tama.reports.contract.ClinicianContactRequest;
import org.motechproject.tama.reports.domain.Clinician;

import java.util.List;

public class ClinicianContactMapper extends RequestMapper<ClinicianContactRequest, Clinician> {

    private List<ClinicianContactRequest> requests;

    public ClinicianContactMapper(List<ClinicianContactRequest> requests) {
        this.requests = requests;
    }

    public List<Clinician> map() {
        String[] ignoreFields = {"id"};
        List<Clinician> clinicians = new RequestMapper<ClinicianContactRequest, Clinician>().map(requests, Clinician.class, ignoreFields);
        for (Clinician clinician : clinicians) {
            clinician.setType("CC");
        }
        return clinicians;
    }
}
