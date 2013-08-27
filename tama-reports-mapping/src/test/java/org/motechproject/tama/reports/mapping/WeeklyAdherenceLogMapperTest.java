package org.motechproject.tama.reports.mapping;


import org.junit.Test;
import org.motechproject.tama.reports.contract.WeeklyAdherenceLogRequest;
import org.motechproject.tama.reports.domain.WeeklyAdherence;

import java.util.Date;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class WeeklyAdherenceLogMapperTest {


    @Test
    public void shouldMapPatientDocumentId() {
        WeeklyAdherenceLogRequest request = new WeeklyAdherenceLogRequest();
        WeeklyAdherenceLogMapper mapper = new WeeklyAdherenceLogMapper(request);
        assertNull(mapper.map().getPatientDocumentId());

        request.setPatientId("patientId");
        assertEquals("patientId", mapper.map().getPatientDocumentId());
    }

    @Test
    public void shouldMapClinicName() {

        WeeklyAdherenceLogRequest weeklyAdherenceLogRequest = new WeeklyAdherenceLogRequest();
        WeeklyAdherenceLogMapper weeklyAdherenceLogMapper = new WeeklyAdherenceLogMapper(weeklyAdherenceLogRequest);
        assertNull(weeklyAdherenceLogMapper.map().getClinicName());

        weeklyAdherenceLogRequest.setClinicName("clinicName");
        assertEquals("clinicName", weeklyAdherenceLogMapper.map().getClinicName());
    }

    @Test
    public void shouldMapArtStartDate() {
        WeeklyAdherenceLogRequest weeklyAdherenceLogRequest = new WeeklyAdherenceLogRequest();
        WeeklyAdherenceLogMapper weeklyAdherenceLogMapper = new WeeklyAdherenceLogMapper(weeklyAdherenceLogRequest);
        assertNull(weeklyAdherenceLogMapper.map().getArtStartDate());

        weeklyAdherenceLogRequest.setArtStartDate(new Date());
        assertEquals(new Date(), weeklyAdherenceLogMapper.map().getArtStartDate());
    }

    @Test
    public void shouldMapTreatmentAdviceId() {
        WeeklyAdherenceLogRequest weeklyAdherenceLogRequest = new WeeklyAdherenceLogRequest();
        WeeklyAdherenceLogMapper weeklyAdherenceLogMapper = new WeeklyAdherenceLogMapper(weeklyAdherenceLogRequest);
        assertNull(weeklyAdherenceLogMapper.map().getTreatmentAdviceId());

        weeklyAdherenceLogRequest.setTreatmentAdviceId("REGIMEN 1");
        assertEquals("REGIMEN 1", weeklyAdherenceLogMapper.map().getTreatmentAdviceId());
    }

    @Test
    public void shouldMapStartDate() {
        WeeklyAdherenceLogRequest weeklyAdherenceLogRequest = new WeeklyAdherenceLogRequest();
        WeeklyAdherenceLogMapper weeklyAdherenceLogMapper = new WeeklyAdherenceLogMapper(weeklyAdherenceLogRequest);
        assertNull(weeklyAdherenceLogMapper.map().getStartDate());

        weeklyAdherenceLogRequest.setStartDate(new Date());
        assertEquals(new Date(), weeklyAdherenceLogMapper.map().getStartDate());

    }

    @Test
    public void shouldMapWeekStartDate(){
        WeeklyAdherenceLogRequest weeklyAdherenceLogRequest = new WeeklyAdherenceLogRequest();
        WeeklyAdherenceLogMapper weeklyAdherenceLogMapper = new WeeklyAdherenceLogMapper(weeklyAdherenceLogRequest);
        assertNull(weeklyAdherenceLogMapper.map().getWeekStartDate());

        weeklyAdherenceLogRequest.setWeekStartDate(new Date());
        assertEquals(new Date(), weeklyAdherenceLogMapper.map().getWeekStartDate());
    }

    @Test
    public void shouldMapFirstCallDate(){
        WeeklyAdherenceLogRequest weeklyAdherenceLogRequest = new WeeklyAdherenceLogRequest();
        WeeklyAdherenceLogMapper weeklyAdherenceLogMapper = new WeeklyAdherenceLogMapper(weeklyAdherenceLogRequest);
        assertNull(weeklyAdherenceLogMapper.map().getFirstCallDate());

        weeklyAdherenceLogRequest.setFirstCallDate(new Date());
        assertEquals(new Date(), weeklyAdherenceLogMapper.map().getFirstCallDate());
    }

    @Test
    public void shouldMapAdherenceReportedOn(){
        WeeklyAdherenceLogRequest weeklyAdherenceLogRequest = new WeeklyAdherenceLogRequest();
        WeeklyAdherenceLogMapper weeklyAdherenceLogMapper = new WeeklyAdherenceLogMapper(weeklyAdherenceLogRequest);
        assertNull(weeklyAdherenceLogMapper.map().getAdherenceReportedOn());

        weeklyAdherenceLogRequest.setAdherenceLoggedDate(new Date());
        assertEquals(new Date(), weeklyAdherenceLogMapper.map().getAdherenceReportedOn());
    }

    @Test public void shouldMapNumberOfDosesMissed(){
        WeeklyAdherenceLogRequest weeklyAdherenceLogRequest = new WeeklyAdherenceLogRequest();
        WeeklyAdherenceLogMapper weeklyAdherenceLogMapper = new WeeklyAdherenceLogMapper(weeklyAdherenceLogRequest);
        assertEquals("0",weeklyAdherenceLogMapper.map().getNumberOfDosesMissed());

        weeklyAdherenceLogRequest.setNumberOfDaysMissed(4);
        assertEquals("4", weeklyAdherenceLogMapper.map().getNumberOfDosesMissed());
    }

    @Test
    public void shouldDateOfUpdateInsert(){
        WeeklyAdherenceLogRequest weeklyAdherenceLogRequest = new WeeklyAdherenceLogRequest();
        WeeklyAdherenceLogMapper weeklyAdherenceLogMapper = new WeeklyAdherenceLogMapper(weeklyAdherenceLogRequest);
        assertNull(weeklyAdherenceLogMapper.map().getDateOfUpdateInsert());

        weeklyAdherenceLogRequest.setDateOfUpdateInsert(new Date());
        assertEquals(new Date(), weeklyAdherenceLogMapper.map().getDateOfUpdateInsert());
    }




}
