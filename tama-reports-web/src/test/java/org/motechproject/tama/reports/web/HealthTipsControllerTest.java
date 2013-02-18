package org.motechproject.tama.reports.web;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.tama.reports.contract.HealthTipsRequest;
import org.motechproject.tama.reports.domain.HealthTips;
import org.motechproject.tama.reports.domain.service.HealthTipsService;
import org.springframework.http.MediaType;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;

public class HealthTipsControllerTest extends BaseControllerTest {

    @Mock
    private HealthTipsService healthTipsService;
    private HealthTipsController healthTipsController;

    @Before
    public void setup() {
        initMocks(this);
        healthTipsController = new HealthTipsController(healthTipsService);
    }

    @Test
    public void shouldSaveHealthTips() throws Exception {
        HealthTipsRequest healthTipsRequest = new HealthTipsRequest();
        standaloneSetup(healthTipsController)
                .build()
                .perform(post("/healthTips").contentType(MediaType.APPLICATION_JSON).body(getJSON(healthTipsRequest).getBytes()))
                .andExpect(status().isOk());
        verify(healthTipsService).save(any(HealthTips.class));
    }
}
