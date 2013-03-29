package org.motechproject.tama.reports.domain.service;

import org.motechproject.tama.reports.domain.Messages;
import org.motechproject.tama.reports.domain.repository.AllMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagesService {

    private AllMessages allMessages;

    @Autowired
    public MessagesService(AllMessages allMessages) {
        this.allMessages = allMessages;
    }

    public void save(Messages messages) {
        allMessages.save(messages);
    }
}
