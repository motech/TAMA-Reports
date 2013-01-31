package org.motechproject.tama.reports.domain.repository;

import org.motechproject.tama.reports.domain.PatientEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllPatientsEvents extends JpaRepository<PatientEvent, Long> {
}
