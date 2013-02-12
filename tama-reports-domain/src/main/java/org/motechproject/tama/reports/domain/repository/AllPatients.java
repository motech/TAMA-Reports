package org.motechproject.tama.reports.domain.repository;

import org.motechproject.tama.reports.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllPatients extends JpaRepository<Patient, Long> {

    public Patient findByPatientDocumentId(String patientDocumentId);
}
