package org.motechproject.tama.reports.mapping;

import org.junit.Before;
import org.junit.Test;
import org.motechproject.tama.reports.contract.PatientEventRequest;
import org.motechproject.util.DateUtil;

import java.util.Date;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

public class PatientEventMapperTest {

    private PatientEventRequest request;
    private PatientEventRequestMapper mapper;

    @Before
    public void setup() {
        request = new PatientEventRequest();
        mapper = new PatientEventRequestMapper(request);
    }

    @Test
    public void shouldMapPatientDocumentId() {
        assertNull(mapper.map().getPatientDocumentId());
        request.setPatientDocumentId("patientDocumentId");
        assertEquals("patientDocumentId", mapper.map().getPatientDocumentId());
    }

    @Test
    public void shouldMapEventName() {
        assertNull(mapper.map().getEventName());
        request.setEventName("eventName");
        assertEquals("eventName", mapper.map().getEventName());
    }

    @Test
    public void shouldMapDateTime() {
        assertNull(mapper.map().getDateTime());
        Date now = DateUtil.now().toDate();
        request.setDateTime(now);
        assertEquals(now, mapper.map().getDateTime());
    }

    @Test
    public void shouldMapPerformedBy() {
        assertNull(mapper.map().getPerformedBy());
        request.setPerformedBy("performer");
        assertEquals("performer", mapper.map().getPerformedBy());
    }


}
