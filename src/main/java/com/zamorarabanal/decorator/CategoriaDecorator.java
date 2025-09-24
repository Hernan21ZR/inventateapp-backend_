package com.zamorarabanal.decorator;

import com.zamorarabanal.controller.CategoriaController;
import com.zamorarabanal.dto.CategoriaDTO;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

public class CategoriaDecorator {

    private final CategoriaDTO dto;

    public CategoriaDecorator(CategoriaDTO dto) {
        this.dto = dto;
    }

    public EntityModel<CategoriaDTO> withLinks() {
        EntityModel<CategoriaDTO> model = EntityModel.of(dto);

        model.add(linkTo(methodOn(CategoriaController.class).findById(dto.getIdCategoria())).withSelfRel());
        model.add(linkTo(methodOn(CategoriaController.class).findAll()).withRel("categorias"));
        model.add(linkTo(methodOn(CategoriaController.class).update(dto, dto.getIdCategoria())).withRel("update"));
        model.add(linkTo(methodOn(CategoriaController.class).delete(dto.getIdCategoria())).withRel("delete"));

        return model;
    }
}
