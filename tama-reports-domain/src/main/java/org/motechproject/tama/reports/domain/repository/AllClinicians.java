package org.motechproject.tama.reports.domain.repository;

import org.motechproject.tama.reports.domain.Clinician;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AllClinicians extends JpaRepository<Clinician, Long> {

    public Clinician findByClinicianId(String clinicianId);

    public List<Clinician> findByClinicianIdIn(List<String> clinicianIds);

    public List<Clinician> findByClinicId(String clinicId);
}
