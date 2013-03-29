package org.motechproject.tama.reports.web;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.tama.reports.contract.MessagesRequest;
import org.motechproject.tama.reports.domain.Messages;
import org.motechproject.tama.reports.domain.export.ReportingService;
import org.motechproject.tama.reports.domain.service.MessagesService;
import org.motechproject.tama.reports.web.excel.MessagesParameters;
import org.springframework.http.MediaType;

import java.io.OutputStream;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;

public class MessagesControllerTest extends BaseControllerTest {

    @Mock
    private MessagesService messagesService;
    @Mock
    private ReportingService reportingService;
    private MessagesController messagesController;

    @Before
    public void setup() {
        initMocks(this);
        messagesController = new MessagesController(messagesService, reportingService);
    }

    @Test
    public void shouldSaveMessages() throws Exception {
        MessagesRequest messagesRequest = new MessagesRequest();
        standaloneSetup(messagesController)
                .build()
                .perform(post("/messages").contentType(MediaType.APPLICATION_JSON).body(getJSON(messagesRequest).getBytes()))
                .andExpect(status().isOk());
        verify(messagesService).save(any(Messages.class));
    }

    @Test
    public void shouldReportMessages() throws Exception {
        standaloneSetup(messagesController)
                .build()
                .perform(get("/messages/report").param("patientId", "").param("clinicId", "").param("startDate", "12/11/2013").param("endDate", "12/11/2013"))
                .andExpect(status().isOk());
        verify(reportingService).export(any(MessagesParameters.class), any(OutputStream.class), eq("messages.jasper"));
    }
}
