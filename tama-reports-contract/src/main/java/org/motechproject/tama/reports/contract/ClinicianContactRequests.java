package org.motechproject.tama.reports.contract;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
public class ClinicianContactRequests implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<ClinicianContactRequest> clinicianContactRequests;

    public ClinicianContactRequests() {
        clinicianContactRequests = new ArrayList<>();
    }

    public ClinicianContactRequests(List<ClinicianContactRequest> clinicianContactRequests) {
        this.clinicianContactRequests = clinicianContactRequests;
    }
}
