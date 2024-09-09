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
@Table(name = "tbl_usuarioroles")
public class Usuarioroles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idUsuarioroles;

    @ManyToOne
    @JoinColumn(name = "id_roles",foreignKey = @ForeignKey(name = "FK_ROLES_USUARIO"))
    private Roles roles;

    @ManyToOne
    @JoinColumn(name = "id_ususario", foreignKey = @ForeignKey(name = "FK_USUARIO_ROLES"))
    private Usuario usuario;

}
