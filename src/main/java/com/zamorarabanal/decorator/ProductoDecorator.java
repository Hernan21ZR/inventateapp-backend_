package com.zamorarabanal.decorator;

import com.zamorarabanal.controller.CategoriaController;
import com.zamorarabanal.controller.ProductoController;
import com.zamorarabanal.controller.ProveedorController;
import com.zamorarabanal.dto.ProductoDTO;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

public class ProductoDecorator {
    private final ProductoDTO dto;

    public ProductoDecorator(ProductoDTO dto) {
        this.dto = dto;
    }

    public EntityModel<ProductoDTO> withLinks() {
        EntityModel<ProductoDTO> model = EntityModel.of(dto);

        model.add(linkTo(methodOn(ProductoController.class).findById(dto.getIdProducto())).withSelfRel());
        model.add(linkTo(methodOn(ProductoController.class).findAll()).withRel("productos"));
        model.add(linkTo(methodOn(ProductoController.class).update(dto, dto.getIdProducto())).withRel("update"));
        model.add(linkTo(methodOn(ProductoController.class).delete(dto.getIdProducto())).withRel("delete"));
        model.add(linkTo(methodOn(CategoriaController.class).findById(dto.getIdCategoria())).withRel("categoria"));
        model.add(linkTo(methodOn(ProveedorController.class).findById(dto.getIdProveedor())).withRel("proveedor"));

        return model;
    }
}
