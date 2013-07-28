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
        findDiffAndUpdate(clinicians);
        for(String oClinician : clinicianIds)
        {
            Clinician clinician= allClinicians.findByClinicianId(oClinician);
            if(clinician!=null)
            {
                allClinicians.delete(clinician);
            }

        }
        allClinicians.save(clinicians);
    }

    public void findDiffAndUpdate(List<Clinician> clinicians)
    {
        List<Clinician> dbClinicians = filterByClinicId(allClinicians.findByClinicId( clinicians.get(0).getClinicId()), clinicians.get(0).getClinicId());
        if(dbClinicians.size() > clinicians.size())
        {
            for(int i=0;i<dbClinicians.size();i++)
            {

               if(dbClinicians.get(i)!=null)
               {
                   if(!clinicians.contains(dbClinicians.get(i)))
                   {
                     allClinicians.delete(dbClinicians.get(i));
                   }
               }

            }
        }
    }

    public List<Clinician> filterByClinicId(List<Clinician> clinicians,String clinicId)
    {
        List<Clinician> filteredClinicians = new ArrayList<>();
        for(Clinician clinician : clinicians)
        {
            if(clinicId.equals(clinician.getClinicId()) &&  "CC".equals(clinician.getType()))
            {
                filteredClinicians.add(clinician);
            }

        }

        return filteredClinicians;
    }

    private List<String> extractClinicianIds(List<Clinician> clinicians) {
        List<String> clinicianIds = new ArrayList<>();
        for (Clinician clinician : clinicians) {
            clinicianIds.add(clinician.getClinicianId());
        }
        return clinicianIds;
    }
}
