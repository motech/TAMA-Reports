package org.motechproject.tama.reports.web;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.log4j.Logger;
import org.motechproject.tama.reports.contract.PatientRequest;
import org.motechproject.tama.reports.domain.service.PatientService;
import org.motechproject.tama.reports.mapping.PatientRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

@RequestMapping("/patient")
@Controller
public class PatientController {

    private PatientService patientService;
    private Logger logger = Logger.getLogger(PatientController.class);

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody PatientRequest patientRequest) {
        logger.info("Creating patient");
        patientService.save(new PatientRequestMapper(patientRequest).map());
    }

    @RequestMapping(value = "update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody PatientRequest patientRequest) {
        logger.info("Updating patient");
        patientService.update(new PatientRequestMapper(patientRequest).map());
    }

    @RequestMapping(value = "report", method = RequestMethod.GET)
    public void report(HttpServletResponse response) throws JRException, SQLException, IOException {
        JasperReport report = (JasperReport) JRLoader.loadObject(new ClassPathResource("patient.jasper").getInputStream());
        Connection connection = patientService.getConnection();
        JasperPrint print = JasperFillManager.fillReport(report, new HashMap(), connection);
        JExcelApiExporter exporterXLS = new JExcelApiExporter();
        exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
        exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, response.getOutputStream());
        exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
        exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
        exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
        exporterXLS.exportReport();
        connection.close();
    }
}

