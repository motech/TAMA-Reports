package org.motechproject.tama.reports.domain.repository;


import org.junit.Test;
import org.motechproject.tama.reports.domain.Clinician;
import org.motechproject.tama.reports.domain.builder.ClinicianBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;

public class AllCliniciansIT extends AbstractRepositoryTest {

    @Autowired
    private AllClinicians allClinicians;

    @Test
    public void shouldSaveClinician() {
        Clinician clinician = new ClinicianBuilder().build();

        allClinicians.save(clinician);
        assertEquals(clinician, allClinicians.findByClinicianId(clinician.getClinicianId()));
    }

    @Test
    public void shouldSaveAllClinicians() {
        List<Clinician> clinicians = asList(
                new ClinicianBuilder().withId("clinicianId1").build(),
                new ClinicianBuilder().withId("clinicianId2").build()
        );

        allClinicians.save(clinicians);
        assertEquals(clinicians.get(0), allClinicians.findByClinicianId(clinicians.get(0).getClinicianId()));
        assertEquals(clinicians.get(1), allClinicians.findByClinicianId(clinicians.get(1).getClinicianId()));
    }

    @Test
    public void shouldFindCliniciansMatchingAnyId() {
        List<Clinician> clinicians = asList(
                new ClinicianBuilder().withId("clinicianId1").build(),
                new ClinicianBuilder().withId("clinicianId2").build()
        );

        allClinicians.save(clinicians);

        assertEquals(2, allClinicians.findByClinicianIdIn(asList("clinicianId1", "clinicianId2")).size());
    }

    @Test
    public void shouldUpdateClinician() {
        Clinician clinician = new ClinicianBuilder().build();
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
