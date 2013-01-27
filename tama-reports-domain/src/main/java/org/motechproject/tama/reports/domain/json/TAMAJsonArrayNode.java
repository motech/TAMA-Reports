package org.motechproject.tama.reports.domain.json;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.NullNode;

public class TAMAJsonArrayNode {

    private ArrayNode node;

    public TAMAJsonArrayNode(ArrayNode node) {
        this.node = node;
    }

    public TAMAJsonNode find(Pair... pairs) {
        for (JsonNode element : node) {
            TAMAJsonNode jsonNode = new TAMAJsonNode(element);
            if (jsonNode.hasAllPairs(pairs)) {
                return jsonNode;
            }
        }
        return new TAMAJsonNode(NullNode.getInstance());
    }

    public boolean contains(String value) {
        for (JsonNode element : node) {
            if (element.isTextual() && element.asText().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(Pair... pairs) {
        return !find(pairs).isNull();
    }

    public boolean isNotEmpty() {
        return node.size() > 0;
    }

    public boolean isArray() {
        return node.isArray();
    }
}
