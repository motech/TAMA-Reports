package org.motechproject.tama.reports.domain.service;


import org.motechproject.tama.reports.domain.Clinic;
import org.motechproject.tama.reports.domain.repository.AllClinics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClinicService {

    private AllClinics allClinics;

    ClinicService() {
    }

    @Autowired
    public ClinicService(AllClinics allClinics) {
        this.allClinics = allClinics;
    }

    public void save(Clinic clinic) {
        allClinics.save(clinic);
    }

    public void update(Clinic clinic) {
        Clinic persistedClinic = allClinics.findByClinicId(clinic.getClinicId());
        persistedClinic.merge(clinic);
        allClinics.save(persistedClinic);
    }
}
