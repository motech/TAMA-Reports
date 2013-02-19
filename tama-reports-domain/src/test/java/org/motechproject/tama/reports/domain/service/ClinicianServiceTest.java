package org.motechproject.tama.reports.domain.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.tama.reports.domain.Clinician;
import org.motechproject.tama.reports.domain.builder.ClinicianBuilder;
import org.motechproject.tama.reports.domain.repository.AllClinicians;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ClinicianServiceTest {

    @Mock
    private AllClinicians allClinicians;

    private ClinicianService clinicianService;

    @Before
    public void setup() {
        initMocks(this);
        clinicianService = new ClinicianService(allClinicians);
    }

    @Test
    public void shouldSaveClinician() {
        Clinician clinician = ClinicianBuilder.validClinician();
        clinicianService.save(clinician);
        verify(allClinicians).save(clinician);
    }

    @Test
    public void shouldUpdateClinician() {
        Clinician oldClinician = ClinicianBuilder.validClinician();
        Clinician newClinician = ClinicianBuilder.validClinician();
        newClinician.setContactNumber("contactNumber");
        newClinician.setAlternateNumber("alternateNumber");
        newClinician.setRole("role");

        when(allClinicians.findByClinicianId(oldClinician.getClinicianId())).thenReturn(oldClinician);
        clinicianService.update(oldClinician);

        oldClinician.merge(newClinician);
        verify(allClinicians).save(oldClinician);
    }
}
