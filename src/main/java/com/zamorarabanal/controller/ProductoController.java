package com.zamorarabanal.controller;

import com.zamorarabanal.decorator.ProductoDecorator;
import com.zamorarabanal.dto.ProductoDTO;
import com.zamorarabanal.exception.CustomSuccessRecord;
import com.zamorarabanal.factory.ProductoFactory;
import com.zamorarabanal.model.Producto;
import com.zamorarabanal.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final IProductoService service;

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<ProductoDTO>>> findAll() {
        List<EntityModel<ProductoDTO>> productos = service.findAll()
                .stream()
                .map(ProductoFactory::createDTO)
                .map(dto -> new ProductoDecorator(dto).withLinks())
                .toList();

        CollectionModel<EntityModel<ProductoDTO>> collection =
                CollectionModel.of(productos,
                        linkTo(methodOn(ProductoController.class).findAll()).withSelfRel()
                );

        return ResponseEntity.ok(collection);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ProductoDTO>> findById(@PathVariable("id") Integer id) {
        Producto obj = service.findById(id);
        ProductoDTO dto = ProductoFactory.createDTO(obj);

        return ResponseEntity.ok(new ProductoDecorator(dto).withLinks());
    }

    @PostMapping
    public ResponseEntity<EntityModel<ProductoDTO>> save(@Valid @RequestBody ProductoDTO dto) {
        Producto obj = service.save(ProductoFactory.createEntity(dto));
        ProductoDTO savedDto = ProductoFactory.createDTO(obj);

        return ResponseEntity.created(
                linkTo(methodOn(ProductoController.class).findById(savedDto.getIdProducto())).toUri()
        ).body(new ProductoDecorator(savedDto).withLinks());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomSuccessRecord> update(@Valid @RequestBody ProductoDTO dto, @PathVariable("id") Integer id) {
        Producto obj = service.update(ProductoFactory.createEntity(dto), id);

        return ResponseEntity.ok(new CustomSuccessRecord(
                LocalDateTime.now(),
                "Actualizado correctamente",
                "Producto con ID " + id + " actualizado correctamente"
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomSuccessRecord> delete(@PathVariable("id") Integer id) {
        service.delete(id);

        return ResponseEntity.ok(new CustomSuccessRecord(
                LocalDateTime.now(),
                "Eliminado correctamente",
                "Producto con ID " + id + " eliminado correctamente"
        ));
    }

}