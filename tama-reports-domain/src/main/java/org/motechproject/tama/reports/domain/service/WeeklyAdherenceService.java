package org.motechproject.tama.reports.domain.service;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.motechproject.tama.reports.domain.WeeklyAdherence;
import org.motechproject.tama.reports.domain.repository.AllWeeklyAdherence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component
public class WeeklyAdherenceService {

    private AllWeeklyAdherence allWeeklyAdherence;


    @Autowired
    public WeeklyAdherenceService(AllWeeklyAdherence allWeeklyAdherence) {
        this.allWeeklyAdherence = allWeeklyAdherence;
    }

    public void save(WeeklyAdherence weeklyAdherence) {
        weeklyAdherence.setNumberOfDosesMissed("Missed");
        weeklyAdherence.setAdherenceReportedOn(null);
        allWeeklyAdherence.save(weeklyAdherence);
    }

    public void update(WeeklyAdherence weeklyAdherence) {
        WeeklyAdherence persistedWeeklyAdherence = new WeeklyAdherence();
        persistedWeeklyAdherence = allWeeklyAdherence.findByPatientDocumentIdAndClinicNameAndWeekStartDate(weeklyAdherence.getPatientDocumentId(),weeklyAdherence.getClinicName(),weeklyAdherence.getWeekStartDate());

        persistedWeeklyAdherence.merge(weeklyAdherence);
        allWeeklyAdherence.save(persistedWeeklyAdherence);
    }
}
