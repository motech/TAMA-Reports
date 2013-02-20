package org.motechproject.tama.reports.mapping;

import org.junit.Before;
import org.junit.Test;
import org.motechproject.tama.reports.contract.SMSLogRequest;
import org.motechproject.tama.reports.domain.SMSLog;
import org.motechproject.util.DateUtil;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;

public class SMSLogMapperTest {

    private SMSLogRequest request;
    private SMSLog log;

    @Before
    public void setup() {
        request = new SMSLogRequest();
        request.setExternalId("externalId");
        request.setContent("content");
        request.setReceiverType("recipientType");
        request.setRecipientNumber("1234567890");
        request.setTimeStamp(DateUtil.now().toDate());
        log = new SMSLog();
    }

    @Test
    public void shouldMapExternalId() {
        assertNull(log.getExternalId());
        log = new SMSLogMapper(request).map();
        assertEquals(request.getExternalId(), log.getExternalId());
    }

    @Test
    public void shouldMapContent() {
        assertNull(log.getContent());
        log = new SMSLogMapper(request).map();
        assertEquals(request.getContent(), log.getContent());
    }

    @Test
    public void shouldMapRecipientType() {
        assertNull(log.getReceiverType());
        log = new SMSLogMapper(request).map();
        assertEquals(request.getReceiverType(), log.getReceiverType());
    }

    @Test
    public void shouldMapRecipientNumber() {
        assertNull(log.getRecipientNumber());
        log = new SMSLogMapper(request).map();
        assertEquals(request.getRecipientNumber(), log.getRecipientNumber());
    }

    @Test
    public void shouldMapTimeStamp() {
        assertNull(log.getRecipientNumber());
        log = new SMSLogMapper(request).map();
        assertEquals(request.getTimeStamp(), log.getTimeStamp());
    }
}
