package org.motechproject.tama.reports.domain.repository;


import org.motechproject.tama.reports.domain.WeeklyAdherence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.JpaQueryCreator;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface AllWeeklyAdherence extends JpaRepository<WeeklyAdherence, Long> {

    @Query("SELECT p FROM weeklyAdherenceLog p WHERE p.patient_document_id =patient_document_id")
    public List<WeeklyAdherence> find(@Param("patient_document_id")String patient_document_id);


}

