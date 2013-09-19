package org.motechproject.tama.reports.web;

import org.apache.log4j.Logger;
import org.motechproject.tama.reports.contract.ClinicianContactRequests;
import org.motechproject.tama.reports.domain.service.ClinicianService;
import org.motechproject.tama.reports.mapping.ClinicianContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/clinicianContact")
@Controller
public class ClinicianContactController {

    private ClinicianService clinicianService;
    private Logger logger = Logger.getLogger(ClinicController.class);

    @Autowired
    public ClinicianContactController(ClinicianService clinicianService) {
        this.clinicianService = clinicianService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody ClinicianContactRequests clinicianContactsRequest) {
        logger.info("Creating clinician from clinicianContact");
        clinicianService.save(new ClinicianContactMapper(clinicianContactsRequest.getClinicianContactRequests()).map());
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody ClinicianContactRequests clinicianContactsRequest) {
        logger.info("Updating clinician from clinicianContact");
        clinicianService.update(new ClinicianContactMapper(clinicianContactsRequest.getClinicianContactRequests()).map());
    }
}
