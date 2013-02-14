package org.motechproject.tama.reports.domain.service;


import org.motechproject.tama.reports.contract.PillTimeRequest;
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
        Patient persistedPatient = allPatients.findByPatientDocumentId(patient.getPatientDocumentId());
        persistedPatient.merge(patient);
        allPatients.save(persistedPatient);
    }

    public void updatePillTimes(PillTimeRequest pillTimeRequest) {
        Patient persistedPatient = allPatients.findByPatientDocumentId(pillTimeRequest.getPatientDocumentId());
        persistedPatient.mergePillTimes(pillTimeRequest.getMorningPillTime(), pillTimeRequest.getEveningPillTime());
        allPatients.save(persistedPatient);
    }
}
