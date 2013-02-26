package org.motechproject.tama.reports.mapping;

import org.junit.Test;
import org.motechproject.tama.reports.contract.PatientRequest;
import org.motechproject.util.DateUtil;

import java.sql.Time;
import java.util.Date;

import static junit.framework.Assert.*;
import static org.motechproject.tama.reports.contract.builder.PatientRequestBuilder.validRequest;


public class PatientRequestMapperTest {

    @Test
    public void shouldMapPatientId() {
        PatientRequest request = new PatientRequest();
        PatientRequestMapper mapper = new PatientRequestMapper(request);
        assertNull(mapper.map().getPatientId());

        request.setPatientId("patientId");
        assertEquals("patientId", mapper.map().getPatientId());
    }

    @Test
    public void shouldMapPatientDocumentId() {
        PatientRequest request = new PatientRequest();
        PatientRequestMapper mapper = new PatientRequestMapper(request);
        assertNull(mapper.map().getPatientDocumentId());

        request.setPatientDocumentId("patientDocumentId");
        assertEquals("patientDocumentId", mapper.map().getPatientDocumentId());
    }

    @Test
    public void shouldMapDateOfBirth() {
        PatientRequest request = new PatientRequest();
        PatientRequestMapper mapper = new PatientRequestMapper(request);
        assertNull(mapper.map().getDateOfBirth());

        Date dateOfBirth = DateUtil.today().toDate();
        request.setDateOfBirth(dateOfBirth);
        assertEquals(dateOfBirth, mapper.map().getDateOfBirth());
    }

    @Test
    public void shouldMapGender() {
        PatientRequest request = new PatientRequest();
        PatientRequestMapper mapper = new PatientRequestMapper(request);
        assertNull(mapper.map().getGender());

        request.setGender("male");
        assertEquals("male", mapper.map().getGender());
    }

    @Test
    public void shouldMapClinic() {
        PatientRequest request = new PatientRequest();
        PatientRequestMapper mapper = new PatientRequestMapper(request);
        assertNull(mapper.map().getClinicId());

        request.setClinicId("clinicId");
        assertEquals("clinicId", mapper.map().getClinicId());
    }

    @Test
    public void shouldMapTravelTimeToClinic() {
        PatientRequest request = new PatientRequest();
        PatientRequestMapper mapper = new PatientRequestMapper(request);
        assertNull(mapper.map().getTravelTimeToClinic());

        request.setTravelTimeToClinic("30");
        assertEquals("30", mapper.map().getTravelTimeToClinic());
    }

    @Test
    public void shouldMapIVRPassCode() {
        PatientRequest request = new PatientRequest();
        PatientRequestMapper mapper = new PatientRequestMapper(request);
        assertNull(mapper.map().getIvrPassCode());

        request.setIvrPassCode("ivrCode");
        assertEquals("ivrCode", mapper.map().getIvrPassCode());
    }

    @Test
    public void shouldMapIVRLanguage() {
        PatientRequest request = new PatientRequest();
        PatientRequestMapper mapper = new PatientRequestMapper(request);
        assertNull(mapper.map().getIvrLanguage());

        request.setIvrLanguage("hindi");
        assertEquals("hindi", mapper.map().getIvrLanguage());
    }

    @Test
    public void shouldMapCallPreference() {
        PatientRequest request = new PatientRequest();
        PatientRequestMapper mapper = new PatientRequestMapper(request);
        assertNull(mapper.map().getCallPreference());

        request.setCallPreference("DPR");
        assertEquals("DPR", mapper.map().getCallPreference());
    }

    @Test
    public void shouldMapBestCallTime() {
        PatientRequest request = new PatientRequest();
        PatientRequestMapper mapper = new PatientRequestMapper(request);
        assertNull(mapper.map().getBestCallTime());

        request.setBestCallTime("10:10:00");
        assertEquals(Time.valueOf("10:10:00"), mapper.map().getBestCallTime());
    }

    @Test
    public void shouldMapDayOfWeeklyCall() {
        PatientRequest request = new PatientRequest();
        PatientRequestMapper mapper = new PatientRequestMapper(request);
        assertNull(mapper.map().getDayOfWeeklyCall());

        request.setDayOfWeeklyCall("Monday");
        assertEquals("Monday", mapper.map().getDayOfWeeklyCall());
    }

    @Test
    public void shouldMapReceiveOTCAdvice() {
        PatientRequest request = new PatientRequest();
        PatientRequestMapper mapper = new PatientRequestMapper(request);
        assertNull(mapper.map().getReceiveOTCAdvice());

        request.setReceiveOTCAdvice(true);
        assertTrue(mapper.map().getReceiveOTCAdvice());
    }

    @Test
    public void shouldMapReceiveAppointmentReminder() {
        PatientRequest request = new PatientRequest();
        PatientRequestMapper mapper = new PatientRequestMapper(request);
        assertNull(mapper.map().getReceiveAppointmentReminder());

        request.setReceiveAppointmentReminder(true);
        assertTrue(mapper.map().getReceiveAppointmentReminder());
    }

    @Test
    public void shouldMapRegisteredOn() {
        PatientRequest request = new PatientRequest();
        PatientRequestMapper mapper = new PatientRequestMapper(request);
        assertNull(mapper.map().getRegisteredOn());
        Date registeredOn = DateUtil.now().toDate();

        request.setRegisteredOn(registeredOn);
        assertEquals(registeredOn, mapper.map().getRegisteredOn());
    }

    @Test
    public void shouldMapStatus() {
        PatientRequest request = new PatientRequest();
        PatientRequestMapper mapper = new PatientRequestMapper(request);
        assertNull(mapper.map().getStatus());

        request.setStatus("status");
        assertEquals("status", mapper.map().getStatus());
    }

    @Test
    public void shouldMapNotes() {
        PatientRequest request = new PatientRequest();
        PatientRequestMapper mapper = new PatientRequestMapper(request);
        assertNull(mapper.map().getNotes());

        request.setNotes("notes");
        assertEquals("notes", mapper.map().getNotes());
    }

    @Test
    public void shouldCreateValidPatientObject() {
        PatientRequest request = validRequest();
        assertTrue(new PatientRequestMapper(request).map().isValid());
    }
}
