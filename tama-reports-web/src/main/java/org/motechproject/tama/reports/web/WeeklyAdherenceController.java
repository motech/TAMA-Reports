package org.motechproject.tama.reports.web;

import org.apache.log4j.Logger;
import org.motechproject.tama.reports.contract.WeeklyAdherenceLogRequest;
import org.motechproject.tama.reports.domain.export.ReportingService;
import org.motechproject.tama.reports.domain.service.WeeklyAdherenceService;
import org.motechproject.tama.reports.mapping.WeeklyAdherenceLogMapper;
import org.motechproject.tama.reports.web.excel.WeeklyAdherenceParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/weekly")
@Controller
public class WeeklyAdherenceController {
    private Logger logger = Logger.getLogger(WeeklyAdherenceController.class);
    private WeeklyAdherenceService weeklyAdherenceService;
    private ReportingService reportingService;

    @Autowired
    public WeeklyAdherenceController(WeeklyAdherenceService weeklyAdherenceService, ReportingService reportingService) {
        this.weeklyAdherenceService = weeklyAdherenceService;
        this.reportingService = reportingService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody WeeklyAdherenceLogRequest weeklyAdherenceLogRequest) {
        logger.info("Creating weekly adherence log");
        weeklyAdherenceService.save(new WeeklyAdherenceLogMapper(weeklyAdherenceLogRequest).map(),weeklyAdherenceLogRequest);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody WeeklyAdherenceLogRequest weeklyAdherenceLogRequest) {
        logger.info("Updating weekly adherence log");
        weeklyAdherenceService.update(new WeeklyAdherenceLogMapper(weeklyAdherenceLogRequest).map());
    }

    @RequestMapping(value = "report", method = RequestMethod.GET)
    public void report(@RequestParam("clinicId") String clinicId,
                       @RequestParam("patientId") String patientId,
                       @RequestParam("startDate") String startDate,
                       @RequestParam("endDate") String endDate,
                       HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "inline; filename=WeeklyAdherenceReport.xls");
        response.setContentType("application/vnd.ms-excel");
        WeeklyAdherenceParameters parameters = new WeeklyAdherenceParameters();
        ServletOutputStream outputStream = response.getOutputStream();
        parameters
                .setPatientId(patientId)
                .setClinicId(clinicId)
                .setStartDate(startDate)
                .setEndDate(endDate);
        reportingService.export(parameters, outputStream, "weekly.jasper");
    }

}
