package com.zamorarabanal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Detalle_ingreso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id_detalleI;

    @Column(nullable = false, length = 150)
    private int cantidad;

    @Column(nullable = false, length = 150)
    private double precio_unitario;

    @ManyToOne// FK
    @JoinColumn(name = "id_ingreso", nullable = false, foreignKey = @ForeignKey(name = "FK_DETALLE_INGRESO_INGRESO"))
    private Ingreso ingreso;

    @ManyToOne// FK
    @JoinColumn(name = "id_proveedor", nullable = false, foreignKey = @ForeignKey(name = "FK_DETALLE_INGRESO_PRODUCTO"))
    private Producto producto;
}
