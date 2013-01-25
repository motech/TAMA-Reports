create table tama_reports.patient (
    id serial,
    patient_id varchar(100),
    date_of_birth date,
    gender varchar(10),
    clinic_id varchar(100),
    travel_time_to_clinic varchar(100),
    ivr_pass_code varchar(10),
    ivr_language varchar(10),
    call_preference varchar(10),
    best_call_time varchar(20),
    receive_otc_advice varchar(10),
    receive_appointment_reminder varchar(10)
);

create table tama_reports.clinic (
    id serial,
    clinic_id varchar(100),
    clinic_name varchar(100)
);

create table tama_reports.medical_history (
    id serial,

    patient_id varchar(100),

    history_of_drug_allergy varchar(10),
    history_of_rash varchar(10),
    sulfonamide_allergy varchar(10),
    arv_allergy varchar(10),
    other varchar(3),
    other_details varchar(100),
    rash_to_delaviridine_or_rescriptor_or_dlv varchar(10),
    rash_to_efavirenz_or_sustiva_or_stocrin_or_efv varchar(10),
    pregnant varchar(10),
    baseline_pre_therapy_hb_less_than_10 varchar(10),

    asthma varchar(10),
    psoriasis varchar(10),
    hay_fever varchar(10),
    sinusitis varchar(10),
    hives varchar(10),

    allergic_dermititis_eczema varchar(10),
    inherited_childhood_eczema_dermititus varchar(10),
    allergic_others varchar(100),
    allergic_remarks varchar(100),

    dermatological varchar(10),
    dermatological_remarks varchar(100),

    respiratory varchar(10),
    respiratory_remarks varchar(100),

    coronary_disease varchar(10),
    coronary_other varchar(100),
    coronary_remarks varchar(100),

    endocrine varchar(10),
    endocrine_remarks varchar(100),

    gastrointestinal varchar(10),
    gastrointestinal_remarks varchar(100),

    genito_urinary varchar(10),
    genito_urinary_remarks varchar(100),

    hematological varchar(10),
    hematological_remarks varchar(100),

    musculo_skeletal varchar(10),
    musculo_skeletal_remarks varchar(100),

    dizziness varchar(10),
    insomnia varchar(10),
    impaired_concentration varchar(10),
    somnolence varchar(10),
    abnormal_dreams_nightmare varchar(10),
    nuerological_others varchar(100),
    nuerological_remarks varchar(100),

    psychiatric varchar(10),
    psychiatric_remarks varchar(100),

    eyes varchar(10),
    eyes_remarks varchar(100),

    ent varchar(10),
    ent_remarks varchar(100),

    hypertension varchar(10),
    nephrotoxicity varchar(10),
    diabetes varchar(10),
    tb varchar(10),
    alcoholism varchar(10),

    non_hiv_other varchar(100),
    non_hiv_other_remarks varchar(100)
);