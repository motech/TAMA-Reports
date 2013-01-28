package org.motechproject.tama.reports.mapping;


import org.codehaus.jackson.JsonNode;
import org.motechproject.tama.reports.domain.json.TAMAJsonArrayNode;
import org.motechproject.tama.reports.domain.json.TAMAJsonNode;
import org.motechproject.tama.reports.domain.medicalhistory.SystemAllergies;

import java.io.IOException;
import java.util.List;

import static org.motechproject.tama.reports.domain.json.Pair.pair;
import static org.motechproject.tama.reports.mapping.type.BooleanType.valueOf;

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
        allergies.setRespiratory(hasOtherAilment("Respiratory"));
        allergies.setRespiratoryRemarks(getOtherDescription("Respiratory"));
    }

    private void setPsychiatricAilments(SystemAllergies allergies) {
        allergies.setPsychiatric(hasOtherAilment("Psychiatric"));
        allergies.setPsychiatricRemarks(getOtherDescription("Psychiatric"));
    }

    private void setNonHivAilments(SystemAllergies allergies) {
        StringBuilder builder = new StringBuilder();

        allergies.setNonHivOther(hasOtherAilment("Other"));
        for (TAMAJsonNode node : getAllDescriptions("Other")) {
            builder.append(node.get("description").asText());
        }
        allergies.setNonHivOtherRemarks(builder.toString());
    }

    private void setMusculoSkeletalAilments(SystemAllergies allergies) {
        allergies.setMusculoSkeletal(hasOtherAilment("Musculo-skeletal"));
        allergies.setMusculoSkeletalRemarks(getOtherDescription("Musculo-skeletal"));
    }

    private void setHematologicalAilments(SystemAllergies allergies) {
        allergies.setHematological(hasOtherAilment("Hematological"));
        allergies.setHematologicalRemarks(getOtherDescription("Hematological"));
    }

    private void setGenitoUrinaryAilements(SystemAllergies allergies) {
        allergies.setGenitoUrinary(hasOtherAilment("Genito-urinary"));
        allergies.setGenitoUrinaryRemarks(getOtherDescription("Genito-urinary"));
    }

    private void setGastroIntestinalAilments(SystemAllergies allergies) {
        allergies.setGastrointestinal(hasOtherAilment("Gastrointestinal"));
        allergies.setGastrointestinalRemarks(getOtherDescription("Gastrointestinal"));
    }

    private void setEyeAilments(SystemAllergies allergies) {
        allergies.setEyes(hasOtherAilment("Eyes"));
        allergies.setEyesRemarks(getOtherDescription("Eyes"));
    }

    private void setENTAilments(SystemAllergies allergies) {
        allergies.setEnt(hasOtherAilment("Ears, Nose, Throat"));
        allergies.setEntRemarks(getOtherDescription("Ears, Nose, Throat"));
    }

    private void setEndocrineAilments(SystemAllergies allergies) {
        allergies.setEndocrine(hasOtherAilment("Endocrine"));
        allergies.setEndocrineRemarks(getOtherDescription("Endocrine"));
    }

    private void setNeurologicalAilments(SystemAllergies allergies) {
        allergies.setDizziness(hasAilment("Neurological", "Dizziness"));
        allergies.setImpairedConcentration(hasAilment("Neurological", "ImpairedConcentration"));
        allergies.setInsomnia(hasAilment("Neurological", "Insomnia"));

        allergies.setNuerologicalOthers(hasOtherAilment("Neurological"));
        allergies.setNuerologicalRemarks(getOtherDescription("Neurological"));
    }

    private void setDermatologicalAilments(SystemAllergies allergies) {
        allergies.setDermatological(hasOtherAilment("Dermatological"));
        allergies.setDermatologicalRemarks(getOtherDescription("Dermatological"));
    }

    private void setCoronaryAilments(SystemAllergies allergies) {
        allergies.setCoronaryDisease(hasAilment("Cardiovascular", "CoronaryDisease"));
        allergies.setCoronaryOther(hasOtherAilment("Cardiovascular"));
        allergies.setCoronaryRemarks(getOtherDescription("Cardiovascular"));
    }

    private void setAllergies(SystemAllergies allergies) {
        allergies.setAllergicOthers(hasOtherAilment("Allergic/Immunologic"));
        allergies.setAllergicRemarks(getOtherDescription("Allergic/Immunologic"));
    }

    private void setOtherAilments(SystemAllergies allergies) {
        allergies.setAlcoholism(hasAilment("Other", "Alcoholism"));
        allergies.setDiabetes(hasAilment("Other", "Diabetes"));
        allergies.setHypertension(hasAilment("Other", "Hypertension"));
        allergies.setPsoriasis(hasAilment("Allergic/Immunologic", "Psoriasis"));
        allergies.setTb(hasAilment("Other", "Tuberculosis"));
        allergies.setNephrotoxicity(hasAilment("Other", "Nephrotoxicity"));
    }

    private void setImmunologicAilments(SystemAllergies allergies) {
        allergies.setAbnormalDreamsNightmare(hasAilment("Allergic/Immunologic", "Asthma"));
        allergies.setAllergicDermititisEczema(hasAilment("Allergic/Immunologic", "AllergicDermatitis"));
        allergies.setAsthma(hasAilment("Allergic/Immunologic", "Asthma"));
        allergies.setHives(hasAilment("Allergic/Immunologic", "Hives"));
        allergies.setHayFever(hasAilment("Allergic/Immunologic", "HayFever"));
        allergies.setInheritedChildhoodEczemaDermititus(hasAilment("Allergic/Immunologic", "InheritedChildHoodEczema"));
        allergies.setSinusitis(hasAilment("Allergic/Immunologic", "Sinusitis"));
        allergies.setSomnolence(hasAilment("Allergic/Immunologic", "Somnolence"));
    }

    private String hasAilment(String category, String name) {
        return valueOf(
                nonHivMedicalHistory
                        .getArrayNode("systemCategories")
                        .find(pair("name", category))
                        .getArrayNode("ailments.ailments")
                        .contains(pair("definition", name), pair("state", YES))
        );
    }

    private String hasOtherAilment(String category) {
        return valueOf(otherAilments(category).contains(pair("definition", "others"), pair("state", YES)));
    }

    private List<TAMAJsonNode> getAllDescriptions(String category) {
        return otherAilments(category).findAll(pair("definition", "others"), pair("state", YES));
    }

    private String getOtherDescription(String category) {
        return otherAilments(category)
                .find(pair("definition", "others"), pair("state", YES))
                .get("description").asText();
    }

    private TAMAJsonArrayNode otherAilments(String category) {
        return nonHivMedicalHistory
                .getArrayNode("systemCategories")
                .find(pair("name", category))
                .getArrayNode("ailments.otherAilments");
    }
}
