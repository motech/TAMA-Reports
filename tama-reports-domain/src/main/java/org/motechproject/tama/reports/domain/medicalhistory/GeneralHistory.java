package org.motechproject.tama.reports.domain.medicalhistory;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class GeneralHistory {

    @Column(name = "history_of_drug_allergy")
    private String historyOfDrugAllergy;
    @Column(name = "history_of_rash")
    private String historyOfRash;
    @Column(name = "sulfonamide_allergy")
    private String sulfonamideAllergy;
    @Column(name = "arv_allergy")
    private String arvAllergy;
    @Column(name = "arv_allergy_remarks")
    private String arvAllergyRemarks;
    @Column(name = "other")
    private String other;
    @Column(name = "other_details")
    private String otherDetails;
    @Column(name = "rash_to_delaviridine_or_rescriptor_or_dlv")
    private String rashToDelaviridineOrRescriptorOrDlv;
    @Column(name = "rash_to_nevirapine_viramune_nvp")
    private String rashToNevirapineOrViramuneOrNVP;
    @Column(name = "rash_to_etravirine_intelence_tmc125")
    private String rashToEtravirineOrIntelenceOrTMC125;
    @Column(name = "rash_to_efavirenz_or_sustiva_or_stocrin_or_efv")
    private String rashToEfavirenzOrSustivaOrStocrinOrEfv;
    @Column(name = "pregnant")
    private String pregnant;
    @Column(name = "pregnant_weeks")
    private String pregnantMonths;
    @Column(name = "baseline_pre_therapy_hb_less_than_10")
    private String baselinePreTherapyHbLessThan10;
}
