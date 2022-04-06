package com.sofka.megawarez.domain;

import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "item")
public class Item implements Serializable {

    /**
     * Variable usada para manejar el tema del identificador de la tupla (consecutivo)
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itm_id", nullable = false)
    private Integer id;

    @ManyToOne(
            fetch = FetchType.LAZY,
            targetEntity = Subcategoria.class,
            optional = false)
    @JoinColumn(name = "itm_subcategoria_id", nullable = false)
    private Subcategoria subcategoria;

    @Column(name = "itm_nombre", nullable = false, length = 80)
    private String nombre;

    @Column(name = "itm_created_at", nullable = false)
    private Instant createdAt;

    @OneToMany(
            fetch = FetchType.EAGER,
            targetEntity = Descarga.class,
            cascade = CascadeType.REMOVE,
            mappedBy = "item")
    private Set<Descarga> descargas = new LinkedHashSet<>();

}