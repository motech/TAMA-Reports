package org.motechproject.tama.reports.mapping;

import org.motechproject.tama.reports.contract.SMSLogRequest;
import org.motechproject.tama.reports.domain.SMSLog;

import static org.springframework.beans.BeanUtils.copyProperties;

public class SMSLogMapper {

    private SMSLogRequest request;

    public SMSLogMapper(SMSLogRequest request) {
        this.request = request;
    }

    public SMSLog map() {
        SMSLog log = new SMSLog();
        copyProperties(request, log);
        return log;
    }
}
