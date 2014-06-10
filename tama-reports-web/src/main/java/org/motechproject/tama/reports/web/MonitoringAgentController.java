package org.motechproject.tama.reports.web;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.motechproject.tama.reports.contract.MonitoringAgentRequest;
import org.motechproject.tama.reports.domain.export.ReportingService;
import org.motechproject.tama.reports.domain.service.MonitoringAgentService;
import org.motechproject.tama.reports.mapping.MonitoringAgentMapper;
import org.motechproject.tama.reports.web.excel.MonitoringAgentParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/monitoringAgent")
@Controller
public class MonitoringAgentController {

	private MonitoringAgentService monitoringAgentService;
	private Logger logger = Logger.getLogger(MonitoringAgentController.class);
	private ReportingService reportingService;

	 @Autowired
	public MonitoringAgentController(
			MonitoringAgentService monitoringAgentService,
			ReportingService reportingService) {
		this.monitoringAgentService = monitoringAgentService;
		this.reportingService = reportingService;
	}

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody MonitoringAgentRequest monitoringAgentRequest) {
        logger.info("Creating monitoringAgent");
        monitoringAgentService.save(new MonitoringAgentMapper(monitoringAgentRequest).map());
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody MonitoringAgentRequest monitoringAgentRequest) {
        logger.info("Updating monitoringAgent");
        monitoringAgentService.update(new MonitoringAgentMapper(monitoringAgentRequest).map());
    }
    
    @RequestMapping(value = "report", method = RequestMethod.GET)
    public void report(HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "inline; filename=MonitoringAgents.xls");
        response.setContentType("application/vnd.ms-excel");
        MonitoringAgentParameters parameters = new MonitoringAgentParameters();
        ServletOutputStream outputStream = response.getOutputStream();
        reportingService.export(parameters, outputStream, "monitoringAgents.jasper");
    }
}
