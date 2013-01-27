package org.motechproject.tama.reports.domain.service;


import org.motechproject.tama.reports.domain.medicalhistory.MedicalHistory;
import org.motechproject.tama.reports.domain.repository.AllMedicalHistories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MedicalHistoryService {

    private AllMedicalHistories allMedicalHistories;

    MedicalHistoryService() {
    }

    @Autowired
    public MedicalHistoryService(AllMedicalHistories allMedicalHistories) {
        this.allMedicalHistories = allMedicalHistories;
    }

    public void save(MedicalHistory medicalHistory) {
        allMedicalHistories.save(medicalHistory);
    }
}
