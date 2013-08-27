package org.motechproject.tama.reports.domain.service;

import org.apache.poi.ss.usermodel.DateUtil;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.motechproject.tama.reports.contract.WeeklyAdherenceLogRequest;
import org.motechproject.tama.reports.domain.WeeklyAdherence;
import org.motechproject.tama.reports.domain.repository.AllWeeklyAdherence;

import java.util.Date;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


public class WeeklyAdherenceServiceTest {

    @Mock
    private AllWeeklyAdherence allWeeklyAdherence;

    private WeeklyAdherenceService weeklyAdherenceService;

    @Before
    public void setup() {
        initMocks(this);
        weeklyAdherenceService = new WeeklyAdherenceService(allWeeklyAdherence);
    }

    @Test
    public void shouldSaveWeeklyAdherenceLog() {
        WeeklyAdherence weeklyAdherence= new WeeklyAdherence();
        weeklyAdherenceService.save(weeklyAdherence,new WeeklyAdherenceLogRequest());
        verify(allWeeklyAdherence).save(weeklyAdherence);
    }

    @Test
    public void shouldUpdateWeeklyAdherenceLog() {
        WeeklyAdherence weeklyAdherence= new WeeklyAdherence();
        weeklyAdherence.setPatientDocumentId("pid4141");
        weeklyAdherence.setClinicName("clinic4141");
        weeklyAdherence.setWeekStartDate(new Date());
        weeklyAdherence.setNumberOfDosesMissed("3");
        WeeklyAdherence weeklyAdherencePersisted= new WeeklyAdherence();
        weeklyAdherencePersisted.setPatientDocumentId("pid4141");
        weeklyAdherencePersisted.setClinicName("clinic4141");
        weeklyAdherencePersisted.setWeekStartDate(new Date());
        when(allWeeklyAdherence.findByPatientDocumentIdAndClinicNameAndWeekStartDate(weeklyAdherence.getPatientDocumentId(),weeklyAdherence.getClinicName(),weeklyAdherence.getWeekStartDate())).thenReturn(weeklyAdherencePersisted);
        weeklyAdherenceService.update(weeklyAdherence);
        verify(allWeeklyAdherence).save(weeklyAdherence);


        WeeklyAdherence merged = mergedWeeklyAdherence();
        assertEquals(weeklyAdherence.getNumberOfDosesMissed(), merged.getNumberOfDosesMissed());
        assertEquals(weeklyAdherencePersisted.getId(), merged.getId());
    }

    private WeeklyAdherence mergedWeeklyAdherence() {

        ArgumentCaptor<WeeklyAdherence> weeklyAdherenceCaptor = ArgumentCaptor.forClass(WeeklyAdherence.class);
        verify(allWeeklyAdherence).save(weeklyAdherenceCaptor.capture());
        return weeklyAdherenceCaptor.getValue();
    }
}
