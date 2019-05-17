package com.instance.manager.list;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InstancesListFactoryImpl implements InstancesListFactory {

    @Override
    public List createInstances(Class instanceClass) {
        return Stream.of(instanceClass.getClasses()).map(it -> {
            try {
                return it.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
    }
}
