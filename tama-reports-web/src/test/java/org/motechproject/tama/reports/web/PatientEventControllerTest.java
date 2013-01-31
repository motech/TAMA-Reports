package org.motechproject.tama.reports.web;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.tama.reports.contract.PatientEventRequest;
import org.motechproject.tama.reports.domain.PatientEvent;
import org.motechproject.tama.reports.domain.service.PatientEventService;
import org.springframework.http.MediaType;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;

public class PatientEventControllerTest extends BaseControllerTest {

    @Mock
    private PatientEventService patientEventService;
    private PatientEventController patientEventController;

    @Before
    public void setup() {
        initMocks(this);
        patientEventController = new PatientEventController(patientEventService);
    }

    @Test
    public void shouldCreatePatientEvent() throws Exception {
        PatientEventRequest patientEvent = new PatientEventRequest();
        standaloneSetup(patientEventController)
                .build()
                .perform(post("/patientEvent").contentType(MediaType.APPLICATION_JSON).body(getJSON(patientEvent).getBytes()))
                .andExpect(status().isOk());
        verify(patientEventService).save(any(PatientEvent.class));
    }
}
