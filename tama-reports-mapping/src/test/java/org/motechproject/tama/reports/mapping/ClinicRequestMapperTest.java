package org.motechproject.tama.reports.mapping;


import org.junit.Before;
import org.junit.Test;
import org.motechproject.tama.reports.contract.ClinicRequest;
import org.motechproject.tama.reports.domain.Clinic;

import static org.junit.Assert.assertEquals;

public class ClinicRequestMapperTest {

    private ClinicRequest clinicRequest;
    private RequestMapper<ClinicRequest, Clinic> requestMapper;

    @Before
    public void setup() {
        initializeClinicRequest();
        requestMapper = new RequestMapper<>();
    }

    private void initializeClinicRequest() {
        clinicRequest = new ClinicRequest();
        clinicRequest.setClinicId("clinicId");
        clinicRequest.setClinicName("clinicName");
        clinicRequest.setCityName("cityName");
    }

    @Test
    public void shouldMapClinicId() {
        Clinic clinic = requestMapper.map(clinicRequest, Clinic.class);
        assertEquals(clinicRequest.getClinicId(), clinic.getClinicId());
    }

    @Test
    public void shouldMapClinicName() {
        Clinic clinic = requestMapper.map(clinicRequest, Clinic.class);
        assertEquals(clinicRequest.getClinicName(), clinic.getClinicName());
    }

    @Test
    public void shouldMapCityName() {
        Clinic clinic = requestMapper.map(clinicRequest, Clinic.class);
        assertEquals(clinicRequest.getCityName(), clinic.getCityName());
    }

}
