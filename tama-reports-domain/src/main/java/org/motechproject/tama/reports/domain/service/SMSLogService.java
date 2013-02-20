package org.motechproject.tama.reports.domain.service;

import org.motechproject.tama.reports.domain.SMSLog;
import org.motechproject.tama.reports.domain.repository.AllSMSLogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SMSLogService {

    private AllSMSLogs allSMSLogs;

    @Autowired
    public SMSLogService(AllSMSLogs allSMSLogs) {
        this.allSMSLogs = allSMSLogs;
    }

    public void save(SMSLog smsLog) {
        allSMSLogs.save(smsLog);
    }
}
