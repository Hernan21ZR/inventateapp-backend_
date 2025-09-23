package com.zamorarabanal.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DetalleSalidaDTO {

    private int idDetalleS;

    @NotNull
    @Min(1)
    private int cantidad;

    @NotNull
    @Positive
    private double precioUnitario;

    @NotNull
    private int idSalida;

    @NotNull
    private int idProducto;
}
