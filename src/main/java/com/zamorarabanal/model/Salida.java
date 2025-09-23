package com.zamorarabanal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Salida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id_salida;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false, length = 50)
    private String tipo_salida;

    @Column(nullable = false, length = 50)
    private String destino;

    @Column(nullable = false, length = 150)
    private String observaciones;
}
