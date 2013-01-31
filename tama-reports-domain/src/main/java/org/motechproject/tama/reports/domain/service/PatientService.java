package org.motechproject.tama.reports.domain.service;


import org.motechproject.tama.reports.domain.Patient;
import org.motechproject.tama.reports.domain.repository.AllPatients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PatientService {

    private AllPatients allPatients;

    PatientService() {
    }

    @Autowired
    public PatientService(AllPatients allPatients) {
        this.allPatients = allPatients;
    }

    public void save(Patient patient) {
        allPatients.save(patient);
    }

    public void update(Patient patient) {
        Patient persistedPatient = allPatients.findByPatientId(patient.getPatientId());
        persistedPatient.merge(patient);
        allPatients.save(persistedPatient);
    }
}
