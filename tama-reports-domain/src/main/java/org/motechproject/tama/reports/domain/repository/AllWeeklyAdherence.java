package org.motechproject.tama.reports.domain.repository;


import org.motechproject.tama.reports.domain.WeeklyAdherence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.JpaQueryCreator;


public interface AllWeeklyAdherence extends JpaRepository<WeeklyAdherence, Long> {

    public WeeklyAdherence findWeeklyAdherenceById(String patient_document_id);
}

