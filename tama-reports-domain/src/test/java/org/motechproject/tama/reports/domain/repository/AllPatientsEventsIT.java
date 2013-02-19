package org.motechproject.tama.reports.domain.repository;


import org.junit.Test;
import org.motechproject.tama.reports.domain.PatientEvent;
import org.motechproject.tama.reports.domain.builder.PatientEventBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

public class AllPatientsEventsIT extends AbstractRepositoryTest {

    @Autowired
    private AllPatientsEvents allEvents;

    @Test
    @Transactional
    public void shouldSavePatientEvent() {
        PatientEvent event = PatientEventBuilder.validEvent();
        allEvents.save(event);
        assertNotNull(allEvents.findAll().get(0));
    }

    @Override
    protected JpaRepository getRepository() {
        return allEvents;
    }
}
