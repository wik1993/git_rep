package com.intance.manager.list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListOfInstancesImpl implements ListOfInstances {

    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> createInstances(Class<T> instanceClass) {

        return Stream.of(instanceClass.getClasses()).map(it -> {
            try {
                return (T) it.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());

/*
        List<T> listOfInstances = new ArrayList<>();

        Class[] classes = instanceClass.getClasses();
        for (int i = 0; i < classes.length; i++) {
            try {
                listOfInstances.add((T) classes[i].newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
         return listOfInstances;
*/

    }
}
