package org.motechproject.tama.reports.web;

import org.apache.log4j.Logger;
import org.motechproject.tama.reports.contract.MedicalHistoryRequest;
import org.motechproject.tama.reports.domain.service.MedicalHistoryService;
import org.motechproject.tama.reports.mapping.MedicalHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@RequestMapping("/medicalHistory")
@Controller
public class MedicalHistoryController {

    private MedicalHistoryService medicalHistoryService;
    private Logger logger = Logger.getLogger(MedicalHistoryController.class);

    @Autowired
    public MedicalHistoryController(MedicalHistoryService medicalHistoryService) {
        this.medicalHistoryService = medicalHistoryService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody MedicalHistoryRequest request) throws IOException {
        logger.info("Creating medical history");
        medicalHistoryService.save(new MedicalHistoryMapper(request).map());
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody MedicalHistoryRequest request) throws IOException {
        logger.info("Updating medical history");
        medicalHistoryService.update(new MedicalHistoryMapper(request).map());
    }
}

