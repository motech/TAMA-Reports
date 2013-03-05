package org.motechproject.tama.reports.domain;

import org.junit.Test;

import java.sql.Time;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

public class PatientTest {

    @Test
    public void shouldNotUpdatePillTimeOnNull() {
        Patient patient = new Patient();
        patient.mergePillTimes(null, null);

        assertNull(patient.getMorningPillTime());
        assertNull(patient.getEveningPillTime());
    }

    @Test
    public void shouldNotUpdatePillTimeOnEmptyString() {
        Patient patient = new Patient();
        patient.mergePillTimes("", "");

        assertNull(patient.getMorningPillTime());
        assertNull(patient.getEveningPillTime());
    }

    @Test
    public void shouldUpdatePillTimeOnValidTime() {
        Patient patient = new Patient();
        patient.mergePillTimes("10:10:10", "14:10:10");
        assertEquals(Time.valueOf("10:10:10"), patient.getMorningPillTime());
        assertEquals(Time.valueOf("14:10:10"), patient.getEveningPillTime());
    }

    @Test
    public void shouldSetPillTimesToEmptyWhenUpdatedWithEmptyValues() {
        Patient patient = new Patient();

        /*Merge with non empty values*/
        patient.mergePillTimes("10:10:10", "14:10:10");
        /* And merge with empty value*/
        patient.mergePillTimes(null, null);

        assertNull(patient.getMorningPillTime());
        assertNull(patient.getEveningPillTime());
    }
}
