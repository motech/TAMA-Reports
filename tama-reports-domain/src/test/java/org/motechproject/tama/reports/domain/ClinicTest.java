package org.motechproject.tama.reports.domain;


import org.junit.Before;
import org.junit.Test;
import org.motechproject.tama.reports.domain.builder.ClinicBuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class ClinicTest {

    private Clinic clinic;
    private Clinic mergedClinic;

    @Before
    public void setUp() throws Exception {
        clinic = ClinicBuilder.validClinic();
        mergedClinic = new Clinic();
    }

    @Test
    public void shouldMergeClinicName() {
        assertNull(mergedClinic.getClinicName());
        mergedClinic.merge(clinic);
        assertEquals(clinic.getClinicName(), mergedClinic.getClinicName());
    }

    @Test
    public void shouldMergeCityName() {
        assertNull(mergedClinic.getCityName());
        mergedClinic.merge(clinic);
        assertEquals(clinic.getCityName(), mergedClinic.getCityName());
    }

    @Test
    public void shouldMergeGreeting() {
        assertNull(mergedClinic.getGreetingName());
        mergedClinic.merge(clinic);
        assertEquals(clinic.getGreetingName(), mergedClinic.getGreetingName());
    }

    @Test
    public void shouldMergeAddress() {
        assertNull(mergedClinic.getAddress());
        mergedClinic.merge(clinic);
        assertEquals(clinic.getAddress(), mergedClinic.getAddress());
    }

    @Test
    public void shouldMergeContactNumber() {
        assertNull(mergedClinic.getContactNumber());
        mergedClinic.merge(clinic);
        assertEquals(clinic.getContactNumber(), mergedClinic.getContactNumber());
    }
}
