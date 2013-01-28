package org.motechproject.tama.reports.mapping;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.tama.reports.contract.MedicalHistoryRequest;
import org.motechproject.tama.reports.domain.medicalhistory.MedicalHistory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class MedicalHistoryMapperTest {

    @Mock
    private GeneralHistoryMapper generalHistoryMapper;
    @Mock
    private SystemAllergiesMapper systemAllergiesMapper;

    private MedicalHistoryMapper mapper;

    @Before
    public void setup() {
        initMocks(this);
    }

    @Test
    public void shouldMapPatientId() throws IOException {
        String patientId = "patientId";

        MedicalHistoryRequest request = new MedicalHistoryRequest();
        request.setPatientId(patientId);
        MedicalHistory history = new MedicalHistoryMapper(request, generalHistoryMapper, systemAllergiesMapper).map();
        assertEquals(patientId, history.getPatientId());
    }

    @Test
    public void shouldMapGeneralHistory() throws IOException {
        MedicalHistoryRequest request = new MedicalHistoryRequest();
        new MedicalHistoryMapper(request, generalHistoryMapper, systemAllergiesMapper).map();
        verify(generalHistoryMapper).map();
    }

    @Test
    public void shouldMapSystemAllergies() throws IOException {
        MedicalHistoryRequest request = new MedicalHistoryRequest();
        new MedicalHistoryMapper(request, generalHistoryMapper, systemAllergiesMapper).map();
        verify(systemAllergiesMapper).map();
    }
}
