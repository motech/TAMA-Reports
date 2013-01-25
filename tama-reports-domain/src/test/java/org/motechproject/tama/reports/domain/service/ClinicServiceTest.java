package org.motechproject.tama.reports.domain.service;


import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.motechproject.tama.reports.domain.Clinic;
import org.motechproject.tama.reports.domain.builder.ClinicBuilder;
import org.motechproject.tama.reports.domain.repository.AllClinics;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ClinicServiceTest {

    @Mock
    private AllClinics allClinics;
    private ClinicService clinicService;

    @Before
    public void setup() {
        initMocks(this);
        clinicService = new ClinicService(allClinics);
    }

    @Test
    public void shouldSaveClinic() {
        Clinic clinic = new Clinic();
        clinicService.save(clinic);
        verify(allClinics).save(clinic);
    }

    @Test
    public void shouldUpdateClinic() {
        Clinic detachedClinic = ClinicBuilder.validClinic();
        detachedClinic.setClinicName("updatedClinicName");

        Clinic persistedClinic = ClinicBuilder.validClinic();
        persistedClinic.setId(10l);

        when(allClinics.findByClinicId(detachedClinic.getClinicId())).thenReturn(persistedClinic);
        clinicService.update(detachedClinic);

        Clinic merged = mergedClinic();
        assertEquals(detachedClinic.getClinicName(), merged.getClinicName());
        assertEquals(persistedClinic.getId(), merged.getId());
    }

    private Clinic mergedClinic() {
        ArgumentCaptor<Clinic> clinicCaptor = ArgumentCaptor.forClass(Clinic.class);
        verify(allClinics).save(clinicCaptor.capture());
        return clinicCaptor.getValue();
    }
}
