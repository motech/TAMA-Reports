package org.motechproject.tama.reports.it;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.motechproject.http.client.service.HttpClientService;
import org.motechproject.tama.reports.contract.builder.PatientRequestBuilder;
import org.motechproject.tama.reports.domain.repository.AllPatients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/spring/applicationContext.xml")
public class TempIT {

    @Autowired
    private HttpClientService httpClientService;

    @Autowired
    private AllPatients patientService;

    @Test
    public void shouldAcceptRequestThroughHttpService() throws InterruptedException, IOException {
        httpClientService.post("http://localhost:9999/tama-reports/patient", PatientRequestBuilder.validRequest());
        Thread.sleep(10000);
        assertEquals(1, patientService.findAll().size());
    }
}
