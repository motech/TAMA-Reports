package org.motechproject.tama.reports.mapping;


import org.apache.commons.lang.StringUtils;
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
        history.setPregnantMonths(cellValue(getSection(QUESTIONS).find(pair("question", "Is the patient pregnant?"), pair("historyPresent", "true")).get("comments").getTextValue()));
        history.setBaselinePreTherapyHbLessThan10(valueOf(getSection("questions").contains(pair("question", "Was Baseline pre-therapy Hb lower than 10"), pair("historyPresent", "true"))));
    }

    private void mapAllergiesHistory(GeneralHistory history) {
        history.setSulfonamideAllergy(valueOf(getSection(ALLERGIES_HISTORY).contains(pair("drugAllergy", "Sulfonamide"), pair("specified", "true"))));
        history.setArvAllergy(valueOf(getSection(ALLERGIES_HISTORY).contains(pair("drugAllergy", "ARV"), pair("specified", "true"))));
        history.setArvAllergyRemarks(cellValue(getSection(ALLERGIES_HISTORY).find(pair("drugAllergy", "ARV"), pair("specified", "true")).get("description").getTextValue()));
        history.setOther(valueOf(getSection(ALLERGIES_HISTORY).contains(pair("drugAllergy", "Other"), pair("specified", "true"))));
        history.setOtherDetails(otherDetails());
    }

    private void mapRashes(GeneralHistory history) {
        history.setHistoryOfRash(valueOf(getSection(RASHES).isNotEmpty()));
        history.setRashToDelaviridineOrRescriptorOrDlv(valueOf(getSection(RASHES).contains("DRD")));
        history.setRashToNevirapineOrViramuneOrNVP(valueOf(getSection(RASHES).contains("NVN")));
        history.setRashToEtravirineOrIntelenceOrTMC125(valueOf(getSection(RASHES).contains("EIT")));
        history.setRashToEfavirenzOrSustivaOrStocrinOrEfv(valueOf(getSection(RASHES).contains("ESSE")));
    }

    private void mapSpecifiedAllergies(GeneralHistory history) {
        history.setHistoryOfDrugAllergy(valueOf(getSection(SPECIFIED_ALLERGIES).isNotEmpty()));
    }

    private String otherDetails() {
        String others = otherAsText();
        return cellValue(others);
    }

    private String cellValue(String string) {
        return StringUtils.equals("null", string) ? "" : string;
    }

    private String otherAsText() {
        return getSection(ALLERGIES_HISTORY).find(pair("drugAllergy", "Other"), pair("specified", "true")).get("description").asText();
    }

    private TAMAJsonArrayNode getSection(String secion) {
        return nonHivMedicalHistory.getArrayNode(secion);
    }
}
