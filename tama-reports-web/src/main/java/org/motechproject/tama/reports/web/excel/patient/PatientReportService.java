package org.motechproject.tama.reports.web.excel.patient;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.motechproject.tama.reports.domain.service.PatientService;
import org.motechproject.tama.reports.web.excel.TAMAExcelExporter;
import org.springframework.core.io.ClassPathResource;

import java.io.OutputStream;
import java.sql.Connection;

import static net.sf.jasperreports.engine.JasperFillManager.fillReport;

public class PatientReportService {

    private PatientService patientService;

    public PatientReportService(PatientService patientService) {
        this.patientService = patientService;
    }

    public void export(PatientRegistrationParameters parameters, OutputStream outputStream) throws Exception {
        JasperReport report = (JasperReport) JRLoader.loadObject(new ClassPathResource("patient.jasper").getInputStream());
        Connection connection = patientService.getConnection();
        new TAMAExcelExporter().export(fillReport(report, parameters.parameters(), connection), outputStream);
        connection.close();
    }
}
