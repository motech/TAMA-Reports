package org.motechproject.tama.reports.domain.repository;

import org.motechproject.tama.reports.domain.Clinician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllClinicians extends JpaRepository<Clinician, Long> {

    public Clinician findByClinicianId(String clinicianId);
}
