package org.motechproject.tama.reports.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ClinicianTest {

    private Clinician clinician;
    private Clinician mergedClinician;

    @Before
    public void setup() {
        clinician = new Clinician();
        mergedClinician = new Clinician();
    }

    @Test
    public void shouldMergeContactNumber() {
        clinician.setContactNumber("newContactNumber");

        assertNull(mergedClinician.getContactNumber());
        mergedClinician.merge(clinician);
        assertEquals("newContactNumber", mergedClinician.getContactNumber());
    }

    @Test
    public void shouldMergeAlternateNumber() {
        clinician.setAlternateNumber("newAlternateNumber");

        assertNull(mergedClinician.getAlternateNumber());
        mergedClinician.merge(clinician);
        assertEquals("newAlternateNumber", mergedClinician.getAlternateNumber());
    }

    @Test
    public void shouldMergeClinicianRole() {
        clinician.setRole("newRole");

        assertNull(mergedClinician.getRole());
        mergedClinician.merge(clinician);
        assertEquals("newRole", mergedClinician.getRole());
    }
}
