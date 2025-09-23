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
public class Ingreso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id_ingreso;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false, length = 70)
    private String tipo_documento;

    @Column(nullable = false, length = 70)
    private String numero_documento;

    @Column(nullable = false, length = 150)
    private String observaciones;

    @ManyToOne// FK
    @JoinColumn(name = "id_proveedor", nullable = false, foreignKey = @ForeignKey(name = "FK_INGRESO_PROVEEDOR"))
    private Proveedor proveedor;
}
