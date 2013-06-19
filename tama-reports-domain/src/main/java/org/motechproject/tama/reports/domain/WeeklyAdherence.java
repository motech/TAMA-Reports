package org.motechproject.tama.reports.domain;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "weeklyAdherenceLog")
@Entity
public class WeeklyAdherence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotBlank
    @Column(name = "patient_document_id")
    private String patientDocumentId;

    @NotBlank
    @Column(name = "clinic_Name")
    private String clinicName;


    @Column(name = "art_start_date")
    private Date artStartDate;

    @NotBlank
    @Column(name = "treatmentAdviceId")
    private String treatmentAdviceId;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "week_start_date")
    private Date weekStartDate;

    @Column(name = "adherence_reported_on")
    private Date adherenceReportedOn;

    @Column(name = "no_of_doses_missed")
    private String numberOfDosesMissed;

    @Column(name = "date_of_update_insert")
    private  Date dateOfUpdateInsert;

    public void merge(WeeklyAdherence weeklyAdherence)
    {
        this.setPatientDocumentId(weeklyAdherence.getPatientDocumentId());
        this.setClinicName(weeklyAdherence.getClinicName());
        this.setArtStartDate(weeklyAdherence.getArtStartDate());
        this.setTreatmentAdviceId(weeklyAdherence.getTreatmentAdviceId());
        this.setStartDate(weeklyAdherence.getStartDate());
        this.setWeekStartDate(weeklyAdherence.getWeekStartDate());
        this.setAdherenceReportedOn(weeklyAdherence.getAdherenceReportedOn());
        this.setNumberOfDosesMissed(weeklyAdherence.getNumberOfDosesMissed());
        this.setDateOfUpdateInsert(weeklyAdherence.getDateOfUpdateInsert());
        this.setDateOfUpdateInsert(weeklyAdherence.getDateOfUpdateInsert());

    }
}
