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
        List<WeeklyAdherence> weeklyAdherences = null;
        persistedWeeklyAdherence = allWeeklyAdherence.findByPatientDocumentIdAndClinicNameAndWeekStartDate(weeklyAdherence.getPatientDocumentId(),weeklyAdherence.getClinicName(),weeklyAdherence.getWeekStartDate());

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
