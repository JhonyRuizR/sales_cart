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
@Table(name = "tbl_listapago")
public class Listapago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idListapago;

    @ManyToOne
    @JoinColumn(name = "id_compra",foreignKey = @ForeignKey(name = "FK_lISTAPAGO_COMPRA"))
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_formapago",foreignKey = @ForeignKey(name = "FK_lISTAPAGO_FORMAPAGO"))
    private Formapago formapago;

    @Column(nullable = false)
    private Float monto;
}
