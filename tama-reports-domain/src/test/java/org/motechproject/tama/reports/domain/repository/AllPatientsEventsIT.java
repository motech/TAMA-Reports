package org.motechproject.tama.reports.domain.repository;


import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.motechproject.tama.reports.domain.PatientEvent;
import org.motechproject.tama.reports.domain.builder.PatientEventBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationPersistenceContext.xml")
public class AllPatientsEventsIT {

    @Autowired
    private AllPatientsEvents allEvents;

    @Test
    @Transactional
    public void shouldSavePatientEvent() {
        PatientEvent event = PatientEventBuilder.validEvent();
        allEvents.save(event);
        assertNotNull(allEvents.findAll().get(0));
    }

    @After
    public void tearDown() {
        allEvents.flush();
        allEvents.deleteAll();
    }
}
