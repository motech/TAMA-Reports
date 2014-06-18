package org.motechproject.tama.reports.domain.service;

import java.util.List;

import org.motechproject.tama.reports.domain.MonitoringAgent;
import org.motechproject.tama.reports.domain.repository.AllMonitoringAgents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MonitoringAgentService {

	private AllMonitoringAgents allMonitoringAgents;
	
	MonitoringAgentService(){
	}

	@Autowired
	public MonitoringAgentService(AllMonitoringAgents allMonitoringAgents) {
		this.allMonitoringAgents = allMonitoringAgents;
	}
	
	 public void save(MonitoringAgent monitoringAgent){
		 allMonitoringAgents.save(monitoringAgent);
	 }
	 
	 public void save(List <MonitoringAgent> monitoringAgents){
		 allMonitoringAgents.save(monitoringAgents);
	 }
	 
	 public void update(MonitoringAgent monitoringAgent){
		 MonitoringAgent persistedMonitoringAgent = allMonitoringAgents.findByMonitoringAgentId(monitoringAgent.getMonitoringAgentId());
		 persistedMonitoringAgent.merge(monitoringAgent);
		 allMonitoringAgents.save(persistedMonitoringAgent);
	 }
}
