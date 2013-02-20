package org.motechproject.tama.reports.contract;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SMSLogRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String externalId;
    private String receiverType;
    private String content;
    private String recipientNumber;
    private Date timeStamp;

}
