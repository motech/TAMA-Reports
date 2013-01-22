package org.motechproject.tama.reports.web;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.tama.reports.contract.PatientRequest;
import org.motechproject.tama.reports.domain.service.PatientService;
import org.springframework.http.MediaType;

import java.io.IOException;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;

public class PatientControllerTest {

    @Mock
    private PatientService patientService;
    private PatientController patientController;

    @Before
    public void setup() {
        initMocks(this);
        patientController = new PatientController(patientService);
    }

    @Test
    public void shouldCreatePatient() throws Exception {
        PatientRequest request = new PatientRequest();
        request.setPatientId("patientId");

        standaloneSetup(patientController)
                .build()
                .perform(post("/patient").contentType(MediaType.APPLICATION_JSON).body(getJSON(request).getBytes()))
                .andExpect(status().isOk());
        verify(patientService).create(request.patient());
    }

    protected String getJSON(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writer().writeValueAsString(object);
    }
}
