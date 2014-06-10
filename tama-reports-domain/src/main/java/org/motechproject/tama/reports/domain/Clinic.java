package org.motechproject.tama.reports.domain;


import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Table(name = "clinic")
@Entity
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "clinic_id")
    private String clinicId;

    @NotNull
    @Column(name = "clinic_name")
    private String clinicName;

    @NotNull
    @Column(name = "city_name")
    private String cityName;
    
    @Column(name = "monitoring_agent_id")
    private String monitoringAgentId;

    @NotNull
    @Column(name = "greeting_name")
    private String greetingName;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "contact_number")
    private String contactNumber;


    public void merge(Clinic clinic) {
        this.setClinicName(clinic.getClinicName());
        this.setCityName(clinic.getCityName());
        this.setMonitoringAgentId(clinic.getMonitoringAgentId());
        this.setGreetingName(clinic.getGreetingName());
        this.setContactNumber(clinic.getContactNumber());
        this.setAddress(clinic.getAddress());
    }
}
