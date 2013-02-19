package org.motechproject.tama.reports.domain.repository;


import org.junit.Test;
import org.motechproject.tama.reports.domain.Clinician;
import org.motechproject.tama.reports.domain.builder.ClinicianBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import static junit.framework.Assert.assertEquals;

public class AllCliniciansIT extends AbstractRepositoryTest {

    @Autowired
    private AllClinicians allClinicians;

    @Test
    public void shouldSaveClinician() {
        Clinician clinician = ClinicianBuilder.validClinician();

        allClinicians.save(clinician);
        assertEquals(clinician, allClinicians.findByClinicianId(clinician.getClinicianId()));
    }

    @Test
    public void shouldUpdateClinician() {
        Clinician clinician = ClinicianBuilder.validClinician();
        allClinicians.save(clinician);

        clinician.setContactNumber("contactNumber");
        allClinicians.save(clinician);
        assertEquals(clinician, allClinicians.findByClinicianId(clinician.getClinicianId()));
    }

    @Override
    protected JpaRepository getRepository() {
        return allClinicians;
    }
}
