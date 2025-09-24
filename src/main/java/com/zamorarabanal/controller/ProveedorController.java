package com.zamorarabanal.controller;

import com.zamorarabanal.decorator.ProveedorDecorator;
import com.zamorarabanal.dto.ProveedorDTO;
import com.zamorarabanal.exception.CustomSuccessRecord;
import com.zamorarabanal.factory.ProveedorFactory;
import com.zamorarabanal.model.Proveedor;
import com.zamorarabanal.service.IProveedorService;
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
@RequestMapping("/proveedores")
@RequiredArgsConstructor
public class ProveedorController {

    private final IProveedorService service;

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<ProveedorDTO>>> findAll() {
        List<EntityModel<ProveedorDTO>> proveedores = service.findAll()
                .stream()
                .map(ProveedorFactory::createDTO)
                .map(dto -> new ProveedorDecorator(dto).withLinks())
                .toList();

        CollectionModel<EntityModel<ProveedorDTO>> collection =
                CollectionModel.of(proveedores,
                        linkTo(methodOn(ProveedorController.class).findAll()).withSelfRel()
                );

        return ResponseEntity.ok(collection);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ProveedorDTO>> findById(@PathVariable("id") Integer id) {
        Proveedor obj = service.findById(id);
        ProveedorDTO dto = ProveedorFactory.createDTO(obj);

        return ResponseEntity.ok(new ProveedorDecorator(dto).withLinks());
    }

    @PostMapping
    public ResponseEntity<EntityModel<ProveedorDTO>> save(@Valid @RequestBody ProveedorDTO dto) {
        Proveedor obj = service.save(ProveedorFactory.createEntity(dto));
        ProveedorDTO savedDto = ProveedorFactory.createDTO(obj);

        return ResponseEntity.created(
                linkTo(methodOn(ProveedorController.class).findById(savedDto.getIdProveedor())).toUri()
        ).body(new ProveedorDecorator(savedDto).withLinks());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomSuccessRecord> update(@Valid @RequestBody ProveedorDTO dto, @PathVariable("id") Integer id) {
        Proveedor obj = service.update(ProveedorFactory.createEntity(dto), id);

        return ResponseEntity.ok(new CustomSuccessRecord(
                LocalDateTime.now(),
                "Actualizado correctamente",
                "Proveedor con ID " + id + " actualizado correctamente"
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomSuccessRecord> delete(@PathVariable("id") Integer id) {
        service.delete(id);

        return ResponseEntity.ok(new CustomSuccessRecord(
                LocalDateTime.now(),
                "Eliminado correctamente",
                "Proveedor con ID " + id + " eliminado correctamente"
        ));
    }

}
