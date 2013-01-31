package org.motechproject.tama.reports.web;

import org.apache.log4j.Logger;
import org.motechproject.tama.reports.contract.PatientEventRequest;
import org.motechproject.tama.reports.domain.service.PatientEventService;
import org.motechproject.tama.reports.mapping.PatientEventRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/patientEvent")
@Controller
public class PatientEventController {

    private PatientEventService patientEventService;
    private Logger logger = Logger.getLogger(PatientEventController.class);

    @Autowired
    public PatientEventController(PatientEventService patientEventService) {
        this.patientEventService = patientEventService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody PatientEventRequest request) {
        logger.info("Creating patient event");
        patientEventService.save(new PatientEventRequestMapper(request).map());
    }
}
