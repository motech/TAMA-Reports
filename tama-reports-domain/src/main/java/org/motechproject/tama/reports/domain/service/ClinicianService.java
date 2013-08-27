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
        findDiffAndUpdate(clinicians);
        allClinicians.save(clinicians);
    }

    public void findDiffAndUpdate(List<Clinician> clinicians) {
        List<Clinician> clinicianList =  allClinicians.findByClinicId(clinicians.get(0).getClinicId());
        List<Clinician> dbClinicians =  filterByClinicId(clinicianList, clinicians.get(0).getClinicId());
        allClinicians.deleteInBatch(dbClinicians);
    }

    public List<Clinician> filterByClinicId(List<Clinician> clinicians, String clinicId) {
        List<Clinician> filteredClinicians = new ArrayList<>();
        for (Clinician clinician : clinicians) {
            if (clinicId.equals(clinician.getClinicId()) && "CC".equals(clinician.getType())) {
                filteredClinicians.add(clinician);
            }
        }
        return filteredClinicians;
    }

}
