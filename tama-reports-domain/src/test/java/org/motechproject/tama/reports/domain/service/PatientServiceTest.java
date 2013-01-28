package org.motechproject.tama.reports.domain.service;


import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.motechproject.tama.reports.domain.Patient;
import org.motechproject.tama.reports.domain.builder.PatientBuilder;
import org.motechproject.tama.reports.domain.repository.AllPatients;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class PatientServiceTest {

    @Mock
    private AllPatients allPatients;
    @Mock
    private BasicDataSource dataSource;
    private PatientService patientService;

    @Before
    public void setup() {
        initMocks(this);
        patientService = new PatientService(allPatients, dataSource);
    }

    @Test
    public void shouldSavePatient() {
        Patient patient = new Patient();
        patientService.save(patient);
        verify(allPatients).save(patient);
    }

    @Test
    public void shouldUpdatePatient() {
        Patient detachedPatient = PatientBuilder.validPatient();
        detachedPatient.setGender("F");

        Patient persistedPatient = PatientBuilder.validPatient();
        persistedPatient.setId(10l);

        when(allPatients.findByPatientId(detachedPatient.getPatientId())).thenReturn(persistedPatient);
        patientService.update(detachedPatient);

        Patient merged = mergedPatient();
        assertEquals(detachedPatient.getGender(), merged.getGender());
        assertEquals(persistedPatient.getId(), merged.getId());
    }

    private Patient mergedPatient() {
        ArgumentCaptor<Patient> patientCaptor = ArgumentCaptor.forClass(Patient.class);
        verify(allPatients).save(patientCaptor.capture());
        return patientCaptor.getValue();
    }
}
