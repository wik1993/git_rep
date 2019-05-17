package com.instance.manager.jpa;

import com.jpa.domain.Item;
import com.jpa.service.JPAService;
import com.jpa.service.impl.ItemJPAServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JPAServiceFactory {

    private static final Map<Class, JPAService> instanceClassCash = new HashMap<>();

    @SuppressWarnings("unchecked")
    public JPAService getJPASingleton(Class domain) {
        return Optional.ofNullable(instanceClassCash.get(domain)).orElse(createInstance(domain));
    }

    private JPAService createInstance(Class instance) {
        try {
            if(instance.equals(Item.class)){
                JPAService result = new ItemJPAServiceImpl();
                instanceClassCash.put(instance, result);
                return result;
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
