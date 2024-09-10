package com.example.caja.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OficinaDTO {
    private Integer idOficina;

    @NotNull
    @Size(min = 1, max = 60)
    private String descripcion;

    @NotNull
    private Integer tipooficina;

}
