package org.motechproject.tama.reports.web;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.log4j.Logger;
import org.drools.io.impl.ClassPathResource;
import org.motechproject.tama.reports.contract.PatientRequest;
import org.motechproject.tama.reports.domain.service.PatientService;
import org.motechproject.tama.reports.mapping.PatientRequestMapper;
import org.motechproject.tama.reports.web.excel.patient.PatientRegistrationParameters;
import org.motechproject.tama.reports.web.excel.patient.PatientReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

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
    public void report(@RequestParam("clinicName") String clinicName, @RequestParam("patientId") String patientId, HttpServletResponse response) throws Exception {
        JasperReport report = (JasperReport) JRLoader.loadObject(new ClassPathResource("patient.jasper").getInputStream());
        PatientRegistrationParameters parameters = new PatientRegistrationParameters();
        ServletOutputStream outputStream = response.getOutputStream();
        parameters
                .setClinicName(clinicName)
                .setPatientId(patientId);
        new PatientReportService(patientService).export(parameters, outputStream);
    }
}

