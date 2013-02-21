package org.motechproject.tama.reports.web;

import org.apache.log4j.Logger;
import org.motechproject.tama.reports.contract.ClinicRequest;
import org.motechproject.tama.reports.domain.Clinic;
import org.motechproject.tama.reports.domain.service.ClinicService;
import org.motechproject.tama.reports.mapping.RequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/clinic")
@Controller
public class ClinicController {

    private ClinicService clinicService;
    private Logger logger = Logger.getLogger(ClinicController.class);

    @Autowired
    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
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
}

