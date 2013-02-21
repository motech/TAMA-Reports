package org.motechproject.tama.reports.mapping;

import org.motechproject.tama.reports.contract.ClinicRequest;
import org.motechproject.tama.reports.domain.Clinic;

public class ClinicRequestMapper implements Mapper<Clinic> {

    private ClinicRequest clinicRequest;

    public ClinicRequestMapper(ClinicRequest clinicRequest) {
        this.clinicRequest = clinicRequest;
    }

    @Override
    public Clinic map() {
        Clinic clinic = new Clinic();
        clinic.setClinicName(clinicRequest.getClinicName());
        clinic.setClinicId(clinicRequest.getClinicId());
        clinic.setCityName(clinicRequest.getCityName());
        return clinic;
    }
}
