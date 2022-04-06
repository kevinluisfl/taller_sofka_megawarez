package com.sofka.megawarez.domain;

import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.Instant;

@Data
@Entity
@Table(name = "descarga")
public class Descarga implements Serializable {

    /**
     * Variable usada para manejar el tema del identificador de la tupla (consecutivo)
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dwn_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY,
            targetEntity = Usuario.class,
            optional = false)
    @JoinColumn(name = "dwn_usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY,
            targetEntity = Usuario.class,
            optional = false)
    @JoinColumn(name = "dwn_item_id", nullable = false)
    private Item item;

    @Column(name = "dwn_created_at", nullable = false)
    private Instant createdAt;

}