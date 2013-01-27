package org.motechproject.tama.reports.mapping;


import org.motechproject.tama.reports.contract.MedicalHistoryRequest;
import org.motechproject.tama.reports.domain.medicalhistory.MedicalHistory;

import java.io.IOException;

public class MedicalHistoryMapper implements Mapper<MedicalHistory> {

    private MedicalHistoryRequest request;
    private GeneralHistoryMapper generalHistoryMapper;

    public MedicalHistoryMapper(MedicalHistoryRequest request, GeneralHistoryMapper generalHistoryMapper) {
        this.request = request;
        this.generalHistoryMapper = generalHistoryMapper;
    }

    public MedicalHistoryMapper(MedicalHistoryRequest request) throws IOException {
        this(request, new GeneralHistoryMapper(request.getNonHivMedicalHistory()));
    }

    @Override
    public MedicalHistory map() throws IOException {
        MedicalHistory history = new MedicalHistory();
        history.setGeneralHistory(generalHistoryMapper.map());
        return history;
    }
}
