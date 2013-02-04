package org.motechproject.tama.reports.domain.export;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

import java.io.OutputStream;

public class TAMAExcelExporter {

    JExcelApiExporter exporterXLS;

    public TAMAExcelExporter() {
        exporterXLS = new JExcelApiExporter();
        exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
        exporterXLS.setParameter(JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN, Boolean.TRUE);
        exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
    }

    public void export(JasperPrint print, OutputStream outputStream) throws JRException {
        exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
        exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, outputStream);
        exporterXLS.exportReport();
    }
}
