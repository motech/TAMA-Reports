package org.motechproject.tama.reports.web;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.tama.reports.contract.WeeklyAdherenceLogRequest;
import org.motechproject.tama.reports.domain.WeeklyAdherence;
import org.motechproject.tama.reports.domain.export.ReportingService;
import org.motechproject.tama.reports.domain.service.WeeklyAdherenceService;
import org.springframework.http.MediaType;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;

public class WeeklyAdherenceControllerTest  extends BaseControllerTest {

    @Mock
    private WeeklyAdherenceService weeklyAdherenceService;
    @Mock
    private ReportingService reportingService;

    private WeeklyAdherenceController weeklyAdherenceController;


    @Before
    public void setup() {
        initMocks(this);
        weeklyAdherenceController = new WeeklyAdherenceController(weeklyAdherenceService, reportingService);
    }

    @Test
    public void shouldSaveWeeklyAdherence() throws Exception {
        WeeklyAdherenceLogRequest request = new WeeklyAdherenceLogRequest();
        request.setPatientId("patientId");
        request.setNumberOfDaysMissed(0);
        WeeklyAdherence weeklyAdherence = new WeeklyAdherence();
        weeklyAdherence.setPatientDocumentId("patientId");
        weeklyAdherence.setNumberOfDosesMissed("0");

        standaloneSetup(weeklyAdherenceController)
                .build()
                .perform(post("/weekly").contentType(MediaType.APPLICATION_JSON).body(getJSON(request).getBytes()))
                .andExpect(status().isOk());
        verify(weeklyAdherenceService).save(weeklyAdherence,request);
    }

    @Test
    public void shouldUpdateWeeklyAdherence() throws Exception {
        WeeklyAdherenceLogRequest request = new WeeklyAdherenceLogRequest();
        request.setPatientId("patientId");
        request.setNumberOfDaysMissed(0);
        WeeklyAdherence weeklyAdherence = new WeeklyAdherence();
        weeklyAdherence.setPatientDocumentId("patientId");
        weeklyAdherence.setNumberOfDosesMissed("0");

        standaloneSetup(weeklyAdherenceController)
                .build()
                .perform(put("/weekly").contentType(MediaType.APPLICATION_JSON).body(getJSON(request).getBytes()))
                .andExpect(status().isOk());
        verify(weeklyAdherenceService).update(weeklyAdherence);
    }


    @Test
    public void shouldGeneratePatientRegistrationReport() throws Exception {
        standaloneSetup(weeklyAdherenceController)
                .build()
                .perform(get("/weekly/report").param("clinicId", "new").param("patientId", "patientId").param("startDate", "02/01/2013").param("endDate", "02/01/2013"))
                .andExpect(status().isOk())
                .andExpect(content().type("application/vnd.ms-excel"));
    }

}
