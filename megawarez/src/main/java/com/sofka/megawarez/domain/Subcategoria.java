package com.sofka.megawarez.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "subcategoria")
public class Subcategoria implements Serializable {

    /**
     * Variable usada para manejar el tema del identificador de la tupla (consecutivo)
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scat_id", nullable = false)
    private Integer id;

    @ManyToOne(
            fetch = FetchType.LAZY,
            targetEntity = Categoria.class,
            optional = false )
    @JoinColumn(name = "scat_categoria_id", nullable = false)
    private Categoria categoria;

    @Column(name = "scat_nombre", nullable = false, length = 80)
    private String nombre;

    @Column(name = "scat_created_at", nullable = false)
    private Instant createdAt;

    @OneToMany(
            fetch = FetchType.EAGER,
            targetEntity = Item.class,
            cascade = CascadeType.REMOVE,
            mappedBy = "subcategoria")
    private Set<Item> items = new LinkedHashSet<>();
}