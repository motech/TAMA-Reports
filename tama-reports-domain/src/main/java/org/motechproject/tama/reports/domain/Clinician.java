package org.motechproject.tama.reports.domain;


import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Table(name = "clinician")
@Entity
public class Clinician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "clinician_id")
    private String clinicianId;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "alternate_number")
    private String alternateNumber;

    @Column(name = "role")
    private String role;

    @NotBlank
    @Column(name = "clinic_id")
    private String clinicId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "type")
    private String type;

    @NotNull
    @Column(name = "clinician_name")
    private String name;

    public void merge(Clinician clinician) {
        setContactNumber(clinician.getContactNumber());
        setClinicId(clinician.getClinicId());
        setAlternateNumber(clinician.getAlternateNumber());
        setRole(clinician.getRole());
        setType(clinician.getType());
        setUserName(clinician.getUserName());
        setName(clinician.getName());
    }
}
