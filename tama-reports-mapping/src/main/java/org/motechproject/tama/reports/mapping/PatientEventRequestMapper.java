package org.motechproject.tama.reports.mapping;


import org.motechproject.tama.reports.contract.PatientEventRequest;
import org.motechproject.tama.reports.domain.PatientEvent;

import static org.apache.commons.lang.StringUtils.isNotBlank;

public class PatientEventRequestMapper extends RequestMapper<PatientEventRequest, PatientEvent> {

    private PatientEventRequest request;

    public PatientEventRequestMapper(PatientEventRequest request) {
        this.request = request;
    }

    public PatientEvent map() {
        PatientEvent event = super.map(request, PatientEvent.class);
        event.setEventName(nonEmptyStringValue(request.getEventName()));
        event.setNewValue(nonEmptyStringValue(request.getNewValue()));
        return event;
    }

    private String nonEmptyStringValue(String value) {
        return isNotBlank(value) ? value : "";
    }
}
