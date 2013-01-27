package org.motechproject.tama.reports.contract;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;

public class MedicalHistoryRequest implements Serializable {

    private byte[] nonHivMedicalHistory;

    public JsonNode getNonHivMedicalHistory() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(nonHivMedicalHistory);
    }

    public void setNonHivMedicalHistory(JsonNode nonHivMedicalHistory) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        this.nonHivMedicalHistory = mapper.writeValueAsBytes(nonHivMedicalHistory);
    }
}