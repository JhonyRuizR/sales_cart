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
@Table(name = "tbl_menuroles")
public class Menuroles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idMenuroles;

    @ManyToOne
    @JoinColumn(name = "id_roles",foreignKey = @ForeignKey(name = "FK_ROLES_MENU"))
    private Roles roles;

    @ManyToOne
    @JoinColumn(name = "id_menu", foreignKey = @ForeignKey(name = "FK_MENU_ROLES"))
    private Menu menu;

}

