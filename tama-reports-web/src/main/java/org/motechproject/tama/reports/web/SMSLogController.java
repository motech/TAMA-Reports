package org.motechproject.tama.reports.web;

import org.apache.log4j.Logger;
import org.motechproject.tama.reports.contract.SMSLogRequest;
import org.motechproject.tama.reports.domain.SMSLog;
import org.motechproject.tama.reports.domain.export.ReportParameters;
import org.motechproject.tama.reports.domain.export.ReportingService;
import org.motechproject.tama.reports.domain.service.SMSLogService;
import org.motechproject.tama.reports.mapping.RequestMapper;
import org.motechproject.tama.reports.web.excel.ClinicianSMSLogParameters;
import org.motechproject.tama.reports.web.excel.OTCSMSLogParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import static org.apache.commons.lang.StringUtils.equalsIgnoreCase;

@RequestMapping("/smsLog")
@Controller
public class SMSLogController {

    public static final String CLINICIAN_SMS = "ClinicianSMS";

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
    public void report(@RequestParam("type") String smsType,
                       @RequestParam("clinicName") String clinicName,
                       @RequestParam("externalId") String externalId,
                       @RequestParam("startDate") String startDate,
                       @RequestParam("endDate") String endDate,
                       HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "inline; filename=SMSReport.xls");
        response.setContentType("application/vnd.ms-excel");
        ServletOutputStream outputStream = response.getOutputStream();
        if (equalsIgnoreCase(CLINICIAN_SMS, smsType)) {
            reportClinicianSMS(clinicName, externalId, startDate, endDate, response);
        } else {
            reportOTCAdviceSMS(clinicName, externalId, startDate, endDate, response);
        }
    }

    private void reportOTCAdviceSMS(String clinicName, String externalId, String startDate, String endDate, HttpServletResponse response) throws Exception {
        OTCSMSLogParameters parameters = new OTCSMSLogParameters();
        parameters
                .setClinicId(clinicName)
                .setPatientId(externalId)
                .setStartDate(startDate)
                .setEndDate(endDate);
        exportReport(response, parameters, "OTCSMSReport.jasper");
    }

    private void reportClinicianSMS(String clinicName, String externalId, String startDate, String endDate, HttpServletResponse response) throws Exception {
        ClinicianSMSLogParameters parameters = new ClinicianSMSLogParameters();
        parameters
                .setClinicName(clinicName)
                .setClinicianName(externalId)
                .setStartDate(startDate)
                .setEndDate(endDate);
        exportReport(response, parameters, "ClinicianSMSReport.jasper");
    }

    private void exportReport(HttpServletResponse response, ReportParameters parameters, String reportName) throws Exception {
        reportingService.export(parameters, response.getOutputStream(), reportName);
    }
}
