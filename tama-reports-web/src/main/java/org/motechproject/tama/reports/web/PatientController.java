package org.motechproject.tama.reports.web;

import org.motechproject.tama.reports.contract.PatientRequest;
import org.motechproject.tama.reports.domain.service.PatientService;
import org.motechproject.tama.reports.mapping.PatientRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/patient")
@Controller
public class PatientController {

    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void reports(@RequestBody PatientRequest patientRequest) {
        patientService.create(new PatientRequestMapper(patientRequest).map());
    }
}

