package org.motechproject.tama.reports.contract;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class MessagesRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String patientDocumentId;
    private Date callDate;
    private String callDirection;
    private List<String> messagesPlayed;
    private Integer numberOfTimesMessagesAccessed;
    private List<Integer> individualMessagesAccessDurations;
    private Long totalMessagesAccessDuration;
    private List<String> pushedMessages;

}
