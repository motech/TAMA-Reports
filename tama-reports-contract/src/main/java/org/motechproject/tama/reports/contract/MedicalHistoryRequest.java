package org.motechproject.tama.reports.contract;

import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;

public class MedicalHistoryRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private byte[] nonHivMedicalHistory;
    @Getter
    @Setter
    private String hivTestReason;
    @Getter
    @Setter
    private String modesOfTransmission;
    @Getter
    @Setter
    private String patientId;

    public JsonNode getNonHivMedicalHistory() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(nonHivMedicalHistory);
    }

    public void setNonHivMedicalHistory(JsonNode nonHivMedicalHistory) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        this.nonHivMedicalHistory = mapper.writeValueAsBytes(nonHivMedicalHistory);
    }
}
