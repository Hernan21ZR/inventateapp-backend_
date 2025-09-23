package com.zamorarabanal.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class IngresoDTO {

    private int idIngreso;

    @NotNull
    private Date fecha;

    @NotNull
    @Size(min = 3, max = 70)
    private String tipoDocumento;

    @NotNull
    @Size(min = 3, max = 70)
    private String numeroDocumento;

    @NotNull
    @Size(min = 3, max = 150)
    private String observaciones;

    @NotNull
    private int idProveedor;
}
