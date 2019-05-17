package com.jpa.service;

public interface JPAService<T> {

    void create(T domain);

    T get(Integer id);

    void update(T domain);

    void delete(T domain);

}
