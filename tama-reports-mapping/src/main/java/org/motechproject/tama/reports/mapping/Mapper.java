package org.motechproject.tama.reports.mapping;

import java.io.IOException;

public interface Mapper<Domain> {

    public Domain map() throws IOException;
}
