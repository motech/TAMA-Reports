package org.motechproject.tama.reports.mapping;

import org.junit.Before;
import org.junit.Test;
import org.motechproject.tama.reports.contract.ClinicianRequest;
import org.motechproject.tama.reports.domain.Clinician;

import static org.junit.Assert.assertEquals;

public class ClinicianRequestMapperTest {

    private ClinicianRequestMapper clinicianRequestMapper;
    private ClinicianRequest clinicianRequest;

    @Before
    public void setup() {
        clinicianRequest = new ClinicianRequest();
        clinicianRequest.setClinicianId("clinicianId");
        clinicianRequest.setClinicId("clinicId");
        clinicianRequest.setContactNumber("contactNumber");
        clinicianRequest.setAlternateNumber("alternateNumber");
        clinicianRequest.setRole("role");
        clinicianRequestMapper = new ClinicianRequestMapper(clinicianRequest);
    }

    @Test
    public void shouldMapClinicianId() {
        Clinician clinician = clinicianRequestMapper.map();
        assertEquals(clinicianRequest.getClinicianId(), clinician.getClinicianId());
    }

    @Test
    public void shouldMapClinicId() {
        Clinician clinician = clinicianRequestMapper.map();
        assertEquals(clinicianRequest.getClinicId(), clinician.getClinicId());
    }

    @Test
    public void shouldMapContactNumber() {
        Clinician clinician = clinicianRequestMapper.map();
        assertEquals(clinicianRequest.getContactNumber(), clinician.getContactNumber());
    }

    @Test
    public void shouldMapAlternateNumber() {
        Clinician clinician = clinicianRequestMapper.map();
        assertEquals(clinicianRequest.getAlternateNumber(), clinician.getAlternateNumber());
    }

    @Test
    public void shouldMapRole() {
        Clinician clinician = clinicianRequestMapper.map();
        assertEquals(clinicianRequest.getRole(), clinician.getRole());
    }
}
