package org.motechproject.tama.reports.web;

import org.apache.log4j.Logger;
import org.motechproject.tama.reports.contract.SMSLogRequest;
import org.motechproject.tama.reports.domain.SMSLog;
import org.motechproject.tama.reports.domain.export.ReportingService;
import org.motechproject.tama.reports.domain.service.SMSLogService;
import org.motechproject.tama.reports.mapping.RequestMapper;
import org.motechproject.tama.reports.web.excel.SMSLogParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/smsLog")
@Controller
public class SMSLogController {

    private SMSLogService smsLogService;
    private ReportingService reportingService;
    private Logger logger = Logger.getLogger(SMSLogController.class);

    @Autowired
    public SMSLogController(SMSLogService smsLogService, ReportingService reportingService) {
        this.smsLogService = smsLogService;
        this.reportingService = reportingService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody SMSLogRequest request) {
        logger.info("Saving SMS Log");
        smsLogService.save(new RequestMapper<SMSLogRequest, SMSLog>().map(request, SMSLog.class));
    }

    @RequestMapping(value = "report", method = RequestMethod.GET)
    public void report(@RequestParam("clinicName") String clinicName,
                       @RequestParam("patientId") String patientId,
                       @RequestParam("startDate") String startDate,
                       @RequestParam("endDate") String endDate,
                       HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "inline; filename=SMSReport.xls");
        response.setContentType("application/vnd.ms-excel");
        SMSLogParameters parameters = new SMSLogParameters();
        ServletOutputStream outputStream = response.getOutputStream();
        parameters
                .setClinicName(clinicName)
                .setPatientId(patientId)
                .setStartDate(startDate)
                .setEndDate(endDate);
        reportingService.export(parameters, response.getOutputStream(), "smsReport.jasper");
    }
}
