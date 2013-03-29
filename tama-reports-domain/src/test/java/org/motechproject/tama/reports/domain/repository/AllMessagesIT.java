package org.motechproject.tama.reports.domain.repository;

import org.junit.Test;
import org.motechproject.tama.reports.domain.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import static junit.framework.Assert.assertNotNull;

public class AllMessagesIT extends AbstractRepositoryTest {

    @Autowired
    private AllMessages allMessages;

    @Test
    public void shouldSaveMessages() {
        Messages messages = new Messages();
        allMessages.save(messages);
        assertNotNull(messages.getId());
    }

    @Override
    protected JpaRepository getRepository() {
        return allMessages;
    }
}
