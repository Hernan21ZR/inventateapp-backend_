package com.zamorarabanal.service.implementation;

import com.zamorarabanal.model.Categoria;
import com.zamorarabanal.model.Producto;
import com.zamorarabanal.repository.ICategoriaRepository;
import com.zamorarabanal.repository.IGenericRepository;
import com.zamorarabanal.repository.IProductoRepository;
import com.zamorarabanal.service.ICategoriaService;
import com.zamorarabanal.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoriaService extends GenericService<Categoria, Integer> implements ICategoriaService {
    private final ICategoriaRepository repo;

    @Override
    protected IGenericRepository<Categoria, Integer> getRepo(){
        return repo;
    }
}
