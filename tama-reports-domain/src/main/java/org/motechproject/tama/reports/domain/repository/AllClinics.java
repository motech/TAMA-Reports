package org.motechproject.tama.reports.domain.repository;

import org.motechproject.tama.reports.domain.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllClinics extends JpaRepository<Clinic, Long> {

    public Clinic findByClinicId(String clinicId);
}
