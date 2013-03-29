package org.motechproject.tama.reports.domain.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.tama.reports.domain.Messages;
import org.motechproject.tama.reports.domain.repository.AllMessages;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class MessagesServiceTest {

    @Mock
    private AllMessages allMessages;
    private MessagesService messagesService;

    @Before
    public void setup() {
        initMocks(this);
        messagesService = new MessagesService(allMessages);
    }

    @Test
    public void shouldSaveMessages() {
        Messages messages = new Messages();

        messagesService.save(messages);
        verify(allMessages).save(messages);
    }
}
