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
@Table(name = "usuario")
public class Usuario implements Serializable {

    /**
     * Variable usada para manejar el tema del identificador de la tupla (consecutivo)
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id", nullable = false)
    private Integer id;

    @Column(name = "usu_username", nullable = false, length = 80)
    private String username;

    @Column(name = "usu_password", nullable = false, length = 32)
    private String password;

    @Column(name = "usu_created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "usu_updated_at")
    private Instant updatedAt;

    @OneToMany(
            fetch = FetchType.EAGER,
            targetEntity = Descarga.class,
            cascade = CascadeType.REMOVE,
            mappedBy = "usuario")
    private Set<Descarga> descargas = new LinkedHashSet<>();

    @OneToMany(
            fetch = FetchType.EAGER,
            targetEntity = Session.class,
            cascade = CascadeType.REMOVE,
            mappedBy = "usuario")
    private Set<Session> sessions = new LinkedHashSet<>();

}