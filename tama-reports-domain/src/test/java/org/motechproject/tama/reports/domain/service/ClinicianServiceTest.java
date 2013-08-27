package org.motechproject.tama.reports.domain.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.motechproject.tama.reports.domain.Clinician;
import org.motechproject.tama.reports.domain.builder.ClinicianBuilder;
import org.motechproject.tama.reports.domain.repository.AllClinicians;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
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
        Clinician clinician = new ClinicianBuilder().build();
        clinicianService.save(clinician);
        verify(allClinicians).save(clinician);
    }

    @Test
    public void shouldSaveAllClinicians() {
        List<Clinician> clinicians = asList(
                new ClinicianBuilder().build(),
                new ClinicianBuilder().build()
        );
        clinicianService.save(clinicians);
        verify(allClinicians).save(clinicians);
    }

    @Test
    public void shouldUpdateClinician() {
        Clinician oldClinician = new ClinicianBuilder().build();
        Clinician newClinician = new ClinicianBuilder().withContactNumber("contactNumber").withAlternateNumber("alternateNumber").withRole("role").build();

        when(allClinicians.findByClinicianId(oldClinician.getClinicianId())).thenReturn(oldClinician);
        clinicianService.update(oldClinician);

        oldClinician.merge(newClinician);
        verify(allClinicians).save(oldClinician);
    }

    @Test
    public void shouldBeIdempotentOnUpdate() {
        List<Clinician> oldClinicians = asList(new ClinicianBuilder().withContactNumber("contactNumber").withAlternateNumber("alternateNumber").withRole("role").build());
        oldClinicians.get(0).setClinicId("clinicId");
        oldClinicians.get(0).setType("CC");
        List<Clinician> newClinician = asList(new ClinicianBuilder().withId(oldClinicians.get(0).getClinicianId()).withContactNumber("contactNumber").withAlternateNumber("alternateNumber").withRole("role").build());
        newClinician.get(0).setType("CC");
        when(allClinicians.findByClinicId(newClinician.get(0).getClinicId())).thenReturn(oldClinicians);
        List<Clinician> clinicians = new ArrayList<>();
        clinicians.addAll(oldClinicians);
        clinicians.addAll(newClinician);
        when(allClinicians.findByClinicianId(oldClinicians.get(0).getClinicianId())).thenReturn(oldClinicians.get(0));
        clinicianService.update(newClinician);
        verify(allClinicians).deleteInBatch(oldClinicians);
        verify(allClinicians).save(newClinician);
    }
}
