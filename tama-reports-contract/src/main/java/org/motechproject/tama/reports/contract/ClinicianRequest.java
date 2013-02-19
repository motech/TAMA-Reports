package org.motechproject.tama.reports.contract;


import lombok.Data;

import java.io.Serializable;

@Data
public class ClinicianRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String clinicianId;
    private String clinicId;
    private String contactNumber;
    private String alternateNumber;
    private String role;
}
