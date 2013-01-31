package org.motechproject.tama.reports.domain.service;


import org.motechproject.tama.reports.domain.PatientEvent;
import org.motechproject.tama.reports.domain.repository.AllPatientsEvents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PatientEventService {

    private AllPatientsEvents allPatientEvents;

    PatientEventService() {
    }

    @Autowired
    public PatientEventService(AllPatientsEvents allPatientEvents) {
        this.allPatientEvents = allPatientEvents;
    }

    public void save(PatientEvent event) {
        allPatientEvents.save(event);
    }
}
