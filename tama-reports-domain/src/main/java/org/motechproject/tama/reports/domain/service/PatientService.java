package org.motechproject.tama.reports.domain.service;


import org.apache.commons.dbcp.BasicDataSource;
import org.motechproject.tama.reports.domain.Patient;
import org.motechproject.tama.reports.domain.repository.AllPatients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.SQLException;

@Service
@Transactional
public class PatientService {

    private AllPatients allPatients;
    private BasicDataSource dataSource;

    PatientService() {
    }

    @Autowired
    public PatientService(AllPatients allPatients, @Qualifier("dataSource") BasicDataSource dataSource) {
        this.allPatients = allPatients;
        this.dataSource = dataSource;
    }

    public void save(Patient patient) {
        allPatients.save(patient);
    }

    public void update(Patient patient) {
        Patient persistedPatient = allPatients.findByPatientId(patient.getPatientId());
        persistedPatient.merge(patient);
        allPatients.save(persistedPatient);
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
