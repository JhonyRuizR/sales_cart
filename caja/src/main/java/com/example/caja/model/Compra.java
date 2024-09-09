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
@Table(name = "tbl_compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idCompra;

    @ManyToOne
    @JoinColumn(name = "id_comprobante",foreignKey = @ForeignKey(name = "FK_COMPRA_COMPROBANTE"))
    private Comprobante comprobante;

    @ManyToOne
    @JoinColumn(name = "id_usuario",foreignKey = @ForeignKey(name = "FK_COMPRA_USUARIO"))
    private Usuario usuario;

    private LocalTime fRegistro;

    private LocalTime fCronograma;

    @Column(nullable = false,length = 20)
    private String nroCompra;

    @Column(nullable = false,length = 20)
    private String nroGuia;

    @Column(nullable = false)
    private Double montoTotal;
}
