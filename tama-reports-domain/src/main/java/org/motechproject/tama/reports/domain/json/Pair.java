package org.motechproject.tama.reports.domain.json;

import lombok.Data;

@Data
public class Pair {

    private String key;
    private String value;

    public static Pair pair(String key, String value) {
        Pair pair = new Pair();
        pair.key = key;
        pair.value = value;
        return pair;
    }
}
