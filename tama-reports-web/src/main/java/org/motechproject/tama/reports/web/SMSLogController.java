package org.motechproject.tama.reports.web;

import org.apache.log4j.Logger;
import org.motechproject.tama.reports.contract.SMSLogRequest;
import org.motechproject.tama.reports.domain.SMSLog;
import org.motechproject.tama.reports.domain.export.ReportParameters;
import org.motechproject.tama.reports.domain.export.ReportingService;
import org.motechproject.tama.reports.domain.service.SMSLogService;
import org.motechproject.tama.reports.mapping.RequestMapper;
import org.motechproject.tama.reports.web.excel.ClinicianSMSLogParameters;
import org.motechproject.tama.reports.web.excel.MonitoringAgentSMSLogParameters;
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
    public static final String MonitoringAgent_SMS = "MonitoringAgentSMS";

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
                       @RequestParam("clinicId") String clinicId,
                       @RequestParam("externalId") String externalId,
                       @RequestParam("startDate") String startDate,
                       @RequestParam("endDate") String endDate,
                       HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "inline; filename=SMSReport.xls");
        response.setContentType("application/vnd.ms-excel");
        ServletOutputStream outputStream = response.getOutputStream();
        if (equalsIgnoreCase(CLINICIAN_SMS, smsType)) {
            reportClinicianSMS(clinicId, externalId, startDate, endDate, response);
        } else {
            reportOTCAdviceSMS(clinicId, externalId, startDate, endDate, response);
        }
    }
    
    @RequestMapping(value = "agentReport", method = RequestMethod.GET)
    public void agentReport(@RequestParam("type") String smsType,
                       @RequestParam("externalId") String externalId,
                       @RequestParam("startDate") String startDate,
                       @RequestParam("endDate") String endDate,
                       HttpServletResponse response) throws Exception {
    	try{
        response.setHeader("Content-Disposition", "inline; filename=AgentSMSReport.xls");
        response.setContentType("application/vnd.ms-excel");
        ServletOutputStream outputStream = response.getOutputStream();
        if(equalsIgnoreCase(MonitoringAgent_SMS, smsType)){
        	reportMonitoringAgentSMS( externalId, startDate, endDate, response);
        }
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
        
    }

    private void reportOTCAdviceSMS(String clinicId, String externalId, String startDate, String endDate, HttpServletResponse response) throws Exception {
        OTCSMSLogParameters parameters = new OTCSMSLogParameters();
        parameters
                .setClinicId(clinicId)
                .setPatientId(externalId)
                .setStartDate(startDate)
                .setEndDate(endDate);
        exportReport(response, parameters, "OTCSMSReport.jasper");
    }

    private void reportClinicianSMS(String clinicId, String externalId, String startDate, String endDate, HttpServletResponse response) throws Exception {
        ClinicianSMSLogParameters parameters = new ClinicianSMSLogParameters();
        parameters
                .clinicId(clinicId)
                .setClinicianName(externalId)
                .setStartDate(startDate)
                .setEndDate(endDate);
        exportReport(response, parameters, "ClinicianSMSReport.jasper");
    }
    
    private void reportMonitoringAgentSMS( String externalId, String startDate, String endDate, HttpServletResponse response) throws Exception {
    	MonitoringAgentSMSLogParameters parameters = new MonitoringAgentSMSLogParameters();
        parameters
                .setMonitoringAgentId(externalId)
                .setStartDate(startDate)
                .setEndDate(endDate);
        exportReport(response, parameters, "MonitoringAgentSMSReport.jasper");
    }

    private void exportReport(HttpServletResponse response, ReportParameters parameters, String reportName) throws Exception {
        reportingService.export(parameters, response.getOutputStream(), reportName);
    }
}
