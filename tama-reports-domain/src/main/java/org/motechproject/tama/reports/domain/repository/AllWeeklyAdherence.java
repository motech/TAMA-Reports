package org.motechproject.tama.reports.domain.repository;


import org.motechproject.tama.reports.domain.WeeklyAdherence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.JpaQueryCreator;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface AllWeeklyAdherence extends JpaRepository<WeeklyAdherence, Long> {

    public WeeklyAdherence findByPatientDocumentIdAndClinicNameAndWeekStartDate(String patientDocumentId,String clinicName,Date weekStartDate);


}

