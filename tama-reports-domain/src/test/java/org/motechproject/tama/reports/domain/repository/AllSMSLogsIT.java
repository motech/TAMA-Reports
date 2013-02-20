package org.motechproject.tama.reports.domain.repository;

import org.junit.Test;
import org.motechproject.tama.reports.domain.SMSLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import static junit.framework.Assert.assertNotNull;

public class AllSMSLogsIT extends AbstractRepositoryTest {

    @Autowired
    AllSMSLogs allSMSLogs;

    @Test
    public void shouldSaveSMSLog() {
        SMSLog log = new SMSLog();
        allSMSLogs.save(log);
        assertNotNull(log.getId());
    }

    @Override
    protected JpaRepository getRepository() {
        return allSMSLogs;
    }
}
