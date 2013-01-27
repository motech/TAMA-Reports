package org.motechproject.tama.reports.mapping;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.tama.reports.contract.MedicalHistoryRequest;

import java.io.IOException;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class MedicalHistoryMapperTest {

    @Mock
    private GeneralHistoryMapper generalHistoryMapper;

    private MedicalHistoryMapper mapper;

    @Before
    public void setup() {
        initMocks(this);
    }

    @Test
    public void shouldMapGeneralHistory() throws IOException {
        MedicalHistoryRequest request = new MedicalHistoryRequest();
        new MedicalHistoryMapper(request, generalHistoryMapper).map();
        verify(generalHistoryMapper).map();
    }
}
