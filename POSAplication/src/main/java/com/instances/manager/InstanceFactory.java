package com.instances.manager;

import com.instances.manager.list.ListOfInstancesFactory;
import com.instances.manager.prototype.PrototypeFactory;
import com.instances.manager.singleton.SingletonFactory;

import java.util.List;

public class InstanceFactory {

    private static SingletonFactory singletonFactory = new SingletonFactory();
    private static PrototypeFactory prototypeFactory = new PrototypeFactory();
    private static ListOfInstancesFactory listOfInstancesFactory = new ListOfInstancesFactory();

    public CommonInterface getSingleton(Class classInstance){
        return singletonFactory.getSingleton(classInstance);
    }
    public CommonInterface getSingleton(String instanceName){
        return singletonFactory.getSingleton(instanceName);
    }
    public CommonInterface getPrototype(Class classInstance) {
        return prototypeFactory.getPrototype(classInstance);
    }
    public CommonInterface getPrototype(String instanceName) {
        return prototypeFactory.getPrototype(instanceName);
    }
    public List getListOfInstancesFactory(Class classInstance) {
        return listOfInstancesFactory.getListOfInstances(classInstance);
    }
}
