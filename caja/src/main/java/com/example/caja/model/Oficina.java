package com.example.caja.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_oficina")
public class Oficina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idOficina;

    @Column(nullable = false, length = 100)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_tipooficina",foreignKey = @ForeignKey(name = "FK_OFICINA_TIPOOFICINA"))
    private Tipooficina tipooficina;

    @ManyToMany(mappedBy = "oficina")
    private List<Trabajador> trabajador;
}
