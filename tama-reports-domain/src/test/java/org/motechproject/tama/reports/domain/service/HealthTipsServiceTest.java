package org.motechproject.tama.reports.domain.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.tama.reports.domain.HealthTips;
import org.motechproject.tama.reports.domain.repository.AllHealthTips;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class HealthTipsServiceTest {

    @Mock
    private AllHealthTips allHealthTips;
    private HealthTipsService healthTipsService;

    @Before
    public void setup() {
        initMocks(this);
        healthTipsService = new HealthTipsService(allHealthTips);
    }

    @Test
    public void shouldSaveHealthTips() {
        HealthTips healthTips = new HealthTips();

        healthTipsService.save(healthTips);
        verify(allHealthTips).save(healthTips);
    }
}
