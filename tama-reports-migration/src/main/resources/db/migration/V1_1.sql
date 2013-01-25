create table tama_reports.patient (
    id serial,
    patient_doc_id varchar(100),
    patient_id varchar(100),
    date_of_birth date,
    gender varchar(10),
    clinic varchar(100),
    travel_time_to_clinic varchar(100),
    ivr_pass_code varchar(10),
    ivr_language varchar(10),
    call_preference varchar(10),
    best_call_time varchar(20),
    receive_otc_advice boolean,
    receive_appointment_reminder boolean,
    phone_number varchar(15)
);

create table tama_reports.clinic (
    id serial,
    clinic_id varchar(100),
    clinic_name varchar(100)
);