package org.motechproject.tama.reports.domain;

import javax.validation.constraints.NotNull;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;


@Data
@Table(name = "monitoring_agent")
@Entity
public class MonitoringAgent {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "monitoring_agent_Id")
    private String monitoringAgentId;

    @Column(name = "contact_number")
    private String contactNumber;



    @NotNull
    @Column(name = "monitoring_agent_name")
    private String name;

    @Column(name = "type")
    private String type;
    
    public void merge(MonitoringAgent monitoringAgent) {
        setContactNumber(monitoringAgent.getContactNumber());
        setName(monitoringAgent.getName());
        setType(monitoringAgent.getType());
    }
}
