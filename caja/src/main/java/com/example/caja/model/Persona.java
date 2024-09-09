package com.example.caja.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_persona")
public class Persona {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersona;

    @ManyToOne
    @JoinColumn(name = "id_tipoidentidad",foreignKey = @ForeignKey(name = "FK_PERSONA_TIPOIDENTIDAD"))
    private Tipoidentidad tipoidentidad;

    @ManyToOne
    @JoinColumn(name = "id_ubigeo",foreignKey = @ForeignKey(name = "FK_PERSONA_UBIGEO"))
    private Ubigeo ubigeo;

    @Column(nullable = false,length = 25)
    private String numIdentidad;

    @Column(nullable = false,length = 50)
    private String perNombre;

    @Column(nullable = false,length = 50)
    private String perAppaterno;

    @Column(nullable = false,length = 50)
    private String perApmaterno;

    @Column(nullable = false)
    private Date fNacimiento;

    @Column(length = 20)
    private String numCelular;

    @Column(length = 50)
    private String correo;

    @Column(nullable = false,length = 10)
    private String genero;

    @Column(length = 10)
    private String estadoCivil;

    private LocalTime fRegistro;

    @Column(length = 100)
    private String direccion;
}
