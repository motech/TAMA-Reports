package org.motechproject.tama.reports.domain.builder;

import org.motechproject.tama.reports.domain.Clinician;

public class ClinicianBuilder {

    Clinician clinician = new Clinician();

    public ClinicianBuilder() {
        clinician.setClinicId("clinicId");
        clinician.setClinicianId("clinicianId");
        clinician.setUserName("userName");
        clinician.setName("name");
    }

    public Clinician build() {
        return clinician;
    }

    public ClinicianBuilder withId(String clinicianId) {
        clinician.setClinicianId(clinicianId);
        return this;
    }

    public ClinicianBuilder withContactNumber(String contactNumber) {
        clinician.setContactNumber(contactNumber);
        return this;
    }

    public ClinicianBuilder withAlternateNumber(String alternateNumber) {
        clinician.setAlternateNumber(alternateNumber);
        return this;
    }

    public ClinicianBuilder withRole(String role) {
        clinician.setRole(role);
        return this;
    }
}
