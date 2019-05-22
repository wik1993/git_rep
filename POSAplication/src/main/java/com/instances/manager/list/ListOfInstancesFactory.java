package com.instances.manager.list;

import com.instances.manager.CommonInterface;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListOfInstancesFactory {
    private Logger logger = Logger.getLogger(ListOfInstancesFactory.class);
    private CommonInterface instance;

    public List getListOfInstances (Class instanceClass){
        return Stream.of(instanceClass.getClasses()).map(it -> {
            try {
                instance = (CommonInterface) it.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                logger.error("Cannot instantiate the object", e);
            }
            return instance;
        }).collect(Collectors.toList());
    }
}
