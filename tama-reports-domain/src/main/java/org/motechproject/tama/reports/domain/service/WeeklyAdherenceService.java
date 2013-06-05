package org.motechproject.tama.reports.domain.service;

import org.motechproject.tama.reports.domain.WeeklyAdherence;
import org.motechproject.tama.reports.domain.repository.AllWeeklyAdherence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class WeeklyAdherenceService {

    private AllWeeklyAdherence allWeeklyAdherence;


    @Autowired
    public WeeklyAdherenceService(AllWeeklyAdherence allWeeklyAdherence) {
        this.allWeeklyAdherence = allWeeklyAdherence;
    }

    public void save(WeeklyAdherence weeklyAdherence) {
        allWeeklyAdherence.save(weeklyAdherence);
    }

    public void update(WeeklyAdherence weeklyAdherence) {
        WeeklyAdherence persistedWeeklyAdherence = new WeeklyAdherence();
        //TODO REMOVE commented code
        //allWeeklyAdherence.findByAdherenceByPatientIdAndDate(weeklyAdherence.getPatientDocumentId(), weeklyAdherence.getWeekStartDate().toString());
        //new WeeklyAdherence();

        //allWeeklyAdherence.findSimilarWeeklyLog(weeklyAdherence.getPatientDocumentId());
        //, weeklyAdherence.getClinicName(), weeklyAdherence.getTreatmentAdviceId(), weeklyAdherence.getWeekStartDate().toString());
        persistedWeeklyAdherence.merge(weeklyAdherence);
        allWeeklyAdherence.save(persistedWeeklyAdherence);
    }


}
