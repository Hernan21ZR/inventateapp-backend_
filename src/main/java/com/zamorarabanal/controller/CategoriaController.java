package com.zamorarabanal.controller;

import com.zamorarabanal.decorator.CategoriaDecorator;
import com.zamorarabanal.dto.CategoriaDTO;
import com.zamorarabanal.exception.CustomSuccessRecord;
import com.zamorarabanal.factory.CategoriaFactory;
import com.zamorarabanal.model.Categoria;
import com.zamorarabanal.service.ICategoriaService;
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
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final ICategoriaService service;

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<CategoriaDTO>>> findAll() {
        List<EntityModel<CategoriaDTO>> categorias = service.findAll()
                .stream()
                .map(CategoriaFactory::createDTO)
                .map(dto -> new CategoriaDecorator(dto).withLinks())
                .toList();

        CollectionModel<EntityModel<CategoriaDTO>> collection =
                CollectionModel.of(categorias,
                        linkTo(methodOn(CategoriaController.class).findAll()).withSelfRel()
                );

        return ResponseEntity.ok(collection);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<CategoriaDTO>> findById(@PathVariable("id") Integer id) {
        Categoria obj = service.findById(id);
        CategoriaDTO dto = CategoriaFactory.createDTO(obj);

        return ResponseEntity.ok(new CategoriaDecorator(dto).withLinks());
    }

    @PostMapping
    public ResponseEntity<EntityModel<CategoriaDTO>> save(@Valid @RequestBody CategoriaDTO dto) {
        Categoria obj = service.save(CategoriaFactory.createEntity(dto));
        CategoriaDTO savedDto = CategoriaFactory.createDTO(obj);

        return ResponseEntity.created(
                linkTo(methodOn(CategoriaController.class).findById(savedDto.getIdCategoria())).toUri()
        ).body(new CategoriaDecorator(savedDto).withLinks());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomSuccessRecord> update(@Valid @RequestBody CategoriaDTO dto, @PathVariable("id") Integer id) {
        Categoria obj = service.update(CategoriaFactory.createEntity(dto), id);

        return ResponseEntity.ok(new CustomSuccessRecord(
                LocalDateTime.now(),
                "Actualizado correctamente",
                "Categoría con ID " + id + " actualizada correctamente"
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomSuccessRecord> delete(@PathVariable("id") Integer id) {
        service.delete(id);

        return ResponseEntity.ok(new CustomSuccessRecord(
                LocalDateTime.now(),
                "Eliminado correctamente",
                "Categoría con ID " + id + " eliminada correctamente"
        ));
    }

}
