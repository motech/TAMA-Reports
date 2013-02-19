package org.motechproject.tama.reports.domain.repository;

import org.junit.Test;
import org.motechproject.tama.reports.domain.Patient;
import org.motechproject.tama.reports.domain.builder.PatientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class AllPatientsIT extends AbstractRepositoryTest {

    @Autowired
    private AllPatients allPatients;

    @Test
    @Transactional
    public void shouldSavePatient() {
        Patient patient = PatientBuilder.validPatient();
        allPatients.save(patient);
        assertNotNull(patient.getId());
    }

    @Test
    public void shouldFindByClinic() {
        Patient patient = PatientBuilder.validPatient();
        allPatients.save(patient);

        assertEquals(patient, allPatients.findByPatientDocumentId(patient.getPatientDocumentId()));
    }

    @Test
    public void shouldUpdatePatient() {
        Patient patient = PatientBuilder.validPatient();
        allPatients.save(patient);

        patient.setIvrPassCode("passcode");
        allPatients.save(patient);

        assertEquals("passcode", allPatients.findByPatientDocumentId(patient.getPatientDocumentId()).getIvrPassCode());
    }

    @Override
    protected JpaRepository getRepository() {
        return allPatients;
    }
}
