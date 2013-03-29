package org.motechproject.tama.reports.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "messages")
@Entity
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "patient_document_id")
    private String patientDocumentId;

    @Column(name = "call_date")
    private Date callDate;

    @Column(name = "call_made_by")
    private String callMadeBy;

    @Column(name = "messages_played")
    private String messagesPlayed;

    @Column(name = "pushed_messages")
    private String pushedMessages;

    @Column(name = "number_of_times_messages_accessed")
    private Integer numberOfTimesMessagesAccessed;

    @Column(name = "individual_messages_access_durations")
    private String individualMessagesAccessDurations;

    @Column(name = "total_messages_access_duration")
    private Long totalMessagesAccessDuration;

}
