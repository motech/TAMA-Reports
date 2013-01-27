package org.motechproject.tama.reports.mapping;


import org.codehaus.jackson.JsonNode;
import org.motechproject.tama.reports.domain.json.TAMAJsonArrayNode;
import org.motechproject.tama.reports.domain.json.TAMAJsonNode;
import org.motechproject.tama.reports.domain.medicalhistory.GeneralHistory;

import java.io.IOException;

import static org.motechproject.tama.reports.domain.json.Pair.pair;
import static org.motechproject.tama.reports.mapping.type.BooleanType.valueOf;

public class GeneralHistoryMapper implements Mapper<GeneralHistory> {

    public static final String QUESTIONS = "questions";
    public static final String ALLERGIES_HISTORY = "allergiesHistory";
    public static final String RASHES = "rashes";
    public static final String SPECIFIED_ALLERGIES = "specifiedAllergies";

    private TAMAJsonNode nonHivMedicalHistory;

    public GeneralHistoryMapper(JsonNode nonHivMedicalHistory) {
        this.nonHivMedicalHistory = new TAMAJsonNode(nonHivMedicalHistory);
    }

    @Override
    public GeneralHistory map() throws IOException {
        GeneralHistory history = new GeneralHistory();
        mapSpecifiedAllergies(history);
        mapRashes(history);
        mapAllergiesHistory(history);
        mapQuestions(history);
        return history;
    }

    private void mapQuestions(GeneralHistory history) {
        history.setPregnant(valueOf(getSection(QUESTIONS).contains(pair("question", "Is the patient pregnant?"), pair("historyPresent", "true"))));
        history.setBaselinePreTherapyHbLessThan10(valueOf(getSection("questions").contains(pair("question", "Was Baseline pre-therapy Hb lower than 10"), pair("historyPresent", "true"))));
    }

    private void mapAllergiesHistory(GeneralHistory history) {
        history.setSulfonamideAllergy(valueOf(getSection(ALLERGIES_HISTORY).contains(pair("drugAllergy", "Sulfonamide"), pair("specified", "true"))));
        history.setArvAllergy(valueOf(getSection(ALLERGIES_HISTORY).contains(pair("drugAllergy", "ARV"), pair("specified", "true"))));
        history.setOther(valueOf(getSection(ALLERGIES_HISTORY).contains(pair("drugAllergy", "Other"), pair("specified", "true"))));
        history.setOtherDetails(getSection(ALLERGIES_HISTORY).find(pair("drugAllergy", "Other"), pair("specified", "true")).get("description").asText());
    }

    private TAMAJsonArrayNode getSection(String secion) {
        return nonHivMedicalHistory.getArrayNode(secion);
    }

    private void mapRashes(GeneralHistory history) {
        history.setHistoryOfRash(valueOf(getSection(RASHES).isNotEmpty()));
        history.setRashToDelaviridineOrRescriptorOrDlv(valueOf(getSection(RASHES).contains("DRD")));
        history.setRashToEfavirenzOrSustivaOrStocrinOrEfv(valueOf(getSection(RASHES).contains("ESSE")));
    }

    private void mapSpecifiedAllergies(GeneralHistory history) {
        history.setHistoryOfDrugAllergy(valueOf(getSection(SPECIFIED_ALLERGIES).isNotEmpty()));
    }
}
