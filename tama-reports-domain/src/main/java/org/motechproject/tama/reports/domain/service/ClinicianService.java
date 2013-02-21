package org.motechproject.tama.reports.domain.service;


import org.motechproject.tama.reports.domain.Clinician;
import org.motechproject.tama.reports.domain.repository.AllClinicians;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    public void save(List<Clinician> clinicians) {
        allClinicians.save(clinicians);
    }

    public void update(Clinician clinician) {
        Clinician persistedClinician = allClinicians.findByClinicianId(clinician.getClinicianId());
        persistedClinician.merge(clinician);
        allClinicians.save(persistedClinician);
    }

    public void update(List<Clinician> clinicians) {
        List<String> clinicianIds = extractClinicianIds(clinicians);
        List<Clinician> existingClinicians = allClinicians.findByClinicianIdIn(clinicianIds);
        allClinicians.delete(existingClinicians);
        allClinicians.save(clinicians);
    }

    private List<String> extractClinicianIds(List<Clinician> clinicians) {
        List<String> clinicianIds = new ArrayList<>();
        for (Clinician clinician : clinicians) {
            clinicianIds.add(clinician.getClinicianId());
        }
        return clinicianIds;
    }
}
