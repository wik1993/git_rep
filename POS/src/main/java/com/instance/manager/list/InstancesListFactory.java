package com.instance.manager.list;

import java.util.List;

public interface InstancesListFactory<T> {
   List<T> createInstances(Class<T> instanceClass);
}
