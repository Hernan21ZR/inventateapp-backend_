package com.zamorarabanal.service.implementation;

import com.zamorarabanal.exception.ModelNotFoundException;
import com.zamorarabanal.repository.IGenericRepository;
import com.zamorarabanal.service.IGenericService;

import java.util.List;

public abstract class GenericService<T, ID> implements IGenericService<T, ID> {

    protected abstract IGenericRepository<T, ID> getRepo();

    @Override
    public T save(T t) {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) {
        getRepo().findById(id)
                .orElseThrow(() -> new ModelNotFoundException("ID " + id + " no encontrado"));
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) {
        return getRepo().findById(id)
                .orElseThrow(() -> new ModelNotFoundException("ID " + id + " no encontrado"));
    }

    @Override
    public void delete(ID id) {
        getRepo().findById(id)
                .orElseThrow(() -> new ModelNotFoundException("ID  " + id + " no encontrado"));
        getRepo().deleteById(id);
    }
}

