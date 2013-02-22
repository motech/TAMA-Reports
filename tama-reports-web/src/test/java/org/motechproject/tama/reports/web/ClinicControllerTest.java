package org.motechproject.tama.reports.web;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.tama.reports.contract.ClinicRequest;
import org.motechproject.tama.reports.domain.Clinic;
import org.motechproject.tama.reports.domain.service.ClinicService;
import org.springframework.http.MediaType;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;

public class ClinicControllerTest extends BaseControllerTest {

    @Mock
    private ClinicService clinicService;
    private ClinicController clinicController;

    @Before
    public void setup() {
        initMocks(this);
        clinicController = new ClinicController(clinicService);
    }

    @Test
    public void shouldCreateClinic() throws Exception {
        ClinicRequest request = new ClinicRequest();
        request.setClinicId("clinicId");

        standaloneSetup(clinicController)
                .build()
                .perform(post("/clinic").contentType(MediaType.APPLICATION_JSON).body(getJSON(request).getBytes()))
                .andExpect(status().isOk());
        verify(clinicService).save(any(Clinic.class));
    }

    @Test
    public void shouldUpdateClinic() throws Exception {
        ClinicRequest request = new ClinicRequest();
        request.setClinicId("clinicId");

        standaloneSetup(clinicController)
                .build()
                .perform(put("/clinic").contentType(MediaType.APPLICATION_JSON).body(getJSON(request).getBytes()))
                .andExpect(status().isOk());
        verify(clinicService).update(any(Clinic.class));
    }
}
