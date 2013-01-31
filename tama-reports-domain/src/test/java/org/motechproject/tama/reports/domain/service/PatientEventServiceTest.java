package org.motechproject.tama.reports.domain.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.tama.reports.domain.PatientEvent;
import org.motechproject.tama.reports.domain.builder.PatientEventBuilder;
import org.motechproject.tama.reports.domain.repository.AllPatientsEvents;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class PatientEventServiceTest {

    @Mock
    private AllPatientsEvents allPatientsEvents;
    private PatientEventService service;

    @Before
    public void setup() {
        initMocks(this);
        service = new PatientEventService(allPatientsEvents);
    }

    @Test
    public void shouldSavePatientEvent() {
        PatientEvent event = PatientEventBuilder.validEvent();
        service.save(event);

        verify(allPatientsEvents).save(event);
    }
}
