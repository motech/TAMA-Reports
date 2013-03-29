package org.motechproject.tama.reports.web;

import org.apache.log4j.Logger;
import org.motechproject.tama.reports.contract.MessagesRequest;
import org.motechproject.tama.reports.domain.export.ReportingService;
import org.motechproject.tama.reports.domain.service.MessagesService;
import org.motechproject.tama.reports.mapping.MessagesMapper;
import org.motechproject.tama.reports.web.excel.MessagesParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/messages")
@Controller
public class MessagesController {

    private Logger logger = Logger.getLogger(MessagesController.class);
    private MessagesService messagesService;
    private ReportingService reportingService;

    @Autowired
    public MessagesController(MessagesService messagesService, ReportingService reportingService) {
        this.messagesService = messagesService;
        this.reportingService = reportingService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody MessagesRequest messagesRequest) {
        logger.info("Saving messages");
        messagesService.save(new MessagesMapper(messagesRequest).map());
    }

    @RequestMapping(value = "report", method = RequestMethod.GET)
    public void report(@RequestParam("clinicId") String clinicId,
                       @RequestParam("patientId") String patientId,
                       @RequestParam("startDate") String startDate,
                       @RequestParam("endDate") String endDate,
                       HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "inline; filename=MessagesReport.xls");
        response.setContentType("application/vnd.ms-excel");
        MessagesParameters parameters = new MessagesParameters();
        ServletOutputStream outputStream = response.getOutputStream();
        parameters
                .setClinicId(clinicId)
                .setPatientId(patientId)
                .setStartDate(startDate)
                .setEndDate(endDate);
        reportingService.export(parameters, outputStream, "messages.jasper");
    }
}

