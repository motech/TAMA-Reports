package org.motechproject.tama.reports.web.excel;

public class MonitoringAgentSMSLogParameters extends AbstractReportParameters {

    public static String MONITORING_AGENT_ID = "MONITORING_AGENT_ID";
    public static String START_DATE = "START_DATE";
    public static String END_DATE = "END_DATE";
    
    public MonitoringAgentSMSLogParameters setStartDate(String startDate) {
        exactMatchParameter(START_DATE, startDate, false);
        return this;
    }
    public MonitoringAgentSMSLogParameters setEndDate(String endDate) {
        exactMatchParameter(END_DATE, endDate, false);
        return this;
    }
    public MonitoringAgentSMSLogParameters setMonitoringAgentId(String monitoringAgentId){
    	 exactMatchParameter(MONITORING_AGENT_ID, monitoringAgentId, true);
         return this;
     
    }
    
    
}
