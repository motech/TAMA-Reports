package org.motechproject.tama.reports.it;

import org.junit.After;
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
@ContextConfiguration("classpath*:applicationTestContext.xml")
public class TAMAReportingIT {

    @Autowired
    private HttpClientService httpClientService;

    @Autowired
    private AllPatients allPatients;

    @Test
    public void shouldAcceptRequestThroughHttpService() throws InterruptedException, IOException {
        httpClientService.post("http://localhost:9999/tama-reports/patient", PatientRequestBuilder.validRequest());
        Thread.sleep(10000);
        assertEquals(1, allPatients.findAll().size());
    }

    @After
    public void tearDown() {
        allPatients.flush();
        allPatients.deleteAll();
    }
}
