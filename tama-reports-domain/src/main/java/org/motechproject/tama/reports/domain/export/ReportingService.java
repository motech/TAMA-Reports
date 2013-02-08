package org.motechproject.tama.reports.domain.export;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.fill.JRSwapFileVirtualizer;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSwapFile;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
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
        JRSwapFileVirtualizer virtualizer = null;
        try (Connection connection = dataSource.getConnection()) {
            virtualizer = createVirtualizer(virtualizer);
            setUpParams(parameters, virtualizer);
            export(parameters, outputStream, path, connection);
        } finally {
            if (null != virtualizer) {
                virtualizer.cleanup();
            }
        }
    }

    private void export(ReportParameters parameters, OutputStream outputStream, String path, Connection connection) throws JRException, IOException {
        JasperReport report = (JasperReport) JRLoader.loadObject(new ClassPathResource(path).getInputStream());
        new TAMAExcelExporter().export(JasperFillManager.fillReport(report, parameters.parameters(), connection), outputStream);
    }

    private void setUpParams(ReportParameters parameters, JRSwapFileVirtualizer virtualizer) {
        parameters.parameters().put(JRParameter.REPORT_VIRTUALIZER, virtualizer);
    }

    private JRSwapFileVirtualizer createVirtualizer(JRSwapFileVirtualizer virtualizer) {
        JRSwapFile swapFile = new JRSwapFile("/tmp", 1024, 100);
        virtualizer = new JRSwapFileVirtualizer(50, swapFile, true);
        return virtualizer;
    }
}
