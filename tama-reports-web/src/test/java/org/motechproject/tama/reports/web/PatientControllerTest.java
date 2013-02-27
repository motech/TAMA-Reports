package org.motechproject.tama.reports.web;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.tama.reports.contract.PatientRequest;
import org.motechproject.tama.reports.contract.PillTimeRequest;
import org.motechproject.tama.reports.domain.export.ReportingService;
import org.motechproject.tama.reports.domain.service.PatientService;
import org.motechproject.tama.reports.mapping.PatientRequestMapper;
import org.springframework.http.MediaType;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;

public class PatientControllerTest extends BaseControllerTest {

    @Mock
    private PatientService patientService;
    @Mock
    private ReportingService reportService;

    private PatientController patientController;

    @Before
    public void setup() {
        initMocks(this);
        patientController = new PatientController(patientService, reportService);
    }

    @Test
    public void shouldCreatePatient() throws Exception {
        PatientRequest request = new PatientRequest();
        request.setPatientId("patientId");

        standaloneSetup(patientController)
                .build()
                .perform(post("/patient").contentType(MediaType.APPLICATION_JSON).body(getJSON(request).getBytes()))
                .andExpect(status().isOk());
        verify(patientService).save(new PatientRequestMapper(request).map());
    }

    @Test
    public void shouldUpdatePatient() throws Exception {
        PatientRequest request = new PatientRequest();
        request.setPatientId("patientId");

        standaloneSetup(patientController)
                .build()
                .perform(put("/patient").contentType(MediaType.APPLICATION_JSON).body(getJSON(request).getBytes()))
                .andExpect(status().isOk());
        verify(patientService).update(new PatientRequestMapper(request).map());
    }

    @Test
    public void shouldUpdatePillTimes() throws Exception {
        PillTimeRequest request = new PillTimeRequest();
        request.setPatientDocumentId("patientDocId");

        standaloneSetup(patientController)
                .build()
                .perform(put("/patient/pillTimes").contentType(MediaType.APPLICATION_JSON).body(getJSON(request).getBytes()))
                .andExpect(status().isOk());
        verify(patientService).updatePillTimes(request);
    }

    @Test
    public void shouldGeneratePatientRegistrationReport() throws Exception {
        standaloneSetup(patientController)
                .build()
                .perform(get("/patient/report").param("clinicId", "new").param("patientId", "patientId").param("startDate", "02/01/2013").param("endDate", "02/01/2013"))
                .andExpect(status().isOk())
                .andExpect(content().type("application/vnd.ms-excel"));
    }
}
