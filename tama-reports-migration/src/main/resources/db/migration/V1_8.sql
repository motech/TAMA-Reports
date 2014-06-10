create table tama_reports.monitoring_agent (
    id serial PRIMARY KEY,
    monitoring_agent_Id varchar(100) UNIQUE,
    monitoring_agent_name varchar(100),
    contact_number varchar(20),
    type varchar(2)
);

ALTER TABLE tama_reports.clinic ADD COLUMN monitoring_agent_id varchar(100);