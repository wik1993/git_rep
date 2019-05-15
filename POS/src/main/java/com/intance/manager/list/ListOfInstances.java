package com.intance.manager.list;

import java.util.List;

public interface ListOfInstances {
   <T> List<T> createInstances(Class<T> instanceClass);
}
