package org.motechproject.tama.reports.mapping;

import org.apache.commons.lang.StringUtils;
import org.motechproject.tama.reports.contract.HealthTipsRequest;
import org.motechproject.tama.reports.domain.HealthTips;

public class HealthTipsMapper {

    private HealthTipsRequest healthTipsRequest;

    public HealthTipsMapper(HealthTipsRequest healthTipsRequest) {
        this.healthTipsRequest = healthTipsRequest;
    }

    public HealthTips map() {
        HealthTips healthTips = new HealthTips();
        healthTips.setPatientDocumentId(healthTipsRequest.getPatientDocumentId());
        healthTips.setCallDate(healthTipsRequest.getCallDate());
        healthTips.setCallDirection(healthTipsRequest.getCallDirection());
        healthTips.setHealthTipsPlayed(StringUtils.join(healthTipsRequest.getHealthTipsPlayed(), ", "));
        healthTips.setNumberOfTimesHealthTipsAccessed(healthTipsRequest.getNumberOfTimesHealthTipsAccessed());
        healthTips.setIndividualHealthTipsAccessDurations(StringUtils.join(healthTipsRequest.getIndividualHealthTipsAccessDurations(), ", "));
        healthTips.setTotalHealthTipsAccessDuration(healthTipsRequest.getTotalHealthTipsAccessDuration());
        return healthTips;
    }
}
