package com.intance.manager;


import com.intance.manager.prototype.PrototypeFactory;
import com.intance.manager.singleton.SingletonFactory;

public class InstanceFactory {

    private static final SingletonFactory singletonFactory = new SingletonFactory();
    private  PrototypeFactory prototypeFactory = new PrototypeFactory();


    public static <T> T getSingleton(String instanceName) {
        return singletonFactory.getSingleton(instanceName);
    }

    public static <T> T getSingleton(Class instanceClass) {
        return singletonFactory.getSingleton(instanceClass);
    }

    public  <T> T getPrototype(String instanceName) {return  prototypeFactory.createInstance(instanceName); }

    @SuppressWarnings("unchecked")
    public  <T> T getPrototype(Class instanceClass) {return (T) prototypeFactory.createInstance(instanceClass); }

}
