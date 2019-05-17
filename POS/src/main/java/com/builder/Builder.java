package com.builder;

public interface Builder<R,T> {
     R build(T input);
     R build ();
}
