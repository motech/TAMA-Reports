package org.motechproject.tama.reports.mapping;

import org.apache.commons.lang.StringUtils;
import org.motechproject.tama.reports.contract.MessagesRequest;
import org.motechproject.tama.reports.domain.Messages;

public class MessagesMapper implements Mapper<Messages> {

    private MessagesRequest messagesRequest;

    public MessagesMapper(MessagesRequest messagesRequest) {
        this.messagesRequest = messagesRequest;
    }

    public Messages map() {
        Messages messages = new Messages();
        messages.setPatientDocumentId(messagesRequest.getPatientDocumentId());
        messages.setCallDate(messagesRequest.getCallDate());
        messages.setCallMadeBy(callMadeBy());
        messages.setPushedMessages(StringUtils.join(messagesRequest.getPushedMessages(), ", "));
        messages.setMessagesPlayed(StringUtils.join(messagesRequest.getMessagesPlayed(), ", "));
        messages.setNumberOfTimesMessagesAccessed(messagesRequest.getNumberOfTimesMessagesAccessed());
        messages.setIndividualMessagesAccessDurations(StringUtils.join(messagesRequest.getIndividualMessagesAccessDurations(), ", "));
        messages.setTotalMessagesAccessDuration(messagesRequest.getTotalMessagesAccessDuration());
        return messages;
    }

    private String callMadeBy() {
        if (StringUtils.equalsIgnoreCase("incoming", messagesRequest.getCallDirection())) {
            return "Patient";
        } else {
            return "TAMA";
        }
    }
}
