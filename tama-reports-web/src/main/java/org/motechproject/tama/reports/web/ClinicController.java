package org.motechproject.tama.reports.web;

import org.apache.log4j.Logger;
import org.motechproject.tama.reports.contract.ClinicRequest;
import org.motechproject.tama.reports.domain.Clinic;
import org.motechproject.tama.reports.domain.export.ReportingService;
import org.motechproject.tama.reports.domain.service.ClinicService;
import org.motechproject.tama.reports.mapping.RequestMapper;
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

@RequestMapping("/clinic")
@Controller
public class ClinicController {

    private ClinicService clinicService;
    private ReportingService reportingService;
    private Logger logger = Logger.getLogger(ClinicController.class);

    @Autowired
    public ClinicController(ClinicService clinicService, ReportingService reportingService) {
        this.clinicService = clinicService;
        this.reportingService = reportingService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody ClinicRequest clinicRequest) {
        logger.info("Creating clinic");
        clinicService.save(new RequestMapper<ClinicRequest, Clinic>().map(clinicRequest, Clinic.class));
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody ClinicRequest clinicRequest) {
        logger.info("Updating clinic");
        clinicService.update(new RequestMapper<ClinicRequest, Clinic>().map(clinicRequest, Clinic.class));
    }

    @RequestMapping(value = "report", method = RequestMethod.GET)
    public void report(HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "inline; filename=Clinics.xls");
        response.setContentType("application/vnd.ms-excel");
        ClinicianParameters parameters = new ClinicianParameters();
        ServletOutputStream outputStream = response.getOutputStream();
        reportingService.export(parameters, outputStream, "clinics.jasper");
    }
}

