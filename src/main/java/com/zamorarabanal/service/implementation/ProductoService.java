package com.zamorarabanal.service.implementation;

import com.zamorarabanal.model.Producto;
import com.zamorarabanal.repository.IGenericRepository;
import com.zamorarabanal.repository.IProductoRepository;
import com.zamorarabanal.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductoService extends GenericService<Producto, Integer> implements IProductoService {
    private final IProductoRepository repo;

    @Override
    protected IGenericRepository<Producto, Integer> getRepo(){
        return repo;
    }
}
