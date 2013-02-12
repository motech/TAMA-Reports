package org.motechproject.tama.reports.domain.service;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.tama.reports.domain.medicalhistory.MedicalHistory;
import org.motechproject.tama.reports.domain.repository.AllMedicalHistories;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class MedicalHistoryServiceTest {

    @Mock
    private AllMedicalHistories allMedicalHistories;
    private MedicalHistoryService medicalHistoryService;

    @Before
    public void setup() {
        initMocks(this);
        medicalHistoryService = new MedicalHistoryService(allMedicalHistories);
    }

    @Test
    public void shouldSavePatient() {
        MedicalHistory medicalHistory = new MedicalHistory();
        medicalHistoryService.save(medicalHistory);
        verify(allMedicalHistories).save(medicalHistory);
    }

    @Test
    public void shouldUpdatePatient() {
        MedicalHistory persistedHistory = mock(MedicalHistory.class);
        MedicalHistory newHistory = new MedicalHistory();

        when(allMedicalHistories.findByPatientDocumentId(anyString())).thenReturn(persistedHistory);
        medicalHistoryService.update(newHistory);

        verify(persistedHistory).merge(newHistory);
        verify(allMedicalHistories).save(persistedHistory);
    }
}
