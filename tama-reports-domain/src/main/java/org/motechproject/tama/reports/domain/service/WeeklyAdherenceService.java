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
        allWeeklyAdherence.save(weeklyAdherence);
    }

    public void update(WeeklyAdherence weeklyAdherence) {
        WeeklyAdherence persistedWeeklyAdherence = new WeeklyAdherence();
        List<WeeklyAdherence> weeklyAdherences = null;
        weeklyAdherences = allWeeklyAdherence.findWeeklyAdherenceById(weeklyAdherence.getPatientDocumentId());
        if (weeklyAdherences != null) {
            if (weeklyAdherences.size() != 0) {
                persistedWeeklyAdherence = weeklyAdherences.get(0);
            }
        }

        //allWeeklyAdherence.findWeeklyAdherenceById(weeklyAdherence.getPatientDocumentId(),weeklyAdherence.getClinicName(),
        // weeklyAdherence.getWeekStartDate().getTime());
        //new WeeklyAdherence();

        //allWeeklyAdherence.findSimilarWeeklyLog(weeklyAdherence.getPatientDocumentId());
        //, weeklyAdherence.getClinicName(), weeklyAdherence.getTreatmentAdviceId(), weeklyAdherence.getWeekStartDate().toString());
        persistedWeeklyAdherence.merge(weeklyAdherence);
        allWeeklyAdherence.save(persistedWeeklyAdherence);
    }

    private List<WeeklyAdherence> filterAlertsByClinicName(List<WeeklyAdherence> weeklyAdherences, String clinicName) {
        List<WeeklyAdherence> filteredAlerts = new ArrayList();
        CollectionUtils.select(weeklyAdherences, getSelectorForClinic(clinicName), filteredAlerts);
        return filteredAlerts;

    }

    private List<WeeklyAdherence> filterAlertsByWeekStartDate(List<WeeklyAdherence> weeklyAdherences, Date weekStartDate) {
        List<WeeklyAdherence> filteredAlerts = new ArrayList();
        CollectionUtils.select(weeklyAdherences, getSelectorForDate(weekStartDate), filteredAlerts);
        return filteredAlerts;

    }


    private Predicate getSelectorForClinic(final String clinicName) {
        return new Predicate() {
            @Override
            public boolean evaluate(Object o) {
                WeeklyAdherence weeklyAdherence = (WeeklyAdherence) o;
                return weeklyAdherence.getClinicName().equals(clinicName);
            }
        };
    }

    private Predicate getSelectorForDate(final Date weekStartDate) {
        return new Predicate() {
            @Override
            public boolean evaluate(Object o) {
                WeeklyAdherence weeklyAdherence = (WeeklyAdherence) o;
                return weeklyAdherence.getWeekStartDate().equals(weekStartDate);
            }
        };
    }


}
