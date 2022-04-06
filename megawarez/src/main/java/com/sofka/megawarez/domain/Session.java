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
@Table(name = "session")
public class Session implements Serializable {

    /**
     * Variable usada para manejar el tema del identificador de la tupla (consecutivo)
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ses_id", nullable = false)
    private Integer id;

    @ManyToOne(
            fetch = FetchType.LAZY,
            targetEntity = Usuario.class,
            optional = false)
    @JoinColumn(name = "ses_usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "ses_token", nullable = false, length = 32)
    private String token;

    @Column(name = "ses_created_at", nullable = false)
    private Instant createdAt;

}