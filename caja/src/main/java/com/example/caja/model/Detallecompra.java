package com.example.caja.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_detallecompra")
public class Detallecompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idDetallecompra;

    @ManyToOne
    @JoinColumn(name = "id_proyecto",foreignKey = @ForeignKey(name = "FK_DETALLECOMPRA_PROYECTO"))
    private Proyecto proyecto;

    @ManyToOne
    @JoinColumn(name = "id_estado",foreignKey = @ForeignKey(name = "FK_DETALLECOMPRA_ESTADO"))
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "id_producto",foreignKey = @ForeignKey(name = "FK_DETALLECOMPRA_PRODUCTO"))
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_compra",foreignKey = @ForeignKey(name = "FK_DETALLECOMPRA_COMPRA"))
    private Compra compra;

    @Column(length = 200)
    private String notaObservacion;

    @Column(nullable = false,length = 20)
    private String nroOrden;

    @Column(nullable = false)
    private Float monto;
}
