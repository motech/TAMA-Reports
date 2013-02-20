package org.motechproject.tama.reports.web;

import org.apache.log4j.Logger;
import org.motechproject.tama.reports.contract.SMSLogRequest;
import org.motechproject.tama.reports.domain.SMSLog;
import org.motechproject.tama.reports.domain.service.SMSLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/smsLog")
@Controller
public class SMSLogController {

    private SMSLogService smsLogService;
    private Logger logger = Logger.getLogger(SMSLogController.class);

    @Autowired
    public SMSLogController(SMSLogService smsLogService) {
        this.smsLogService = smsLogService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody SMSLogRequest request) {
        logger.info("Saving SMS Log");
        smsLogService.save(new SMSLog());
    }
}
