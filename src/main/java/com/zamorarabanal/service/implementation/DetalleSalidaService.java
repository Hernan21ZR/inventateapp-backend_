package com.zamorarabanal.service.implementation;

import com.zamorarabanal.model.Detalle_ingreso;
import com.zamorarabanal.model.Detalle_salida;
import com.zamorarabanal.repository.IDetalleIngresoRepository;
import com.zamorarabanal.repository.IDetalleSalidaRepository;
import com.zamorarabanal.repository.IGenericRepository;
import com.zamorarabanal.service.IDetalleIngresoService;
import com.zamorarabanal.service.IDetalleSalidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetalleSalidaService extends GenericService<Detalle_salida, Integer> implements IDetalleSalidaService {
    private final IDetalleSalidaRepository repo;

    @Override
    protected IGenericRepository<Detalle_salida, Integer> getRepo(){
        return repo;
    }
}
