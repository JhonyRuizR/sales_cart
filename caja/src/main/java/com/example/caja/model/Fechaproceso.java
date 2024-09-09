package com.example.caja.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_fechaproceso")
public class Fechaproceso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idFechaproceso;

    private LocalTime fPrevista;

    private LocalTime fReal;

    private Integer diferenciaDias;

    private Integer aplica;

    @ManyToOne
    @JoinColumn(name = "id_procesoadp",foreignKey = @ForeignKey(name = "FK_FECHA_PROCESOADQ"))
    private Procesoadquisicion procesoadq;

    @ManyToOne
    @JoinColumn(name = "id_detallecompra",foreignKey = @ForeignKey(name = "FK_FECHA_DETALLECOMPRA"))
    private Detallecompra detallecompra;

}
