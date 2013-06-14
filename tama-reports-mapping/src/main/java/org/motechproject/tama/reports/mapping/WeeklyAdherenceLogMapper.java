package org.motechproject.tama.reports.mapping;


import org.motechproject.tama.reports.contract.WeeklyAdherenceLogRequest;
import org.motechproject.tama.reports.domain.WeeklyAdherence;

public class WeeklyAdherenceLogMapper implements Mapper<WeeklyAdherence> {

    private WeeklyAdherenceLogRequest weeklyAdherenceLogRequest;

    public WeeklyAdherenceLogMapper(WeeklyAdherenceLogRequest weeklyAdherenceLogRequest) {
        this.weeklyAdherenceLogRequest = weeklyAdherenceLogRequest;
    }

    public WeeklyAdherence map() {
        WeeklyAdherence weeklyAdherence = new WeeklyAdherence();

        weeklyAdherence.setPatientDocumentId(weeklyAdherenceLogRequest.getPatientId());
        weeklyAdherence.setClinicName(weeklyAdherenceLogRequest.getClinicName());
        weeklyAdherence.setArtStartDate(weeklyAdherenceLogRequest.getArtStartDate());
        weeklyAdherence.setTreatmentAdviceId(weeklyAdherenceLogRequest.getTreatmentAdviceId());
        weeklyAdherence.setStartDate(weeklyAdherenceLogRequest.getStartDate());
        weeklyAdherence.setWeekStartDate(weeklyAdherenceLogRequest.getWeekStartDate());
        weeklyAdherence.setAdherenceReportedOn(weeklyAdherenceLogRequest.getAdherenceLoggedDate());
        weeklyAdherence.setNumberOfDosesMissed(Integer.toString(weeklyAdherenceLogRequest.getNumberOfDaysMissed()));


        return weeklyAdherence;

    }

}
