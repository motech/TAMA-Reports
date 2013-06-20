package org.motechproject.tama.reports.contract;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data

public class WeeklyAdherenceLogRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String patientId;
    private String clinicName;
    private Date artStartDate;
    private String treatmentAdviceId;
    private Date startDate;
    private Date weekStartDate;
    private Date firstCallDate;
    private Date adherenceLoggedDate;
    private int numberOfDaysMissed;
    private Date dateOfUpdateInsert;


}
