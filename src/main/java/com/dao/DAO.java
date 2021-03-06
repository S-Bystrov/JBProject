package com.dao;

public interface DAO<T> {

    void save(T t);
    void update(T t);
    void delete(T t);
}
