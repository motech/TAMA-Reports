package org.motechproject.tama.reports.web;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.tama.reports.contract.HealthTipsRequest;
import org.motechproject.tama.reports.domain.HealthTips;
import org.motechproject.tama.reports.domain.export.ReportingService;
import org.motechproject.tama.reports.domain.service.HealthTipsService;
import org.motechproject.tama.reports.web.excel.HealthTipsParameters;
import org.springframework.http.MediaType;

import java.io.OutputStream;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;

public class HealthTipsControllerTest extends BaseControllerTest {

    @Mock
    private HealthTipsService healthTipsService;
    @Mock
    private ReportingService reportingService;
    private HealthTipsController healthTipsController;

    @Before
    public void setup() {
        initMocks(this);
        healthTipsController = new HealthTipsController(healthTipsService, reportingService);
    }

    @Test
    public void shouldSaveHealthTips() throws Exception {
        HealthTipsRequest healthTipsRequest = new HealthTipsRequest();
        standaloneSetup(healthTipsController)
                .build()
                .perform(post("/healthTips").contentType(MediaType.APPLICATION_JSON).body(getJSON(healthTipsRequest).getBytes()))
                .andExpect(status().isOk());
        verify(healthTipsService).save(any(HealthTips.class));
    }

    @Test
    public void shouldReportHealthTips() throws Exception {
        standaloneSetup(healthTipsController)
                .build()
                .perform(get("/healthTips/report").param("patientId", "").param("clinicName", "").param("startDate", "12/11/2013").param("endDate", "12/11/2013"))
                .andExpect(status().isOk());
        verify(reportingService).export(any(HealthTipsParameters.class), any(OutputStream.class), eq("healthTips.jasper"));
    }
}
