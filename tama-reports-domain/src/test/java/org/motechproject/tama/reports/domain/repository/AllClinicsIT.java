package org.motechproject.tama.reports.domain.repository;


import org.junit.Test;
import org.motechproject.tama.reports.domain.Clinic;
import org.motechproject.tama.reports.domain.builder.ClinicBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AllClinicsIT extends AbstractRepositoryTest {

    @Autowired
    private AllClinics allClinics;

    @Test
    @Transactional
    public void shouldSaveClinic() {
        Clinic clinic = ClinicBuilder.validClinic();
        allClinics.save(clinic);
        assertNotNull(allClinics.findByClinicId(clinic.getClinicId()));
    }

    @Test
    @Transactional
    public void shouldUpdateClinic() {
        String updatedName = "updatedName";
        Clinic clinic = ClinicBuilder.validClinic();
        allClinics.save(clinic);

        clinic.setClinicName(updatedName);
        allClinics.save(clinic);

        assertEquals(updatedName, allClinics.findByClinicId(clinic.getClinicId()).getClinicName());
    }

    @Override
    protected JpaRepository getRepository() {
        return allClinics;
    }
}
