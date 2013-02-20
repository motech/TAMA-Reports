package org.motechproject.tama.reports.web;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.tama.reports.contract.SMSLogRequest;
import org.motechproject.tama.reports.domain.service.SMSLogService;
import org.motechproject.tama.reports.mapping.SMSLogMapper;
import org.springframework.http.MediaType;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;

public class SMSLogControllerTest extends BaseControllerTest {

    @Mock
    private SMSLogService smsLogService;
    private SMSLogController smsLogController;

    @Before
    public void setup() {
        initMocks(this);
        smsLogController = new SMSLogController(smsLogService);
    }

    @Test
    public void shouldCreateSMSLog() throws Exception {
        SMSLogRequest request = new SMSLogRequest();

        standaloneSetup(smsLogController)
                .build()
                .perform(post("/smsLog").contentType(MediaType.APPLICATION_JSON).body(getJSON(request).getBytes()))
                .andExpect(status().isOk());
        verify(smsLogService).save(new SMSLogMapper(request).map());
    }
}
