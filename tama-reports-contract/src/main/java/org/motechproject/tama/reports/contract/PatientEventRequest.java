package org.motechproject.tama.reports.contract;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PatientEventRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String patientDocumentId;
    private String eventName;
    private Date dateTime;
    private String performedBy;
}
