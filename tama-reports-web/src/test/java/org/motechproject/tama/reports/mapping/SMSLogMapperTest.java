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
    private RequestMapper<SMSLogRequest, SMSLog> requestMapper;

    @Before
    public void setup() {
        initializeRequest();
        initializeLog();
        requestMapper = new RequestMapper<>();
    }

    private void initializeLog() {
        log = new SMSLog();
    }

    private void initializeRequest() {
        request = new SMSLogRequest();
        request.setExternalId("externalId");
        request.setContent("content");
        request.setSmsType("smsType");
        request.setRecipientNumber("1234567890");
        request.setTimeStamp(DateUtil.now().toDate());
    }

    @Test
    public void shouldMapExternalId() {
        assertNull(log.getExternalId());
        log = requestMapper.map(request, SMSLog.class);
        assertEquals(request.getExternalId(), log.getExternalId());
    }

    @Test
    public void shouldMapContent() {
        assertNull(log.getContent());
        log = requestMapper.map(request, SMSLog.class);
        assertEquals(request.getContent(), log.getContent());
    }

    @Test
    public void shouldMapSmsType() {
        assertNull(log.getSmsType());
        log = requestMapper.map(request, SMSLog.class);
        assertEquals(request.getSmsType(), log.getSmsType());
    }

    @Test
    public void shouldMapRecipientNumber() {
        assertNull(log.getRecipientNumber());
        log = requestMapper.map(request, SMSLog.class);
        assertEquals(request.getRecipientNumber(), log.getRecipientNumber());
    }

    @Test
    public void shouldMapTimeStamp() {
        assertNull(log.getRecipientNumber());
        log = requestMapper.map(request, SMSLog.class);
        assertEquals(request.getTimeStamp(), log.getTimeStamp());
    }
}
