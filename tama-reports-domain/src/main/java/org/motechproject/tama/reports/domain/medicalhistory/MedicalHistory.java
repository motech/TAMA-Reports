package org.motechproject.tama.reports.domain.medicalhistory;

import lombok.Data;

import javax.persistence.*;

@Table(name = "medical_history")
@Data
@Entity
public class MedicalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "patient_id")
    private String patientId;

    private GeneralHistory generalHistory;
    private SystemAllergies systemAllergies;
}
