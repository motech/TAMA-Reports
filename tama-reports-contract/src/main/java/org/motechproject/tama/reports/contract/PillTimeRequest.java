package org.motechproject.tama.reports.contract;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PillTimeRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String patientDocumentId;
    private String morningPillTime;
    private String eveningPillTime;
}


