package com.zamorarabanal.service.implementation;

import com.zamorarabanal.model.Proveedor;
import com.zamorarabanal.repository.IGenericRepository;
import com.zamorarabanal.repository.IProductoRepository;
import com.zamorarabanal.repository.IProveedorRepository;
import com.zamorarabanal.service.IProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProveedorService extends GenericService<Proveedor, Integer> implements IProveedorService {
    private final IProveedorRepository repo;

    @Override
    protected IGenericRepository<Proveedor, Integer> getRepo(){
        return repo;
    }
}
