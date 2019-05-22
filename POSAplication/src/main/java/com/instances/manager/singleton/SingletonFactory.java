package com.instances.manager.singleton;

import com.instances.manager.CommonInterface;
import com.instances.manager.Test;
import org.apache.log4j.Logger;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SingletonFactory {
    private Logger logger = Logger.getLogger(SingletonFactory.class);

    private static final Map<Class, CommonInterface> classCash = new HashMap<>();
    private static final Map<String, CommonInterface> stringCash = new HashMap<>();

    public CommonInterface getSingleton(String instanceName) {
        return Optional.ofNullable(stringCash.get(instanceName)).orElse(createInstance(instanceName));
    }

    private CommonInterface createInstance(String instanceName) {
        if (instanceName.equals("test")) {
            Test test = new Test();
            stringCash.put(instanceName, test);
            logger.info("Object added to Map");
            return test;
        }
        return null;
    }

    public CommonInterface getSingleton(Class instanceClass) {
        return Optional.ofNullable(classCash.get(instanceClass)).orElse(createInstance(instanceClass));
    }

    private CommonInterface createInstance(Class instanceClass) {
        CommonInterface result = null;
        try {
            result = (CommonInterface) instanceClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            logger.error("Can't instantiate the object");
        }
        classCash.put(instanceClass, result);
        return result;
    }
}
