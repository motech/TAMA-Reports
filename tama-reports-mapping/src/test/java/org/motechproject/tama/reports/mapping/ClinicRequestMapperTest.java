package org.motechproject.tama.reports.mapping;


import org.junit.Before;
import org.junit.Test;
import org.motechproject.tama.reports.contract.ClinicRequest;
import org.motechproject.tama.reports.domain.Clinic;

import static org.junit.Assert.assertEquals;

public class ClinicRequestMapperTest {

    private ClinicRequest clinicRequest;

    @Before
    public void setup() {
        clinicRequest = new ClinicRequest();
        clinicRequest.setClinicId("clinicId");
        clinicRequest.setClinicName("clinicName");
        clinicRequest.setCityName("cityName");
    }

    @Test
    public void shouldMapClinicId() {
        Clinic clinic = new ClinicRequestMapper(clinicRequest).map();
        assertEquals(clinicRequest.getClinicId(), clinic.getClinicId());
    }

    @Test
    public void shouldMapClinicName() {
        Clinic clinic = new ClinicRequestMapper(clinicRequest).map();
        assertEquals(clinicRequest.getClinicName(), clinic.getClinicName());
    }

    @Test
    public void shouldMapCityName() {
        Clinic clinic = new ClinicRequestMapper(clinicRequest).map();
        assertEquals(clinicRequest.getCityName(), clinic.getCityName());
    }

}
