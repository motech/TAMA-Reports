package org.motechproject.tama.reports.web;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.tama.reports.contract.ClinicianRequest;
import org.motechproject.tama.reports.domain.service.ClinicianService;
import org.motechproject.tama.reports.mapping.ClinicianRequestMapper;
import org.springframework.http.MediaType;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;

public class ClinicianControllerTest extends BaseControllerTest {

    @Mock
    private ClinicianService clinicianService;
    private ClinicianController clinicianController;

    @Before
    public void setup() {
        initMocks(this);
        clinicianController = new ClinicianController(clinicianService);
    }

    @Test
    public void shouldCreateClinician() throws Exception {
        ClinicianRequest request = new ClinicianRequest();
        request.setClinicId("clinicId");

        standaloneSetup(clinicianController)
                .build()
                .perform(post("/clinician").contentType(MediaType.APPLICATION_JSON).body(getJSON(request).getBytes()))
                .andExpect(status().isOk());
        verify(clinicianService).save(new ClinicianRequestMapper(request).map());
    }

    @Test
    public void shouldUpdateClinic() throws Exception {
        ClinicianRequest request = new ClinicianRequest();
        request.setClinicId("clinicId");

        standaloneSetup(clinicianController)
                .build()
                .perform(post("/clinician/update").contentType(MediaType.APPLICATION_JSON).body(getJSON(request).getBytes()))
                .andExpect(status().isOk());
        verify(clinicianService).update(new ClinicianRequestMapper(request).map());
    }
}
