package org.motechproject.tama.reports.mapping;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GeneralHistoryMapperTest {

    @Test
    public void shouldSetHistoryOfDrugAllergy() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        assertEquals("N", new GeneralHistoryMapper(mapper.readTree("{\"specifiedAllergies\" : []}")).map().getHistoryOfDrugAllergy());
    }

    @Test
    public void shouldSetHistoryOfRashes() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        assertEquals("N", new GeneralHistoryMapper(mapper.readTree("{\"rashes\" : []}")).map().getHistoryOfRash());
    }
}
