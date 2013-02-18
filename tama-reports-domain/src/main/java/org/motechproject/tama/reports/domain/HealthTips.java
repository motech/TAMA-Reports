package org.motechproject.tama.reports.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "health_tips")
@Entity
public class HealthTips {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "patient_document_id")
    private String patientDocumentId;

    @Column(name = "call_date")
    private Date callDate;

    @Column(name = "call_direction")
    private String callDirection;

    @Column(name = "health_tips_played")
    private String healthTipsPlayed;

    @Column(name = "number_of_times_health_tips_accessed")
    private Integer numberOfTimesHealthTipsAccessed;

    @Column(name = "individual_health_tips_access_durations")
    private String individualHealthTipsAccessDurations;

    @Column(name = "total_health_tips_access_duration")
    private Long totalHealthTipsAccessDuration;

}
