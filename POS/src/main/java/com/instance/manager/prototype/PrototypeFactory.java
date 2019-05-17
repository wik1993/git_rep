package com.instance.manager.prototype;

import com.application.TestClass1;
import com.application.TestClass2;

public class PrototypeFactory {

    @SuppressWarnings("unchecked")
    public <T> T createInstance(String instanceName) {
        if ("balbla1".equals(instanceName)) {
            return (T) new TestClass1();
        } else if ("blabla2".equals(instanceName)) {
            return (T) new TestClass2();
        } else {
            throw new RuntimeException("no such instance declared");
        }
    }

    public <T> T createInstance(Class<T> instance) {
        try {
            // here will be adapter that will perform setting of object references
            return instance.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
