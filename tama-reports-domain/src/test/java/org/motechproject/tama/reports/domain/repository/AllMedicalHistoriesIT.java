package org.motechproject.tama.reports.domain.repository;


import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.motechproject.tama.reports.domain.medicalhistory.GeneralHistory;
import org.motechproject.tama.reports.domain.medicalhistory.MedicalHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.Assert.*;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationPersistenceContext.xml")
public class AllMedicalHistoriesIT {

    @Autowired
    private AllMedicalHistories allMedicalHistories;

    @Test
    @Transactional
    public void shouldSaveClinic() {
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

    @After
    public void tearDown() {
        allMedicalHistories.flush();
        allMedicalHistories.deleteAll();
    }
}
