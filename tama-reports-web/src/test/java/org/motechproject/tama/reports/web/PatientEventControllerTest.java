package org.motechproject.tama.reports.web;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.tama.reports.contract.PatientEventRequest;
import org.motechproject.tama.reports.domain.PatientEvent;
import org.motechproject.tama.reports.domain.export.ReportParameters;
import org.motechproject.tama.reports.domain.export.ReportingService;
import org.motechproject.tama.reports.domain.service.PatientEventService;
import org.springframework.http.MediaType;

import java.io.OutputStream;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;

public class PatientEventControllerTest extends BaseControllerTest {

    @Mock
    private PatientEventService patientEventService;
    @Mock
    private ReportingService reportingService;
    private PatientEventController patientEventController;

    @Before
    public void setup() {
        initMocks(this);
        patientEventController = new PatientEventController(patientEventService, reportingService);
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

    @Test
    public void shouldCreatePatientEventReport() throws Exception {
        standaloneSetup(patientEventController)
                .build()
                .perform(get("/patientEvent/report").param("patientId", "").param("eventName", "").param("clinicId", "").param("startDate", "").param("endDate", ""))
                .andExpect(status().isOk())
                .andExpect(content().type("application/vnd.ms-excel"));
        verify(reportingService).export(any(ReportParameters.class), any(OutputStream.class), eq("patientEvent.jasper"));
    }

}

