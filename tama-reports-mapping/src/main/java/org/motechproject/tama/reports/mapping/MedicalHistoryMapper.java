package org.motechproject.tama.reports.mapping;


import org.motechproject.tama.reports.contract.MedicalHistoryRequest;
import org.motechproject.tama.reports.domain.medicalhistory.MedicalHistory;

import java.io.IOException;

public class MedicalHistoryMapper implements Mapper<MedicalHistory> {

    private MedicalHistoryRequest request;
    private GeneralHistoryMapper generalHistoryMapper;
    private SystemAllergiesMapper systemAllergiesMapper;

    public MedicalHistoryMapper(MedicalHistoryRequest request, GeneralHistoryMapper generalHistoryMapper, SystemAllergiesMapper systemAllergiesMapper) {
        this.request = request;
        this.generalHistoryMapper = generalHistoryMapper;
        this.systemAllergiesMapper = systemAllergiesMapper;
    }

    public MedicalHistoryMapper(MedicalHistoryRequest request) throws IOException {
        this(request, new GeneralHistoryMapper(request.getNonHivMedicalHistory()), new SystemAllergiesMapper(request.getNonHivMedicalHistory()));
    }

    @Override
    public MedicalHistory map() throws IOException {
        MedicalHistory history = new MedicalHistory();
        history.setPatientId(request.getPatientId());
        history.setGeneralHistory(generalHistoryMapper.map());
        history.setSystemAllergies(systemAllergiesMapper.map());
        return history;
    }
}
