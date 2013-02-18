package org.motechproject.tama.reports.web;

import org.apache.log4j.Logger;
import org.motechproject.tama.reports.contract.HealthTipsRequest;
import org.motechproject.tama.reports.domain.service.HealthTipsService;
import org.motechproject.tama.reports.mapping.HealthTipsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/healthTips")
@Controller
public class HealthTipsController {

    private Logger logger = Logger.getLogger(HealthTipsController.class);
    private HealthTipsService healthTipsService;

    @Autowired
    public HealthTipsController(HealthTipsService healthTipsService) {
        this.healthTipsService = healthTipsService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody HealthTipsRequest healthTipsRequest) {
        logger.info("Saving health tips");
        healthTipsService.save(new HealthTipsMapper(healthTipsRequest).map());
    }
}

