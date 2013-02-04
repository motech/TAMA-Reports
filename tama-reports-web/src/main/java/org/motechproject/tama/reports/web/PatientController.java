package org.motechproject.tama.reports.web;

import org.apache.log4j.Logger;
import org.motechproject.tama.reports.contract.PatientRequest;
import org.motechproject.tama.reports.domain.export.ReportingService;
import org.motechproject.tama.reports.domain.service.PatientService;
import org.motechproject.tama.reports.mapping.PatientRequestMapper;
import org.motechproject.tama.reports.web.excel.PatientRegistrationParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/patient")
@Controller
public class PatientController {

    private Logger logger = Logger.getLogger(PatientController.class);

    private PatientService patientService;
    private ReportingService reportingService;

    @Autowired
    public PatientController(PatientService patientService, ReportingService reportingService) {
        this.patientService = patientService;
        this.reportingService = reportingService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody PatientRequest patientRequest) {
        logger.info("Creating patient");
        patientService.save(new PatientRequestMapper(patientRequest).map());
    }

    @RequestMapping(value = "update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody PatientRequest patientRequest) {
        logger.info("Updating patient");
        patientService.update(new PatientRequestMapper(patientRequest).map());
    }

    @RequestMapping(value = "report", method = RequestMethod.GET)
    public void report(@RequestParam("clinicName") String clinicName,
                       @RequestParam("patientId") String patientId,
                       @RequestParam("startDate") String startDate,
                       @RequestParam("endDate") String endDate,
                       HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "inline; filename=PatientRegistration.xls");
        response.setContentType("application/vnd.ms-excel");
        PatientRegistrationParameters parameters = new PatientRegistrationParameters();
        ServletOutputStream outputStream = response.getOutputStream();
        parameters
                .setClinicName(clinicName)
                .setPatientId(patientId)
                .setStartDate(startDate)
                .setEndDate(endDate);
        reportingService.export(parameters, outputStream, "patient.jasper");
    }
}

