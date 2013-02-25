package org.motechproject.tama.reports.web;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.tama.reports.contract.ClinicianContactRequest;
import org.motechproject.tama.reports.contract.ClinicianContactRequests;
import org.motechproject.tama.reports.domain.Clinician;
import org.motechproject.tama.reports.domain.service.ClinicianService;
import org.springframework.http.MediaType;

import static java.util.Arrays.asList;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;

public class ClinicianContactControllerTest extends BaseControllerTest {

    @Mock
    private ClinicianService clinicianService;
    private ClinicianContactController clinicianContactController;

    @Before
    public void setup() {
        initMocks(this);
        clinicianContactController = new ClinicianContactController(clinicianService);
    }

    @Test
    public void shouldCreateClinicianContacts() throws Exception {
        ClinicianContactRequest request = new ClinicianContactRequest();
        request.setId("uniqueId");
        request.setName("balaji");
        request.setPhoneNumber("999999999");

        standaloneSetup(clinicianContactController)
                .build()
                .perform(post("/clinicianContact").contentType(MediaType.APPLICATION_JSON).body(getJSON(new ClinicianContactRequests(asList(request))).getBytes()))
                .andExpect(status().isOk());
        verify(clinicianService).save(anyListOf(Clinician.class));
    }

    @Test
    public void shouldUpdateClinicianContacts() throws Exception {
        ClinicianContactRequest request = new ClinicianContactRequest();
        request.setId("uniqueId");
        request.setName("balaji");
        request.setPhoneNumber("999999999");

        standaloneSetup(clinicianContactController)
                .build()
                .perform(put("/clinicianContact").contentType(MediaType.APPLICATION_JSON).body(getJSON(new ClinicianContactRequests(asList(request))).getBytes()))
                .andExpect(status().isOk());
        verify(clinicianService).update(anyListOf(Clinician.class));
    }
}
