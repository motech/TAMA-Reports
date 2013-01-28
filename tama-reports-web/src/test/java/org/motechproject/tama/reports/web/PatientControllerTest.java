package org.motechproject.tama.reports.web;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.tama.reports.contract.PatientRequest;
import org.motechproject.tama.reports.domain.service.PatientService;
import org.motechproject.tama.reports.mapping.PatientRequestMapper;
import org.springframework.http.MediaType;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;

public class PatientControllerTest extends BaseControllerTest {

    @Mock
    private PatientService patientService;
    private PatientController patientController;

    @Before
    public void setup() {
        initMocks(this);
        patientController = new PatientController(patientService);
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
                .perform(post("/patient/update").contentType(MediaType.APPLICATION_JSON).body(getJSON(request).getBytes()))
                .andExpect(status().isOk());
        verify(patientService).update(new PatientRequestMapper(request).map());
    }

    @Test
    public void shouldExportPatientDataAsExcel() throws Exception {
        standaloneSetup(patientController)
                .build()
                .perform(get("/patient/report"))
                .andExpect(view().name("patientReport"));
    }
}
