package org.motechproject.tama.reports.web;

import org.apache.log4j.Logger;
import org.motechproject.tama.reports.contract.PatientEventRequest;
import org.motechproject.tama.reports.domain.export.ReportingService;
import org.motechproject.tama.reports.domain.service.PatientEventService;
import org.motechproject.tama.reports.mapping.PatientEventRequestMapper;
import org.motechproject.tama.reports.web.excel.PatientEventParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/patientEvent")
@Controller
public class PatientEventController {

    private PatientEventService patientEventService;
    private ReportingService reportingService;
    private Logger logger = Logger.getLogger(PatientEventController.class);

    @Autowired
    public PatientEventController(PatientEventService patientEventService, ReportingService reportingService) {
        this.patientEventService = patientEventService;
        this.reportingService = reportingService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody PatientEventRequest request) {
        logger.info("Creating patient event");
        patientEventService.save(new PatientEventRequestMapper(request).map());
    }

    @RequestMapping(value = "report", method = RequestMethod.GET)
    public void report(@RequestParam("clinicName") String clinicName,
                       @RequestParam("patientId") String patientId,
                       @RequestParam("startDate") String startDate,
                       @RequestParam("endDate") String endDate,
                       @RequestParam("eventName") String eventName,
                       HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "inline; filename=PatientEvent.xls");
        response.setContentType("application/vnd.ms-excel");
        PatientEventParameters parameters = new PatientEventParameters();
        ServletOutputStream outputStream = response.getOutputStream();
        parameters
                .setClinicName(clinicName)
                .setPatientId(patientId)
                .setEventName(eventName)
                .setStartDate(startDate)
                .setEndDate(endDate);
        reportingService.export(parameters, outputStream, "patientEvent.jasper");
    }
}
