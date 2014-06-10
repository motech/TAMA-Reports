package org.motechproject.tama.reports.domain.repository;

import java.util.List;

import org.motechproject.tama.reports.domain.MonitoringAgent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllMonitoringAgents extends JpaRepository<MonitoringAgent,Long>{

	public MonitoringAgent findByMonitoringAgentId(String monitoringAgentId);
	public List<MonitoringAgent> findByMonitoringAgentId(List<String> monitoringAgentIds);
}
