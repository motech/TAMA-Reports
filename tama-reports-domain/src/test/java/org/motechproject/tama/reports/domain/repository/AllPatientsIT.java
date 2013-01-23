package org.motechproject.tama.reports.domain.repository;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.motechproject.tama.reports.domain.Patient;
import org.motechproject.tama.reports.domain.builder.PatientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.Assert.assertNotNull;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationPersistenceContext.xml")
public class AllPatientsIT {

    @Autowired
    private AllPatients allPatients;

    @Test
    @Transactional
    public void shouldSavePatient() {
        Patient patient = PatientBuilder.validPatient();
        allPatients.save(patient);
        assertNotNull(patient);
    }

    @After
    public void tearDown() {
        allPatients.flush();
        allPatients.deleteAll();
    }
}
