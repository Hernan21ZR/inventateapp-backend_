package com.zamorarabanal.service.implementation;

import com.zamorarabanal.model.Categoria;
import com.zamorarabanal.model.Detalle_ingreso;
import com.zamorarabanal.repository.ICategoriaRepository;
import com.zamorarabanal.repository.IDetalleIngresoRepository;
import com.zamorarabanal.repository.IGenericRepository;
import com.zamorarabanal.service.ICategoriaService;
import com.zamorarabanal.service.IDetalleIngresoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetalleIngresoService extends GenericService<Detalle_ingreso, Integer> implements IDetalleIngresoService {
    private final IDetalleIngresoRepository repo;

    @Override
    protected IGenericRepository<Detalle_ingreso, Integer> getRepo(){
        return repo;
    }
}
