package org.motechproject.tama.reports.domain.export;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

import java.io.OutputStream;

public class TAMAExcelExporter {

    JRXlsExporter exporterXLS;

    public TAMAExcelExporter() {
        exporterXLS = new JRXlsExporter();
        exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
        exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
        exporterXLS.setParameter(JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN, Boolean.TRUE);
        exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
    }

    public void export(JasperPrint print, OutputStream outputStream) throws JRException {
        exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
        exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, outputStream);
        exporterXLS.exportReport();
    }
}
