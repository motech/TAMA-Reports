package org.motechproject.tama.reports.domain.service;


import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.motechproject.tama.reports.contract.PillTimeRequest;
import org.motechproject.tama.reports.domain.Patient;
import org.motechproject.tama.reports.domain.builder.PatientBuilder;
import org.motechproject.tama.reports.domain.repository.AllPatients;

import static java.sql.Time.valueOf;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class PatientServiceTest {

    @Mock
    private AllPatients allPatients;
    private PatientService patientService;

    @Before
    public void setup() {
        initMocks(this);
        patientService = new PatientService(allPatients);
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

        when(allPatients.findByPatientDocumentId(detachedPatient.getPatientDocumentId())).thenReturn(persistedPatient);
        patientService.update(detachedPatient);

        Patient merged = mergedPatient();
        assertEquals(detachedPatient.getGender(), merged.getGender());
        assertEquals(persistedPatient.getId(), merged.getId());
    }

    @Test
    public void shouldUpdatePillTime() {
        Patient persistedPatient = PatientBuilder.validPatient();
        PillTimeRequest pillTimeRequest = new PillTimeRequest();
        pillTimeRequest.setPatientDocumentId(persistedPatient.getPatientDocumentId());
        pillTimeRequest.setMorningPillTime("10:10:10");
        pillTimeRequest.setEveningPillTime("14:10:10");

        when(allPatients.findByPatientDocumentId(persistedPatient.getPatientDocumentId())).thenReturn(persistedPatient);

        patientService.updatePillTimes(pillTimeRequest);

        Patient merged = mergedPatient();
        assertEquals(valueOf(pillTimeRequest.getMorningPillTime()), merged.getMorningPillTime());
        assertEquals(valueOf(pillTimeRequest.getEveningPillTime()), merged.getEveningPillTime());
    }

    private Patient mergedPatient() {
        ArgumentCaptor<Patient> patientCaptor = ArgumentCaptor.forClass(Patient.class);
        verify(allPatients).save(patientCaptor.capture());
        return patientCaptor.getValue();
    }
}
