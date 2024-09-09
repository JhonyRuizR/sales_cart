package com.example.caja.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_trabajador")
public class Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idTrabajador;

    @ManyToOne
    @JoinColumn(name = "id_persona",foreignKey = @ForeignKey(name = "FK_TRABAJADOR_PERSONA"))
    private Persona persona;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tbl_trabajador_oficina",
            joinColumns = @JoinColumn(name = "id_trabajador"),
            foreignKey = @ForeignKey(name = "FK_TRABAJADOR_OFICINA"),
            inverseJoinColumns = @JoinColumn(name = "id_oficina"),
            inverseForeignKey = @ForeignKey(name = "FK_OFICINA_TRABAJADOR")
    )
    private List<Oficina> oficina;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tbl_trabajador_profesion",
            joinColumns = @JoinColumn(name = "id_trabajador"),
            foreignKey = @ForeignKey(name = "FK_TRABAJADOR_PROFESION"),
            inverseJoinColumns = @JoinColumn(name = "id_profesion"),
            inverseForeignKey = @ForeignKey(name = "FK_PROFESION_TRABAJADOR")
    )
    private List<Profesion> profesion;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tbl_trabajador_cargo",
            joinColumns = @JoinColumn(name = "id_trabajador"),
            foreignKey = @ForeignKey(name = "FK_TRABAJADOR_CARGO"),
            inverseJoinColumns = @JoinColumn(name = "id_cargo"),
            inverseForeignKey = @ForeignKey(name = "FK_CARGO_TRABAJADOR")
    )
    private List<Cargo> cargo;

    private Date fIniciocontrato;

    private Date fFincontrato;

    private Integer estado;

    @Column(length = 200)
    private String urlFoto;

    @Column(length = 200)
    private String urlQr;

    @Column(length = 50)
    private String codTrabajador;

    private Float salario;
}
