package org.motechproject.tama.reports.domain.repository;


import org.motechproject.tama.reports.domain.WeeklyAdherence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.JpaQueryCreator;

import java.util.List;


public interface AllWeeklyAdherence extends JpaRepository<WeeklyAdherence, Long> {

    public List<WeeklyAdherence> findWeeklyAdherenceById(List<String> patient_document_id);
}

