package com.zamorarabanal.decorator;

import com.zamorarabanal.controller.ProveedorController;
import com.zamorarabanal.dto.ProveedorDTO;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

public class ProveedorDecorator {

    private final ProveedorDTO dto;

    public ProveedorDecorator(ProveedorDTO dto) {
        this.dto = dto;
    }

    public EntityModel<ProveedorDTO> withLinks() {
        EntityModel<ProveedorDTO> model = EntityModel.of(dto);

        model.add(linkTo(methodOn(ProveedorController.class).findById(dto.getIdProveedor())).withSelfRel());
        model.add(linkTo(methodOn(ProveedorController.class).findAll()).withRel("proveedores"));
        model.add(linkTo(methodOn(ProveedorController.class).update(dto, dto.getIdProveedor())).withRel("update"));
        model.add(linkTo(methodOn(ProveedorController.class).delete(dto.getIdProveedor())).withRel("delete"));

        return model;
    }
}
