package org.motechproject.tama.reports.domain.service;


import org.motechproject.tama.reports.domain.Clinician;
import org.motechproject.tama.reports.domain.repository.AllClinicians;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClinicianService {

    private AllClinicians allClinicians;

    ClinicianService() {
    }

    @Autowired
    public ClinicianService(AllClinicians allClinicians) {
        this.allClinicians = allClinicians;
    }

    public void save(Clinician clinician) {
        allClinicians.save(clinician);
    }

    public void update(Clinician clinician) {
        Clinician persistedClinician = allClinicians.findByClinicianId(clinician.getClinicianId());
        persistedClinician.merge(clinician);
        allClinicians.save(persistedClinician);
    }
}
