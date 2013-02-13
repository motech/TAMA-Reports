package org.motechproject.tama.reports.domain.medicalhistory;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import static org.apache.commons.lang.StringUtils.isNotBlank;

@Embeddable
@Data
public class SystemAllergies {

    private String asthma;
    private String psoriasis;

    @Column(name = "hay_fever")
    private String hayFever;
    private String sinusitis;
    private String hives;

    @Column(name = "allergic_dermititis_eczema")
    private String allergicDermititisEczema;
    @Column(name = "atopic_dermatitis ")
    private String atopicDermatitis;
    @Column(name = "inherited_childhood_eczema_dermititus")
    private String inheritedChildhoodEczemaDermititus;
    @Column(name = "allergic_others")
    private String allergicOthers;
    @Column(name = "allergic_remarks")
    private String allergicRemarks;

    private String dermatological;
    @Column(name = "dermatological_remarks")
    private String dermatologicalRemarks;

    private String respiratory;
    @Column(name = "respiratory_remarks")
    private String respiratoryRemarks;

    @Column(name = "coronary_disease")
    private String coronaryDisease;
    @Column(name = "coronary_other")
    private String coronaryOther;
    @Column(name = "coronary_remarks")
    private String coronaryRemarks;

    private String endocrine;
    @Column(name = "endocrine_remarks")
    private String endocrineRemarks;

    private String gastrointestinal;
    @Column(name = "gastrointestinal_remarks")
    private String gastrointestinalRemarks;

    @Column(name = "genito_urinary")
    private String genitoUrinary;
    @Column(name = "genito_urinary_remarks")
    private String genitoUrinaryRemarks;

    private String hematological;
    @Column(name = "hematological_remarks")
    private String hematologicalRemarks;

    @Column(name = "musculo_skeletal")
    private String musculoSkeletal;
    @Column(name = "musculo_skeletal_remarks")
    private String musculoSkeletalRemarks;

    private String dizziness;
    private String insomnia;
    @Column(name = "impaired_concentration")
    private String impairedConcentration;
    private String somnolence;
    @Column(name = "abnormal_dreams_nightmare")
    private String abnormalDreamsNightmare;
    @Column(name = "nuerological_others")
    private String nuerologicalOthers;
    @Column(name = "nuerological_remarks")
    private String nuerologicalRemarks;

    private String psychiatric;
    @Column(name = "psychiatric_remarks")
    private String psychiatricRemarks;

    private String eyes;
    @Column(name = "eyes_remarks")
    private String eyesRemarks;

    private String ent;
    @Column(name = "ent_remarks")
    private String entRemarks;

    private String hypertension;
    private String nephrotoxicity;
    private String diabetes;
    private String tb;
    private String alcoholism;

    @Column(name = "non_hiv_other1")
    private String nonHivOther1 = "";
    @Column(name = "non_hiv_other1_remarks")
    private String nonHivOther1Remarks = "";

    @Column(name = "non_hiv_other2")
    private String nonHivOther2 = "";
    @Column(name = "non_hiv_other2_remarks")
    private String nonHivOther2Remarks = "";

    @Column(name = "non_hiv_other3")
    private String nonHivOther3 = "";
    @Column(name = "non_hiv_other3_remarks")
    private String nonHivOther3Remarks = "";

    public void setNonHivOther(int number, String value, String remarks) {
        assignValue(number, value);
        assignRemark(number, remarks);
    }

    private void assignValue(int number, String value) {
        if (isNotBlank(value)) {
            switch (number) {
                case 1:
                    nonHivOther1 = value;
                    break;
                case 2:
                    nonHivOther2 = value;
                    break;
                case 3:
                    nonHivOther3 = value;
            }
        }
    }


    private void assignRemark(int number, String remarks) {
        if (isNotBlank(remarks)) {
            switch (number) {
                case 1:
                    nonHivOther1Remarks = remarks;
                    break;
                case 2:
                    nonHivOther2Remarks = remarks;
                    break;
                case 3:
                    nonHivOther3Remarks = remarks;
                    break;
            }
        }
    }
}
