package org.motechproject.tama.reports.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "sms_log")
@Entity
public class SMSLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "external_id")
    private String externalId;

    @Column(name = "receiver_type")
    private String receiverType;

    @Column(name = "content")
    private String content;

    @Column(name = "recipient_number")
    private String recipientNumber;

    @Column(name = "time_stamp")
    private Date timeStamp;
}
