package org.motechproject.tama.reports.mapping;

import org.junit.Test;
import org.motechproject.tama.reports.contract.HealthTipsRequest;
import org.motechproject.tama.reports.domain.HealthTips;
import org.motechproject.util.DateUtil;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class HealthTipsMapperTest {

    @Test
    public void shouldMapPatientDocumentId() {
        HealthTipsRequest healthTipsRequest = new HealthTipsRequest();
        healthTipsRequest.setPatientDocumentId("patientDocumentId");

        HealthTips healthTips = new HealthTipsMapper(healthTipsRequest).map();
        assertEquals(healthTipsRequest.getPatientDocumentId(), healthTips.getPatientDocumentId());
    }

    @Test
    public void shouldMapCallDate() {
        HealthTipsRequest healthTipsRequest = new HealthTipsRequest();
        healthTipsRequest.setCallDate(DateUtil.now().toDate());

        HealthTips healthTips = new HealthTipsMapper(healthTipsRequest).map();
        assertEquals(healthTipsRequest.getCallDate(), healthTips.getCallDate());
    }

    @Test
    public void shouldMapCallDirection() {
        HealthTipsRequest healthTipsRequest = new HealthTipsRequest();
        healthTipsRequest.setCallDirection("incoming");

        HealthTips healthTips = new HealthTipsMapper(healthTipsRequest).map();
        assertEquals(healthTipsRequest.getCallDirection(), healthTips.getCallDirection());
    }

    @Test
    public void shouldJoinHealthTipsPlayedDuringTheCall() {
        HealthTipsRequest healthTipsRequest = new HealthTipsRequest();
        healthTipsRequest.setHealthTipsPlayed(asList("healthTip1", "healthTip2"));

        HealthTips healthTips = new HealthTipsMapper(healthTipsRequest).map();
        assertEquals("healthTip1, healthTip2", healthTips.getHealthTipsPlayed());
    }

    @Test
    public void shouldMapTotalNumberOfTimesHealthTipsWereAccessedDuringTheCall() {
        HealthTipsRequest healthTipsRequest = new HealthTipsRequest();
        healthTipsRequest.setNumberOfTimesHealthTipsAccessed(1);

        HealthTips healthTips = new HealthTipsMapper(healthTipsRequest).map();
        assertEquals(Integer.valueOf(1), healthTips.getNumberOfTimesHealthTipsAccessed());
    }

    @Test
    public void shouldJoinIndividualHealthTipsFlowDurationsDuringTheCall() {
        HealthTipsRequest healthTipsRequest = new HealthTipsRequest();
        healthTipsRequest.setIndividualHealthTipsAccessDurations(asList(1, 2));

        HealthTips healthTips = new HealthTipsMapper(healthTipsRequest).map();
        assertEquals("1, 2", healthTips.getIndividualHealthTipsAccessDurations());
    }

    @Test
    public void shouldMapTheTotalDurationOfAllHealthTipFlowsDuringTheCall() {
        HealthTipsRequest healthTipsRequest = new HealthTipsRequest();
        healthTipsRequest.setTotalHealthTipsAccessDuration(1L);

        HealthTips healthTips = new HealthTipsMapper(healthTipsRequest).map();
        assertEquals(Long.valueOf(1L), healthTips.getTotalHealthTipsAccessDuration());
    }
}
