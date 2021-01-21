package com.example.english.services;

public interface GenericService<T, P> {
    void createOrUpdate(T entity);

}