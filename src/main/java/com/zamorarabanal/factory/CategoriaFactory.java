package com.zamorarabanal.factory;

import com.zamorarabanal.dto.CategoriaDTO;
import com.zamorarabanal.model.Categoria;

public class CategoriaFactory {

    public static CategoriaDTO createDTO(Categoria categoria) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setIdCategoria(categoria.getId_categoria());
        dto.setNombre(categoria.getNombre());
        dto.setDescripcion(categoria.getDescripcion());
        return dto;
    }

    public static Categoria createEntity(CategoriaDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setId_categoria(dto.getIdCategoria());
        categoria.setNombre(dto.getNombre());
        categoria.setDescripcion(dto.getDescripcion());
        return categoria;
    }
}
