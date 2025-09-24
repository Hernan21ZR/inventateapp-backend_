package com.zamorarabanal.service;

import java.util.List;

public interface IGenericService<T, ID> {
    T save(T t);
    T update(T t, ID id);
    List<T> findAll();
    T findById(ID id);
    void delete(ID id);
}


