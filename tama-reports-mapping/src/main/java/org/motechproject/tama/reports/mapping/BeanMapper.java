package org.motechproject.tama.reports.mapping;

import java.io.IOException;
import java.util.List;

public interface BeanMapper<Request, Domain> {

    public Domain map(Request source, Class<Domain> destinationClass) throws IOException;

    public Domain map(Request source, Class<Domain> destinationClass, String[] ignoreFields) throws IOException;

    public List<Domain> map(List<Request> sources, Class<Domain> destinationClass, String[] ignoreFields) throws IOException;

}
