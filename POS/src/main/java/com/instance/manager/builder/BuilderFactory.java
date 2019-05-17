package com.instance.manager.builder;

import com.builder.Builder;
import com.builder.Test;

public class BuilderFactory {

    public Builder getBuilder(String builderName){
        if("dataTable".equals(builderName)){
            return new Test();
        } else {
            throw new RuntimeException("Can't build the Instance");
        }
    }
}
