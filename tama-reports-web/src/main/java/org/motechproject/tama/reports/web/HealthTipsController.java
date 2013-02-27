package org.motechproject.tama.reports.web;

import org.apache.log4j.Logger;
import org.motechproject.tama.reports.contract.HealthTipsRequest;
import org.motechproject.tama.reports.domain.export.ReportingService;
import org.motechproject.tama.reports.domain.service.HealthTipsService;
import org.motechproject.tama.reports.mapping.HealthTipsMapper;
import org.motechproject.tama.reports.web.excel.HealthTipsParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/healthTips")
@Controller
public class HealthTipsController {

    private Logger logger = Logger.getLogger(HealthTipsController.class);
    private HealthTipsService healthTipsService;
    private ReportingService reportingService;

    @Autowired
    public HealthTipsController(HealthTipsService healthTipsService, ReportingService reportingService) {
        this.healthTipsService = healthTipsService;
        this.reportingService = reportingService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody HealthTipsRequest healthTipsRequest) {
        logger.info("Saving health tips");
        healthTipsService.save(new HealthTipsMapper(healthTipsRequest).map());
    }

    @RequestMapping(value = "report", method = RequestMethod.GET)
    public void report(@RequestParam("clinicName") String clinicName,
                       @RequestParam("patientId") String patientId,
                       @RequestParam("startDate") String startDate,
                       @RequestParam("endDate") String endDate,
                       HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "inline; filename=HealthTipsReport.xls");
        response.setContentType("application/vnd.ms-excel");
        HealthTipsParameters parameters = new HealthTipsParameters();
        ServletOutputStream outputStream = response.getOutputStream();
        parameters
                .setClinicId(clinicName)
                .setPatientId(patientId)
                .setStartDate(startDate)
                .setEndDate(endDate);
        reportingService.export(parameters, outputStream, "healthTips.jasper");
    }
}

