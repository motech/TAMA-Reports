package org.motechproject.tama.reports.contract;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClinicianContactRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String clinicId;
    private String name;
    private String phoneNumber;

    public String getClinicianId() {
        return id;
    }

    public void setClinicianId(String id) {
        this.setId(id);
    }
}
