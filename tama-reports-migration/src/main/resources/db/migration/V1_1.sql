create table tama_reports.patient (
    id serial,
    patient_id varchar(100),
    patient_document_id varchar(100),
    date_of_birth date,
    gender varchar(10),
    clinic_id varchar(100),
    travel_time_to_clinic varchar(100),
    ivr_pass_code varchar(10),
    ivr_language varchar(10),
    call_preference varchar(10),
    best_call_time varchar(20),
    receive_otc_advice varchar(10),
    receive_appointment_reminder varchar(10),
    registered_on timestamp,
    status varchar(50),
    notes text
);

create table tama_reports.clinic (
    id serial,
    clinic_id varchar(100),
    clinic_name varchar(100)
);

create table tama_reports.medical_history (
    id serial,

    patient_id varchar(100),
    patient_document_id varchar(100),

    test_reason text,
    modes_of_transmission text,

    history_of_drug_allergy varchar(20),
    history_of_rash varchar(20),
    sulfonamide_allergy varchar(20),
    arv_allergy varchar(20),
    arv_allergy_remarks varchar(20),

    other varchar(3),
    other_details text,
    rash_to_delaviridine_or_rescriptor_or_dlv varchar(20),
    rash_to_efavirenz_or_sustiva_or_stocrin_or_efv varchar(20),
    rash_to_nevirapine_viramune_nvp varchar(20),
    rash_to_etravirine_intelence_tmc125 varchar(20),

    pregnant varchar(20),
    pregnant_months varchar(20),
    baseline_pre_therapy_hb_less_than_10 varchar(20),

    asthma varchar(20),
    psoriasis varchar(20),
    hay_fever varchar(20),
    sinusitis varchar(20),
    hives varchar(20),

    allergic_dermititis_eczema varchar(20),
    inherited_childhood_eczema_dermititus varchar(20),
    atopic_dermatitis varchar(20),

    allergic_others text,
    allergic_remarks text,

    dermatological varchar(20),
    dermatological_remarks text,

    respiratory varchar(20),
    respiratory_remarks text,

    coronary_disease varchar(20),
    coronary_other text,
    coronary_remarks text,

    endocrine varchar(20),
    endocrine_remarks text,

    gastrointestinal varchar(20),
    gastrointestinal_remarks text,

    genito_urinary varchar(20),
    genito_urinary_remarks text,

    hematological varchar(20),
    hematological_remarks text,

    musculo_skeletal varchar(20),
    musculo_skeletal_remarks text,

    dizziness varchar(20),
    insomnia varchar(20),
    impaired_concentration varchar(20),
    somnolence varchar(20),
    abnormal_dreams_nightmare varchar(20),
    nuerological_others text,
    nuerological_remarks text,

    psychiatric varchar(20),
    psychiatric_remarks text,

    eyes varchar(20),
    eyes_remarks text,

    ent varchar(20),
    ent_remarks text,

    hypertension varchar(20),
    nephrotoxicity varchar(20),
    diabetes varchar(20),
    tb varchar(20),
    alcoholism varchar(20),

    non_hiv_other1 text,
    non_hiv_other1_remarks text,

    non_hiv_other2 text,
    non_hiv_other2_remarks text,

    non_hiv_other3 text,
    non_hiv_other3_remarks text
);

create table tama_reports.patient_event (
    id serial,
    patient_document_id varchar(100),
    event_name varchar(50),
    new_value text,
    date_time timestamp,
    performed_by varchar(100)
);