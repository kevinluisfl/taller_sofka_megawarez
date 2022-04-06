package com.sofka.megawarez.domain;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    /**
     * Variable usada para manejar el tema del identificador de la tupla (consecutivo)
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id", nullable = false)
    private Integer id;

    @Column(name = "cat_nombre", nullable = false, length = 80)
    private String nombre;

    @Column(name = "cat_created_at", nullable = false)
    private Instant createdAt;

    @OneToMany(
            fetch = FetchType.EAGER,
            targetEntity = Subcategoria.class,
            cascade = CascadeType.REMOVE,
            mappedBy = "categoria")
    private Set<Subcategoria> subcategorias = new LinkedHashSet<>();

}