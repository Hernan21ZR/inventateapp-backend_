package com.zamorarabanal.service.implementation;

import com.zamorarabanal.model.Ingreso;
import com.zamorarabanal.model.Salida;
import com.zamorarabanal.repository.IGenericRepository;
import com.zamorarabanal.repository.IIngresoRepository;
import com.zamorarabanal.repository.ISalidaRepository;
import com.zamorarabanal.service.ICategoriaService;
import com.zamorarabanal.service.IIngresoService;
import com.zamorarabanal.service.ISalidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalidaService extends GenericService<Salida, Integer> implements ISalidaService {
    private final ISalidaRepository repo;

    @Override
    protected IGenericRepository<Salida, Integer> getRepo(){
        return repo;
    }
}
