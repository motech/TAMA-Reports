package org.motechproject.tama.reports.mapping;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class RequestMapper<Source, Destination> implements BeanMapper<Source, Destination> {

    @Override
    public Destination map(Source source, Class<Destination> destinationClass) {
        try {
            Destination destination = destinationClass.newInstance();
            BeanUtils.copyProperties(source, destination);
            return destination;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Destination map(Source source, Class<Destination> destinationClass, String[] ignoreFields) {
        try {
            Destination destination = destinationClass.newInstance();
            BeanUtils.copyProperties(source, destination, ignoreFields);
            return destination;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Destination> map(List<Source> sources, Class<Destination> destinationClass, String[] ignoreFields) {
        List<Destination> result = new ArrayList<>();
        for (Source source : sources) {
            result.add(map(source, destinationClass, ignoreFields));
        }
        return result;
    }
}
