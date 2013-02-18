package org.motechproject.tama.reports.contract;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class HealthTipsRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String patientDocumentId;
    private Date callDate;
    private String callDirection;
    private List<String> healthTipsPlayed;
    private Integer numberOfTimesHealthTipsAccessed;
    private List<Integer> individualHealthTipsAccessDurations;
    private Long totalHealthTipsAccessDuration;

}
