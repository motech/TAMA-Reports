package org.motechproject.tama.reports.domain.json;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.NullNode;

public class TAMAJsonNode {

    private JsonNode node;

    public TAMAJsonNode(JsonNode node) {
        this.node = node;
    }

    public JsonNode get(String path) {
        Path pathToElement = new Path(path);
        JsonNode node = this.node;
        for (String component : pathToElement.components()) {
            node = node.get(component);
            if (node == null) {
                return NullNode.getInstance();
            }
        }
        return node;
    }

    public TAMAJsonNode get(String path, String value) {
        JsonNode node = get(path);
        if (node.asText().equals(value)) {
            return new TAMAJsonNode(node);
        } else {
            return new TAMAJsonNode(NullNode.getInstance());
        }
    }

    public boolean hasAllPairs(Pair... pairs) {
        boolean has = true;
        for (Pair pair : pairs) {
            has &= !get(pair.getKey(), pair.getValue()).isNull();
        }
        return has;
    }

    public TAMAJsonArrayNode getArrayNode(String path) {
        JsonNode node = get(path);
        if (node.isArray()) {
            return new TAMAJsonArrayNode((ArrayNode) node);
        } else {
            return new TAMAJsonArrayNode(new ArrayNode(JsonNodeFactory.instance));
        }
    }

    public boolean isNull() {
        return node.isNull();
    }
}
