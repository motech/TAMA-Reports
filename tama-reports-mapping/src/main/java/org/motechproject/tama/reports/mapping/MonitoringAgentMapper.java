package org.motechproject.tama.reports.mapping;

import org.motechproject.tama.reports.contract.MonitoringAgentRequest;
import org.motechproject.tama.reports.domain.MonitoringAgent;

public class MonitoringAgentMapper extends RequestMapper<MonitoringAgentRequest,MonitoringAgent>{

	private MonitoringAgentRequest request;

	public MonitoringAgentMapper(MonitoringAgentRequest request) {
		super();
		this.request = request;
	}
	
	public MonitoringAgent map(){
		MonitoringAgent monitoringAgent = new RequestMapper<MonitoringAgentRequest,MonitoringAgent>().map(request, MonitoringAgent.class);
		monitoringAgent.setType("M");
			return monitoringAgent;	
	}
}
