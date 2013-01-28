package org.motechproject.tama.reports.mapping;


import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonNode;
import org.motechproject.tama.reports.domain.json.TAMAJsonArrayNode;
import org.motechproject.tama.reports.domain.json.TAMAJsonNode;
import org.motechproject.tama.reports.domain.medicalhistory.SystemAllergies;

import java.io.IOException;
import java.util.List;

import static org.motechproject.tama.reports.domain.json.Pair.pair;

public class SystemAllergiesMapper implements Mapper<SystemAllergies> {

    private static final String YES = "YES_WITH_HISTORY";

    private TAMAJsonNode nonHivMedicalHistory;

    public SystemAllergiesMapper(JsonNode nonHivMedicalHistory) {
        this.nonHivMedicalHistory = new TAMAJsonNode(nonHivMedicalHistory);
    }

    @Override
    public SystemAllergies map() throws IOException {
        SystemAllergies allergies = new SystemAllergies();

        setImmunologicAilments(allergies);
        setOtherAilments(allergies);
        setAllergies(allergies);
        setCoronaryAilments(allergies);
        setDermatologicalAilments(allergies);
        setNeurologicalAilments(allergies);
        setEndocrineAilments(allergies);
        setENTAilments(allergies);
        setEyeAilments(allergies);
        setGastroIntestinalAilments(allergies);
        setGenitoUrinaryAilements(allergies);
        setHematologicalAilments(allergies);
        setMusculoSkeletalAilments(allergies);
        setNonHivAilments(allergies);
        setPsychiatricAilments(allergies);
        setRespiratoryAilments(allergies);

        return allergies;
    }

    private void setRespiratoryAilments(SystemAllergies allergies) {
        allergies.setRespiratory(otherAilment("Respiratory"));
        allergies.setRespiratoryRemarks(getOtherDescription("Respiratory"));
    }

    private void setPsychiatricAilments(SystemAllergies allergies) {
        allergies.setPsychiatric(otherAilment("Psychiatric"));
        allergies.setPsychiatricRemarks(getOtherDescription("Psychiatric"));
    }

    private void setNonHivAilments(SystemAllergies allergies) {
        StringBuilder builder = new StringBuilder();

        allergies.setNonHivOther(otherAilment("Other"));
        for (TAMAJsonNode node : getAllDescriptions("Other")) {
            builder.append(node.get("description").asText());
        }
        allergies.setNonHivOtherRemarks(builder.toString());
    }

    private void setMusculoSkeletalAilments(SystemAllergies allergies) {
        allergies.setMusculoSkeletal(otherAilment("Musculo-skeletal"));
        allergies.setMusculoSkeletalRemarks(getOtherDescription("Musculo-skeletal"));
    }

    private void setHematologicalAilments(SystemAllergies allergies) {
        allergies.setHematological(otherAilment("Hematological"));
        allergies.setHematologicalRemarks(getOtherDescription("Hematological"));
    }

    private void setGenitoUrinaryAilements(SystemAllergies allergies) {
        allergies.setGenitoUrinary(otherAilment("Genito-urinary"));
        allergies.setGenitoUrinaryRemarks(getOtherDescription("Genito-urinary"));
    }

    private void setGastroIntestinalAilments(SystemAllergies allergies) {
        allergies.setGastrointestinal(otherAilment("Gastrointestinal"));
        allergies.setGastrointestinalRemarks(getOtherDescription("Gastrointestinal"));
    }

    private void setEyeAilments(SystemAllergies allergies) {
        allergies.setEyes(otherAilment("Eyes"));
        allergies.setEyesRemarks(getOtherDescription("Eyes"));
    }

    private void setENTAilments(SystemAllergies allergies) {
        allergies.setEnt(otherAilment("Ears, Nose, Throat"));
        allergies.setEntRemarks(getOtherDescription("Ears, Nose, Throat"));
    }

    private void setEndocrineAilments(SystemAllergies allergies) {
        allergies.setEndocrine(otherAilment("Endocrine"));
        allergies.setEndocrineRemarks(getOtherDescription("Endocrine"));
    }

    private void setNeurologicalAilments(SystemAllergies allergies) {
        allergies.setDizziness(ailment("Neurological", "Dizziness"));
        allergies.setImpairedConcentration(ailment("Neurological", "ImpairedConcentration"));
        allergies.setInsomnia(ailment("Neurological", "Insomnia"));

        allergies.setNuerologicalOthers(otherAilment("Neurological"));
        allergies.setNuerologicalRemarks(getOtherDescription("Neurological"));
        allergies.setAbnormalDreamsNightmare(ailment("Neurological", "Nightmares"));
        allergies.setSomnolence(ailment("Neurological", "Somnolence"));
    }

    private void setDermatologicalAilments(SystemAllergies allergies) {
        allergies.setDermatological(otherAilment("Dermatological"));
        allergies.setDermatologicalRemarks(getOtherDescription("Dermatological"));
    }

    private void setCoronaryAilments(SystemAllergies allergies) {
        allergies.setCoronaryDisease(ailment("Cardiovascular", "CoronaryDisease"));
        allergies.setCoronaryOther(otherAilment("Cardiovascular"));
        allergies.setCoronaryRemarks(getOtherDescription("Cardiovascular"));
    }

    private void setAllergies(SystemAllergies allergies) {
        allergies.setAllergicOthers(otherAilment("Allergic/Immunologic"));
        allergies.setAllergicRemarks(getOtherDescription("Allergic/Immunologic"));
    }

    private void setOtherAilments(SystemAllergies allergies) {
        allergies.setAlcoholism(ailment("Other", "Alcoholism"));
        allergies.setDiabetes(ailment("Other", "Diabetes"));
        allergies.setHypertension(ailment("Other", "Hypertension"));
        allergies.setPsoriasis(ailment("Allergic/Immunologic", "Psoriasis"));
        allergies.setTb(ailment("Other", "Tuberculosis"));
        allergies.setNephrotoxicity(ailment("Other", "Nephrotoxicity"));
    }

    private void setImmunologicAilments(SystemAllergies allergies) {
        allergies.setAllergicDermititisEczema(ailment("Allergic/Immunologic", "AllergicDermatitis"));
        allergies.setAsthma(ailment("Allergic/Immunologic", "Asthma"));
        allergies.setHives(ailment("Allergic/Immunologic", "Hives"));
        allergies.setHayFever(ailment("Allergic/Immunologic", "HayFever"));
        allergies.setInheritedChildhoodEczemaDermititus(ailment("Allergic/Immunologic", "InheritedChildHoodEczema"));
        allergies.setSinusitis(ailment("Allergic/Immunologic", "Sinusitis"));

    }

    private String ailment(String category, String name) {
        return nonHivMedicalHistory
                .getArrayNode("systemCategories")
                .find(pair("name", category))
                .getArrayNode("ailments.ailments")
                .find(pair("definition", name))
                .get("state").asText();

    }

    private String otherAilment(String category) {
        return otherAilments(category)
                .find(pair("definition", "others"))
                .get("state").asText();
    }

    private String getOtherDescription(String category) {
        String text = descriptionAsText(category);
        return StringUtils.equals("null", text) ? "" : text;
    }

    private String descriptionAsText(String category) {
        return otherAilments(category)
                .find(pair("definition", "others"), pair("state", YES))
                .get("description").asText();
    }

    private List<TAMAJsonNode> getAllDescriptions(String category) {
        return otherAilments(category).findAll(pair("definition", "others"), pair("state", YES));
    }

    private TAMAJsonArrayNode otherAilments(String category) {
        return nonHivMedicalHistory
                .getArrayNode("systemCategories")
                .find(pair("name", category))
                .getArrayNode("ailments.otherAilments");
    }
}
