package com.instances.manager.prototype;

import com.instances.manager.CommonInterface;
import com.instances.manager.Test;
import com.instances.manager.singleton.SingletonFactory;
import org.apache.log4j.Logger;

public class PrototypeFactory {

    private Logger logger = Logger.getLogger(SingletonFactory.class);

    public CommonInterface getPrototype(String instanceName) {
        if (instanceName.equals("test")) {
            return new Test();
        }
        return null;
    }

    public CommonInterface getPrototype(Class instanceClass) {
        CommonInterface result = null;
        try {
            result = (CommonInterface) instanceClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            logger.error("Can't instantiate the object", e);
        }
        return result;
    }
}
