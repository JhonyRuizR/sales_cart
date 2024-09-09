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
@Table(name = "tbl_producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idProducto;

    @ManyToOne
    @JoinColumn(name = "id_proveedor",foreignKey = @ForeignKey(name = "FK_PRODUCTO_PROVEEDOR"))
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "id_categoria",foreignKey = @ForeignKey(name = "FK_PRODUCTO_CATEGORIA"))
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_marca",foreignKey = @ForeignKey(name = "FK_PRODUCTO_MARCA"))
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "id_unidadmedida",foreignKey = @ForeignKey(name = "FK_PRODUCTO_UNIDADMEDIDA"))
    private Unidadmedida unidadmedida;

    @ManyToOne
    @JoinColumn(name = "id_actividad",foreignKey = @ForeignKey(name = "FK_PRODUCTO_ACTIVIDAD"))
    private Actividad actividad;

    @Column(nullable = false,length = 10)
    private String codigo;

    @Column(nullable = false,length = 100)
    private String nombreProducto;

    private Integer pActivo;

    @Column(nullable = false,length = 10)
    private String cDigemid;

    @Column(nullable = false,length = 100)
    private String patologia;

    @Column(nullable = false,length = 10)
    private String cSanitario;

    private Float pUnitario01;

    private Float pUnitario02;

    private Float pUnitario03;

    private Float pBlister;

    private Float pCaja;

    private Integer stockMin;

    private Integer stockMax;

    private Integer stockActualunidad;

    private Integer stockActualblister;

    private Integer stockActualcaja;

    @Column(nullable = false,length = 100)
    private String forma;

    @Column(nullable = false,length = 100)
    private String laboratorio;

    @Column(nullable = false,length = 100)
    private String nombreGenetico;

    @Column(nullable = false,length = 100)
    private String codigoAfectacion;

    @Column(nullable = false,length = 10)
    private String tipoInpuesto;
}
