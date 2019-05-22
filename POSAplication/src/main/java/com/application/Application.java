package com.application;


import com.instances.manager.CommonInterface;
import com.instances.manager.InstanceFactory;
import com.instances.manager.Test;
import org.apache.log4j.BasicConfigurator;

import java.util.List;


public class Application {

    public static void main(String[] args) {
        BasicConfigurator.configure();

        InstanceFactory instanceFactory = new InstanceFactory();
        Test test = (Test) instanceFactory.getSingleton(Test.class);
        test.getCall();
        Test test1 = (Test) instanceFactory.getSingleton("test");
        //test1.getCall();
        Test test2 = (Test) instanceFactory.getPrototype(Test.class);
        test.getCall();
        List list = instanceFactory.getListOfInstancesFactory(CommonInterface.class);

    }
}
