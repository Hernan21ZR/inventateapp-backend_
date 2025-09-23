package com.zamorarabanal.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SalidaDTO {

    private int idSalida;

    @NotNull
    private Date fecha;

    @NotNull
    @Size(min = 3, max = 50)
    private String tipoSalida;

    @NotNull
    @Size(min = 3, max = 50)
    private String destino;

    @NotNull
    @Size(min = 3, max = 150)
    private String observaciones;
}
