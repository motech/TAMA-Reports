package org.motechproject.tama.reports.domain.json;


import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.motechproject.tama.reports.domain.json.Pair.pair;

public class TAMAJsonNodeTest {

    private ObjectMapper mapper;

    @Before
    public void setup() {
        mapper = new ObjectMapper();
    }

    @Test
    public void shouldReturnJsonNode() throws IOException {
        JsonNode node = mapper.readTree("{\"key\" : \"value\"}");
        assertFalse(new TAMAJsonNode(node).get("key").isNull());
    }

    @Test
    public void shouldReturnNestedJsonNode() throws IOException {
        JsonNode node = mapper.readTree("{\"key\" : {\"innerKey\" : \"innerValue\"}}");
        assertFalse(new TAMAJsonNode(node).get("key.innerKey").isNull());
    }

    @Test
    public void shouldReturnNullWhenTopNodeNotFound() throws IOException {
        JsonNode node = mapper.readTree("{\"key\" : \"value\"}");
        assertTrue(new TAMAJsonNode(node).get("invalidKey").isNull());
    }

    @Test
    public void shouldReturnNullWhenPathToInnerNodeNotFound() throws IOException {
        JsonNode node = mapper.readTree("{\"key\" : {\"innerKey\" : \"innerValue\"}}");
        assertTrue(new TAMAJsonNode(node).get("invalidKey.innerKey").isNull());
    }

    @Test
    public void shouldReturnArrayAsNode() throws IOException {
        JsonNode node = mapper.readTree("{\"key\" : {\"innerKey\" : [\"innerValue\"]}}");
        assertTrue(new TAMAJsonNode(node).get("key.innerKey").isArray());
    }

    @Test
    public void shouldReturnArrayNode() throws IOException {
        JsonNode node = mapper.readTree("{\"key\" : {\"innerKey\" : [\"innerValue\"]}}");
        assertTrue(new TAMAJsonNode(node).getArrayNode("key.innerKey").isArray());
    }

    @Test
    public void shouldReturnEmptyArrayNodeWhenGettingValidNonArrayNode() throws IOException {
        JsonNode node = mapper.readTree("{\"key\" : {\"innerKey\" : [\"innerValue\"]}}");
        assertFalse(new TAMAJsonNode(node).getArrayNode("key").isNotEmpty());
    }

    @Test
    public void shouldReturnEmptyArrayNodeWhenGettingInvalidNode() throws IOException {
        JsonNode node = mapper.readTree("{\"key\" : {\"innerKey\" : [\"innerValue\"]}}");
        assertFalse(new TAMAJsonNode(node).getArrayNode("invalidKey").isNotEmpty());
    }

    @Test
    public void shouldReturnTrueWhenNodeHasAllPairs() throws IOException {
        JsonNode node = mapper.readTree("{\"key\" : \"value\", \"anotherKey\" : true}");
        assertTrue(new TAMAJsonNode(node).hasAllPairs(pair("key", "value"), pair("anotherKey", "true")));
    }

    @Test
    public void shouldReturnFalseWhenNodeDoesNotHaveAllPairs() throws IOException {
        JsonNode node = mapper.readTree("{\"key\" : \"value\", \"anotherKey\" : \"value\"}");
        assertFalse(new TAMAJsonNode(node).hasAllPairs(pair("key", "value"), pair("anotherKey", "anotherValue")));
    }
}
