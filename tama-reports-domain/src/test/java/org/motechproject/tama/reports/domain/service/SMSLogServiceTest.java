package org.motechproject.tama.reports.domain.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.tama.reports.domain.SMSLog;
import org.motechproject.tama.reports.domain.repository.AllSMSLogs;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class SMSLogServiceTest {

    @Mock
    private AllSMSLogs allSMSLogs;
    private SMSLogService smsLogService;

    @Before
    public void setup() {
        initMocks(this);
        smsLogService = new SMSLogService(allSMSLogs);
    }

    @Test
    public void shouldSaveSMSLog() {
        SMSLog smsLog = new SMSLog();
        smsLogService.save(smsLog);
        verify(allSMSLogs).save(smsLog);
    }
}
