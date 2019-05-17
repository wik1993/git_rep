package com.instance.manager;


import com.builder.Builder;
import com.instance.manager.builder.BuilderFactory;
import com.instance.manager.jpa.JPAServiceFactory;
import com.instance.manager.list.InstancesListFactoryImpl;
import com.instance.manager.prototype.PrototypeFactory;
import com.instance.manager.singleton.SingletonFactory;
import com.jpa.service.JPAService;

import java.util.List;

public class InstanceFactory {

    private static SingletonFactory singletonFactory = new SingletonFactory();
    private static PrototypeFactory prototypeFactory = new PrototypeFactory();
    private static InstancesListFactoryImpl listOfInstances = new InstancesListFactoryImpl();
    private static BuilderFactory builderFactory = new BuilderFactory();
    private static JPAServiceFactory jpaServiceFactory = new JPAServiceFactory();


    public static <T> T getSingleton(String instanceName) {
        return singletonFactory.getSingleton(instanceName);
    }

    public static <T> T getSingleton(Class instanceClass) {
        return singletonFactory.getSingleton(instanceClass);
    }

    public static <T> List createInstances(Class<T> instanceClass) { return listOfInstances.createInstances(instanceClass);}

    public static  <T> T getPrototype(String instanceName) {return  prototypeFactory.createInstance(instanceName); }
    @SuppressWarnings("unchecked")
    public static  <T> T getPrototype(Class instanceClass) {return (T) prototypeFactory.createInstance(instanceClass); }

    public static Builder createBuilder(String builderName) { return builderFactory.getBuilder(builderName); }

    public static JPAService getJPAService(Class instanceClass) {return  jpaServiceFactory.getJPASingleton(instanceClass);}

}
