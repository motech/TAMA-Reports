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

    public void merge(Clinician clinician) {
        setContactNumber(clinician.getContactNumber());
        setAlternateNumber(clinician.getAlternateNumber());
        setRole(clinician.getRole());
    }
}
