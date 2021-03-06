package org.motechproject.tama.reports.contract;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClinicRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String clinicId;
    private String clinicName;
    private String cityName;
    private String monitoringAgentId;
    private String greetingName;
    private String address;
    private String contactNumber;
}
