package org.motechproject.tama.reports.domain.service;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.tama.reports.domain.Patient;
import org.motechproject.tama.reports.domain.repository.AllPatients;

import static org.mockito.Mockito.verify;
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
}
