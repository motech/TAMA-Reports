package org.motechproject.tama.reports.mapping;

import org.joda.time.DateTime;
import org.junit.Test;
import org.motechproject.tama.reports.contract.MessagesRequest;
import org.motechproject.tama.reports.domain.Messages;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class MessagesMapperTest {

    @Test
    public void shouldMapPatientDocumentId() {
        MessagesRequest messagesRequest = new MessagesRequest();
        messagesRequest.setPatientDocumentId("patientDocumentId");

        Messages messages = new MessagesMapper(messagesRequest).map();
        assertEquals(messagesRequest.getPatientDocumentId(), messages.getPatientDocumentId());
    }

    @Test
    public void shouldMapCallDate() {
        MessagesRequest messagesRequest = new MessagesRequest();
        messagesRequest.setCallDate(DateTime.now().toDate());

        Messages messages = new MessagesMapper(messagesRequest).map();
        assertEquals(messagesRequest.getCallDate(), messages.getCallDate());
    }


    @Test
    public void shouldMapCallMadeByDuringIncomingCall() {
        MessagesRequest messagesRequest = new MessagesRequest();
        messagesRequest.setCallDirection("incoming");

        Messages messages = new MessagesMapper(messagesRequest).map();
        assertEquals("Patient", messages.getCallMadeBy());
    }

    @Test
    public void shouldMapCallMadeByDuringOutgoingCall() {
        MessagesRequest messagesRequest = new MessagesRequest();
        messagesRequest.setCallDirection("outgoing");

        Messages messages = new MessagesMapper(messagesRequest).map();
        assertEquals("TAMA", messages.getCallMadeBy());
    }

    @Test
    public void shouldJoinMessagesPlayedDuringTheCall() {
        MessagesRequest messagesRequest = new MessagesRequest();
        messagesRequest.setMessagesPlayed(asList("message1", "message2"));

        Messages messages = new MessagesMapper(messagesRequest).map();
        assertEquals("message1, message2", messages.getMessagesPlayed());
    }

    @Test
    public void shouldMapPushedMessages() {
        MessagesRequest messagesRequest = new MessagesRequest();
        messagesRequest.setPushedMessages(asList("message1", "message2"));

        Messages messages = new MessagesMapper(messagesRequest).map();
        assertEquals("message1, message2", messages.getPushedMessages());
    }

    @Test
    public void shouldMapTotalNumberOfTimesMessagesWereAccessedDuringTheCall() {
        MessagesRequest messagesRequest = new MessagesRequest();
        messagesRequest.setNumberOfTimesMessagesAccessed(1);

        Messages messages = new MessagesMapper(messagesRequest).map();
        assertEquals(Integer.valueOf(1), messages.getNumberOfTimesMessagesAccessed());
    }

    @Test
    public void shouldJoinIndividualMessagesFlowDurationsDuringTheCall() {
        MessagesRequest messagesRequest = new MessagesRequest();
        messagesRequest.setIndividualMessagesAccessDurations(asList(1, 2));

        Messages messages = new MessagesMapper(messagesRequest).map();
        assertEquals("1, 2", messages.getIndividualMessagesAccessDurations());
    }

    @Test
    public void shouldMapTheTotalDurationOfAllMessageFlowsDuringTheCall() {
        MessagesRequest messagesRequest = new MessagesRequest();
        messagesRequest.setTotalMessagesAccessDuration(1L);

        Messages messages = new MessagesMapper(messagesRequest).map();
        assertEquals(Long.valueOf(1L), messages.getTotalMessagesAccessDuration());
    }
}
