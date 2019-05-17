package com.instance.manager.singleton;

import com.application.TestClass1;
import com.application.TestClass2;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SingletonFactory {

    private TestClass1 testClass1;

    private static final Map<Class, Object> instanceClassCash = new HashMap<>();
    private static final Map<String, Object> instanceNameCash = new HashMap<>();

    @SuppressWarnings("unchecked")
    public <T> T getSingleton(String instanceName) {
        return (T) Optional.ofNullable(instanceNameCash.get(instanceName)).orElse(createInstance(instanceName));
    }

    @SuppressWarnings("unchecked")
    private <T> T createInstance(String instanceName) {
        try {
            if ("blabla1".equals(instanceName)) {
                testClass1 =  new TestClass1();
                instanceNameCash.put(instanceName, testClass1);
            }
            return (T) testClass1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T getSingleton(Class instanceClass) {
        return (T) Optional.ofNullable(instanceClassCash.get(instanceClass)).orElse(createInstance(instanceClass));
    }

    private <T> T createInstance(Class<T> instance) {
        try {
            T result = instance.newInstance();
            // here will be adapter that will perform setting of object references
            instanceClassCash.put(instance, result);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
