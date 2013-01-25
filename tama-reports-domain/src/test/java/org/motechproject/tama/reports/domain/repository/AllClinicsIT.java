package org.motechproject.tama.reports.domain.repository;


import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.motechproject.tama.reports.domain.Clinic;
import org.motechproject.tama.reports.domain.builder.ClinicBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationPersistenceContext.xml")
public class AllClinicsIT {

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

    @After
    public void tearDown() {
        allClinics.flush();
        allClinics.deleteAll();
    }
}
