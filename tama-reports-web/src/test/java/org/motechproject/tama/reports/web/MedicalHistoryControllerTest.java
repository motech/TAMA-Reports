package org.motechproject.tama.reports.web;

import org.codehaus.jackson.node.NullNode;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.tama.reports.contract.MedicalHistoryRequest;
import org.motechproject.tama.reports.domain.service.MedicalHistoryService;
import org.motechproject.tama.reports.mapping.MedicalHistoryMapper;
import org.springframework.http.MediaType;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;

public class MedicalHistoryControllerTest extends BaseControllerTest {

    @Mock
    private MedicalHistoryService medicalHistoryService;
    private MedicalHistoryController medicalHistoryController;

    @Before
    public void setup() {
        initMocks(this);
        medicalHistoryController = new MedicalHistoryController(medicalHistoryService);
    }

    @Test
    public void shouldCreateMedicalHistory() throws Exception {
        MedicalHistoryRequest request = new MedicalHistoryRequest();
        request.setNonHivMedicalHistory(NullNode.getInstance());

        standaloneSetup(medicalHistoryController)
                .build()
                .perform(post("/medicalHistory").contentType(MediaType.APPLICATION_JSON).body(getJSON(request).getBytes()))
                .andExpect(status().isOk());
        verify(medicalHistoryService).save(new MedicalHistoryMapper(request).map());
    }

    @Test
    public void shouldUpdateMedicalHistory() throws Exception {
        MedicalHistoryRequest request = new MedicalHistoryRequest();
        request.setNonHivMedicalHistory(NullNode.getInstance());

        standaloneSetup(medicalHistoryController)
                .build()
                .perform(put("/medicalHistory").contentType(MediaType.APPLICATION_JSON).body(getJSON(request).getBytes()))
                .andExpect(status().isOk());
        verify(medicalHistoryService).update(new MedicalHistoryMapper(request).map());
    }
}
