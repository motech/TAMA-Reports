package org.motechproject.tama.reports.domain.repository;


import org.junit.After;
import org.junit.Test;
import org.motechproject.tama.reports.domain.medicalhistory.GeneralHistory;
import org.motechproject.tama.reports.domain.medicalhistory.MedicalHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.Assert.*;

public class AllMedicalHistoriesIT extends AbstractRepositoryTest {

    @Autowired
    private AllMedicalHistories allMedicalHistories;

    @Test
    @Transactional
    public void shouldSaveMedicalHistory() {
        MedicalHistory medicalHistory = new MedicalHistory();
        medicalHistory.setPatientId("patientId");

        GeneralHistory allergy = new GeneralHistory();
        allergy.setHistoryOfDrugAllergy("history");
        medicalHistory.setGeneralHistory(allergy);

        /*Verify persistence of history*/
        assertNull(medicalHistory.getId());
        allMedicalHistories.saveAndFlush(medicalHistory);
        assertNotNull(medicalHistory.getId());

        /*Verify persistence of embedded object*/
        MedicalHistory persistedHistory = allMedicalHistories.findOne(medicalHistory.getId());
        assertEquals("history", persistedHistory.getGeneralHistory().getHistoryOfDrugAllergy());
    }

    @Override
    protected JpaRepository getRepository() {
        return allMedicalHistories;
    }

    @After
    public void tearDown() {
        allMedicalHistories.flush();
        allMedicalHistories.deleteAll();
    }
}
