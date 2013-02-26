package org.motechproject.tama.reports.mapping;

import org.motechproject.tama.reports.contract.ClinicianContactRequest;
import org.motechproject.tama.reports.domain.Clinician;

import java.util.ArrayList;
import java.util.List;

public class ClinicianContactMapper{

    private List<ClinicianContactRequest> requests;

    public ClinicianContactMapper(List<ClinicianContactRequest> requests) {
        this.requests = requests;
    }

    public List<Clinician> map() {
        List<Clinician> clinicians = new ArrayList<>();
        for(ClinicianContactRequest request: requests){
            Clinician clinician = new Clinician();
            clinician.setClinicianId(request.getId());
            clinician.setName(request.getName());
            clinician.setClinicId(request.getClinicId());
            clinician.setContactNumber(request.getPhoneNumber());
            clinician.setType("CC");
            clinicians.add(clinician);
        }
        return clinicians;
    }
}
