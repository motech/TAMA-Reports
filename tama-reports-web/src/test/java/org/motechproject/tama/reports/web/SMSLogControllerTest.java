package org.motechproject.tama.reports.web;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.tama.reports.contract.SMSLogRequest;
import org.motechproject.tama.reports.domain.SMSLog;
import org.motechproject.tama.reports.domain.export.ReportingService;
import org.motechproject.tama.reports.domain.service.SMSLogService;
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

public class SMSLogControllerTest extends BaseControllerTest {

    @Mock
    private SMSLogService smsLogService;
    @Mock
    private ReportingService reportingService;
    private SMSLogController smsLogController;

    @Before
    public void setup() {
        initMocks(this);
        smsLogController = new SMSLogController(smsLogService, reportingService);
    }

    @Test
    public void shouldCreateSMSLog() throws Exception {
        SMSLogRequest request = new SMSLogRequest();

        standaloneSetup(smsLogController)
                .build()
                .perform(post("/smsLog").contentType(MediaType.APPLICATION_JSON).body(getJSON(request).getBytes()))
                .andExpect(status().isOk());
        verify(smsLogService).save(any(SMSLog.class));
    }

    @Test
    public void shouldReportOTCSMSLogs() throws Exception {
        standaloneSetup(smsLogController)
                .build()
                .perform(get("/smsLog/report").param("type", "OTCSMS").param("externalId", "").param("clinicId", "").param("startDate", "12/11/2013").param("endDate", "12/11/2013"))
                .andExpect(status().isOk());
        verify(reportingService).export(any(HealthTipsParameters.class), any(OutputStream.class), eq("OTCSMSReport.jasper"));
    }

    @Test
    public void shouldReportClinicianSMSLogs() throws Exception {
        standaloneSetup(smsLogController)
                .build()
                .perform(get("/smsLog/report").param("type", "ClinicianSMS").param("externalId", "").param("clinicId", "").param("startDate", "12/11/2013").param("endDate", "12/11/2013"))
                .andExpect(status().isOk());
        verify(reportingService).export(any(HealthTipsParameters.class), any(OutputStream.class), eq("ClinicianSMSReport.jasper"));
    }
}
