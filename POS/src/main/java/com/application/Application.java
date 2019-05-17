package com.application;

import com.instance.manager.jpa.JPAServiceFactory;
import com.jpa.domain.Item;
import com.jpa.service.JPAService;
import com.jpa.service.impl.ItemJPAServiceImpl;

public class Application {

    public static void main(String[] args) {


        JPAServiceFactory jpaFactory = new JPAServiceFactory();
        ItemJPAServiceImpl itemJPAService = (ItemJPAServiceImpl) jpaFactory.getJPASingleton(Item.class);
        itemJPAService.create(new Item());


    }

}
