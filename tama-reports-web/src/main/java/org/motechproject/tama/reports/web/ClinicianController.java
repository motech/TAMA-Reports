package org.motechproject.tama.reports.web;

import org.apache.log4j.Logger;
import org.motechproject.tama.reports.contract.ClinicianRequest;
import org.motechproject.tama.reports.domain.export.ReportingService;
import org.motechproject.tama.reports.domain.service.ClinicianService;
import org.motechproject.tama.reports.mapping.ClinicianRequestMapper;
import org.motechproject.tama.reports.web.excel.ClinicianParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/clinician")
@Controller
public class ClinicianController {

    private ClinicianService clinicianService;
    private Logger logger = Logger.getLogger(ClinicianController.class);
    private ReportingService reportingService;

    @Autowired
    public ClinicianController(ClinicianService clinicianService, ReportingService reportingService) {
        this.clinicianService = clinicianService;
        this.reportingService = reportingService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody ClinicianRequest clinicianRequest) {
        logger.info("Creating clinician");
        clinicianService.save(new ClinicianRequestMapper(clinicianRequest).map());
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody ClinicianRequest clinicianRequest) {
        logger.info("Updating clinician");
        clinicianService.update(new ClinicianRequestMapper(clinicianRequest).map());
    }

    @RequestMapping(value = "report", method = RequestMethod.GET)
    public void report(HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "inline; filename=Clinicians.xls");
        response.setContentType("application/vnd.ms-excel");
        ClinicianParameters parameters = new ClinicianParameters();
        ServletOutputStream outputStream = response.getOutputStream();
        reportingService.export(parameters, outputStream, "clinicians.jasper");
    }
}

