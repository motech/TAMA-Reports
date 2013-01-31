package org.motechproject.tama.reports.domain.export;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.OutputStream;
import java.sql.Connection;

@Service
@Transactional
public class ReportingService {

    private BasicDataSource dataSource;

    ReportingService() {
    }

    @Autowired
    public ReportingService(@Qualifier("dataSource") BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void export(ReportParameters parameters, OutputStream outputStream, String path) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            JasperReport report = (JasperReport) JRLoader.loadObject(new ClassPathResource(path).getInputStream());
            new TAMAExcelExporter().export(JasperFillManager.fillReport(report, parameters.parameters(), connection), outputStream);
        }
    }
}
