package com.application;

import com.intance.manager.InstanceFactory;
import com.intance.manager.list.ListOfInstancesImpl;
import com.service.email.EmailService;
import com.service.email.impl.EmailServiceImpl;


import java.util.List;

public class Application {

    public static void main(String[] args) {

        EmailService emailService = InstanceFactory.getSingleton(EmailServiceImpl.class);
        emailService.sendEmail("");

        ListOfInstancesImpl test = new ListOfInstancesImpl();
        List list = test.createInstances(EmailService.class);
        System.out.println(list.size());
        list.forEach(System.out::println);
    }

}
