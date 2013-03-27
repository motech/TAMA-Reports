package org.motechproject.tama.reports.mapping;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.motechproject.tama.reports.contract.PatientEventRequest;
import org.motechproject.tama.reports.domain.PatientEvent;

import static org.junit.Assert.assertEquals;

public class PatientEventRequestMapperTest {

    private PatientEventRequest request;
    private PatientEventRequestMapper patientEventRequestMapper;

    @Before
    public void setup() {
        initializeRequest();
        patientEventRequestMapper = new PatientEventRequestMapper(request);
    }

    private void initializeRequest() {
        request = new PatientEventRequest();
        request.setEventName("eventName");
        request.setNewValue("value");
        request.setPerformedBy("user");
        request.setPatientDocumentId("patientDocId");
        request.setDateTime(DateTime.now().toDate());
    }

    @Test
    public void shouldMapPatientDocumentId() {
        PatientEvent event = patientEventRequestMapper.map();
        assertEquals(request.getPatientDocumentId(), event.getPatientDocumentId());
    }

    @Test
    public void shouldMapPerformedBy() {
        PatientEvent event = patientEventRequestMapper.map();
        assertEquals(request.getPerformedBy(), event.getPerformedBy());

        request.setPerformedBy("");
        event = patientEventRequestMapper.map();
        assertEquals("", event.getPerformedBy());
    }

    @Test
    public void shouldMapDateTime() {
        PatientEvent event = patientEventRequestMapper.map();
        assertEquals(request.getDateTime(), event.getDateTime());
    }

    @Test
    public void shouldMapPatientEventName() {
        PatientEvent event = patientEventRequestMapper.map();
        assertEquals(request.getEventName(), event.getEventName());

        request.setEventName(null);
        event = patientEventRequestMapper.map();
        assertEquals("", event.getEventName());
    }

    @Test
    public void shouldMapNewValue() {
        PatientEvent event = patientEventRequestMapper.map();
        assertEquals(request.getNewValue(), event.getNewValue());

        request.setNewValue(null);
        event = patientEventRequestMapper.map();
        assertEquals("", event.getNewValue());
    }
}
