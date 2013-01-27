package org.motechproject.tama.reports.domain.repository;

import org.motechproject.tama.reports.domain.medicalhistory.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllMedicalHistories extends JpaRepository<MedicalHistory, Long> {
}
