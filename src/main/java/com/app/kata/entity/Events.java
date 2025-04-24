package com.app.kata.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name="events") @AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Events {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "IDEVENT", nullable = false)
    private BigInteger IDEVENT;
    @Column(name="NOMBRE", nullable=false, length=120)
    private String NOMBRE;
    @Column(name="DESCRIPCION", nullable=false, length=70)
    private String DESCRIPCION;
    @Column(name="FECHAEVENTO", nullable=false)
    private LocalDateTime FECHAEVENTO;
    @Column(name="ASISTENTESMAX", nullable=false)
    private int ASISTENTESMAX;
    @Column(name="ASISTENTESTOT", nullable=false)
    private int ASISTENTESTOT;

}
