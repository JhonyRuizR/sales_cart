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
@Table(name = "tbl_ubigeo")
public class Ubigeo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idUbigeo;

    @Column(nullable = false, length = 10)
    private String ubiPais;

    @Column(nullable = false, length = 10)
    private String ubiDepartamento;

    @Column(nullable = false, length = 10)
    private String ubiProvincia;

    @Column(nullable = false, length = 10)
    private String ubiDistrito;

    @Column(nullable = false, length = 100)
    private String nombreUbi;

    @Column(nullable = false)
    private Long poblacion;

    @Column(nullable = false, length = 25)
    private String latitud;

    @Column(nullable = false, length = 25)
    private String longitud;
}
