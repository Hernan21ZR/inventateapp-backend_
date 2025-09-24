package com.zamorarabanal.factory;

import com.zamorarabanal.dto.ProveedorDTO;
import com.zamorarabanal.model.Proveedor;

public class ProveedorFactory {

    public static ProveedorDTO createDTO(Proveedor proveedor) {
        ProveedorDTO dto = new ProveedorDTO();
        dto.setIdProveedor(proveedor.getId_proveedor());
        dto.setNombre(proveedor.getNombre());
        dto.setRuc(proveedor.getRuc());
        dto.setDireccion(proveedor.getDireccion());
        dto.setTelefono(proveedor.getTelefono());
        return dto;
    }

    public static Proveedor createEntity(ProveedorDTO dto) {
        Proveedor proveedor = new Proveedor();
        proveedor.setId_proveedor(dto.getIdProveedor());
        proveedor.setNombre(dto.getNombre());
        proveedor.setRuc(dto.getRuc());
        proveedor.setDireccion(dto.getDireccion());
        proveedor.setTelefono(dto.getTelefono());
        proveedor.setCorreo(dto.getCorreo());
        return proveedor;
    }
}
