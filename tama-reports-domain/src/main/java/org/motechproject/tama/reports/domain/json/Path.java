package org.motechproject.tama.reports.domain.json;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.apache.commons.lang.StringUtils.isNotBlank;

public class Path {

    private String path;

    public Path(String path) {
        this.path = path;
    }

    public List<String> components() {
        return (isNotBlank(path)) ? asList(path.replaceAll("[.]", ":").split(":")) : Collections.<String>emptyList();
    }
}
