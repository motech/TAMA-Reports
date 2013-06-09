create table tama_reports.weeklyAdherenceLog (
    id serial PRIMARY KEY,
    patient_document_id varchar(100),
    clinic_Name varchar(100),
    art_start_date timestamp,
    treatmentAdviceId varchar(100),
    start_date timestamp,
    week_start_date timestamp,
    adherence_reported_on timestamp,
    no_of_doses_missed numeric
);
