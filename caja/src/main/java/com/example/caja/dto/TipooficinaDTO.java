package com.example.caja.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipooficinaDTO {
    private Integer idTipooficina;

    @NotNull
    private String descripcion;
}
