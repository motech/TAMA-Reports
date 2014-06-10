package org.motechproject.tama.reports.contract;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class MonitoringAgentRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String monitoringAgentId;
	private String contactNumber;
    private String name;
	
}
