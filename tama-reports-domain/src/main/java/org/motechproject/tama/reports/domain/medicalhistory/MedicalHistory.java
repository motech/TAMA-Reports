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
    @Column(name = "test_reason")
    private String testReason;
    @Column(name = "modes_of_transmission")
    private String modesOfTransmission;

    private GeneralHistory generalHistory;
    private SystemAllergies systemAllergies;

    public void merge(MedicalHistory history) {
        this.testReason = history.getTestReason();
        this.modesOfTransmission = history.getModesOfTransmission();
        this.generalHistory = history.getGeneralHistory();
        this.systemAllergies = history.getSystemAllergies();
    }
}
