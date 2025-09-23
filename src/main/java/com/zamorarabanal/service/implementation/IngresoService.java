package com.zamorarabanal.service.implementation;

import com.zamorarabanal.model.Categoria;
import com.zamorarabanal.model.Ingreso;
import com.zamorarabanal.repository.ICategoriaRepository;
import com.zamorarabanal.repository.IGenericRepository;
import com.zamorarabanal.repository.IIngresoRepository;
import com.zamorarabanal.service.ICategoriaService;
import com.zamorarabanal.service.IIngresoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IngresoService extends GenericService<Ingreso, Integer> implements IIngresoService {
    private final IIngresoRepository repo;

    @Override
    protected IGenericRepository<Ingreso, Integer> getRepo(){
        return repo;
    }
}
