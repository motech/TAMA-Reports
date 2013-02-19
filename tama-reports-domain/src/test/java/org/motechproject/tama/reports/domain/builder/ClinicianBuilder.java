package org.motechproject.tama.reports.domain.builder;

import org.motechproject.tama.reports.domain.Clinician;

public class ClinicianBuilder {

    public static Clinician validClinician() {
        Clinician clinician = new Clinician();
        clinician.setClinicId("clinicId");
        clinician.setClinicianId("clinicianId");
        return clinician;
    }
}
