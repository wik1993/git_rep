package com.intance.manager.prototype;

import com.application.TestClass1;

public class PrototypeFactory {

    private TestClass1 testClass1;

    @SuppressWarnings("unchecked")
    public <T> T createInstance(String instanceName) {
        try {
            if ("blabla1".equals(instanceName)) {
                testClass1 = new TestClass1();
            }
            return (T) testClass1;
        } catch (Exception e) {
            throw new RuntimeException(e);
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
