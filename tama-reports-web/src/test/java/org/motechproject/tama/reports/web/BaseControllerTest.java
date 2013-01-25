package org.motechproject.tama.reports.web;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class BaseControllerTest {

    protected String getJSON(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writer().writeValueAsString(object);
    }
}
